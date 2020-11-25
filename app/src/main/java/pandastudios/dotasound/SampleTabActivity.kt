package pandastudios.dotasound

import android.content.Context
import android.net.Uri
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.firebase.storage.FirebaseStorage
import com.muddzdev.styleabletoastlibrary.StyleableToast

import kotlinx.android.synthetic.main.activity_sample_tab.*
import kotlinx.android.synthetic.main.downloader_ui.*
import kotlinx.android.synthetic.main.fragment_sample_tab.view.*
import kotlinx.android.synthetic.main.splash_sounds_not_downloaded.*
import net.lingala.zip4j.core.ZipFile
import net.lingala.zip4j.exception.ZipException
import pandastudios.dotasound.R.id.tl_categories
import pandastudios.dotasound.arrays.MiscArrays
import pandastudios.dotasound.data.DbHelper
import java.io.File

class SampleTabActivity : AppCompatActivity(), OnAssignHeroesCompleted {

    private val LOG_TAG: String = SampleTabActivity::class.java.simpleName
    private lateinit var dbHelper: DbHelper

    private lateinit var miscArrays: MiscArrays
    var loadingTextArray: Array<String>? = null
    val handler = Handler()

    private var favourited = false
    private var favouriteInitialised = false

    private var isPhone = false
    private var isLandscape = false
    private var isTen = false

    val soundsListAttack = ArrayList<Sound>()
    val soundsListAbilities = ArrayList<Sound>()
    val soundsListItems = ArrayList<Sound>()
    val soundsListHeroRelated = ArrayList<Sound>()
    val soundsListMisc = ArrayList<Sound>()

    var heroKey = ""
    private var imageRes = R.drawable.board_header_ti7

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    var musicRecycler: SoundsRecycler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_tab)

        // Init main functions
        btn_sounds_not_downloaded.setOnClickListener { downloadSoundboard() }
        assignHeroToLists()
        setupToolbar()
        setupAds()

        // Init everything else
        dbHelper = DbHelper(this)
        favourited = dbHelper.isFavourite(heroKey)
    }

    private fun downloadSoundboard() {
        // Setup Firebase Storage
        val storage = FirebaseStorage.getInstance()
        val heroRef = storage.reference.child("sounds").child("${heroKey.toLowerCase().replace(" ", "")}.zip")

        // Setup local file
        val heroFile = File(getExternalFilesDir(Environment.DIRECTORY_MUSIC), heroKey.replace(" ", ""))

        // Prepare the UI
        splash_sounds_not_downloaded.visibility = View.GONE
        pb_soundboard.visibility = View.VISIBLE
        tv_progress.text = getString(R.string.downloading_hero, heroKey)

        // Download the file
        heroRef.getFile(heroFile).addOnCompleteListener {
            if (it.isCanceled) {
                // Handle error
                Log.e(LOG_TAG, "Error downloading sounds: ${it.exception?.message}")
                pb_soundboard.visibility = View.GONE
                splash_sounds_not_downloaded.visibility = View.VISIBLE
                tv_sounds_not_downloaded.text = getString(R.string.error_downloading_sounds)
                return@addOnCompleteListener
            }

            // DOWNLOAD COMPLETE
            unzipHero(heroFile.path)
        }
    }

    fun reunzipHero() {
        val heroFile = File(getExternalFilesDir(Environment.DIRECTORY_MUSIC), heroKey.replace(" ", ""))
        unzipHero(heroFile.path)
    }

    fun unzipHero(path: String) {
        pb_soundboard.visibility = View.VISIBLE
        container.visibility = View.INVISIBLE
        tv_progress.text = getString(R.string.unzipping_hero, heroKey)

        val lastPathSegment = Uri.parse(path).lastPathSegment
        val destination = if (lastPathSegment == "Music") {
            path.dropLast(6)
        } else {
            path.replace(Uri.parse(path).lastPathSegment, "")
        }

        try {
            ZipFile(path).extractAll(destination)
            assignHeroToLists()
        } catch (e: ZipException) {
            e.printStackTrace()
            downloadSoundboard()
        }
    }

    private fun assignHeroToLists() {
        // Get the hero key
        heroKey = intent.getStringExtra(getString(R.string.KEY_HERO))

        // Load arrays in the background
        handler.postDelayed(toggleLoadingText(), 5000)
        AssignHeroesTask(this, this).execute(heroKey)
    }

    override fun onAssignHeroesCompleted(available: Boolean, bundle: Bundle) {
        // Update the UI
        pb_soundboard.visibility = View.GONE
        container.visibility = View.VISIBLE
        handler.removeCallbacksAndMessages(null)

        if (!available) {
            splash_sounds_not_downloaded.visibility = View.VISIBLE
            return
        } else {
            splash_sounds_not_downloaded.visibility = View.GONE
        }

        // Clear the arrays
        soundsListAttack.clear()
        soundsListAbilities.clear()
        soundsListItems.clear()
        soundsListHeroRelated.clear()
        soundsListMisc.clear()

        // Add to the Arrays
        imageRes = bundle.getInt("imageRes")
        soundsListAttack.addAll(bundle.getSerializable("soundsListAttack") as ArrayList<Sound>)
        soundsListAbilities.addAll(bundle.getSerializable("soundsListAbilities") as ArrayList<Sound>)
        soundsListItems.addAll(bundle.getSerializable("soundsListItems") as ArrayList<Sound>)
        soundsListHeroRelated.addAll(bundle.getSerializable("soundsListHeroRelated") as ArrayList<Sound>)
        soundsListMisc.addAll(bundle.getSerializable("soundsListMisc") as ArrayList<Sound>)

        // Assign the Arrays to the Lists
        setupTabs()
        iv_background.setImageResource(imageRes)

        // Add the hero to the recents
        dbHelper.insertRecent(heroKey, imageRes)
    }

    private fun toggleLoadingText(): Runnable = Runnable {
        val choice = Math.floor(Math.random() * loadingTextArray!!.size).toInt()
        tv_progress.text = loadingTextArray!![choice]
        handler.postDelayed(toggleLoadingText(), 5000)
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        toolbar_title.text = heroKey

        if (intent.getIntExtra(getString(R.string.INTENT_SELECTING_SOUND), -1) >= 0) {
            toolbar_title.text = getString(R.string.selecting_sound)
        }
    }

    private fun setupAds() {
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }

    private fun toggleFavourite(item: MenuItem) {
        if (!favouriteInitialised) {
            favouriteInitialised = true
            if (favourited) item.setIcon(R.drawable.ic_star_white_24dp)
            else item.setIcon(R.drawable.ic_star_border_white_24dp)

        } else if (favourited) {
            favourited = false
            item.setIcon(R.drawable.ic_star_border_white_24dp)
            dbHelper.deleteFavourite(heroKey)
            StyleableToast.makeText(this, getString(R.string.removed_from_favourites),
                    Toast.LENGTH_SHORT, R.style.DotaToast).show()

        } else {
            favourited = true
            item.setIcon(R.drawable.ic_star_white_24dp)
            dbHelper.insertFavourite(heroKey, imageRes)
            StyleableToast.makeText(this, getString(R.string.added_to_favourites),
                    Toast.LENGTH_SHORT, R.style.DotaToast).show()
        }
    }

    private fun setStopVisibility(item: MenuItem) {
        if (isHeroKeyMusic()) item.isVisible = true
    }

    fun isHeroKeyMusic(): Boolean {
        return heroKey == getString(R.string.music)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isHeroKeyMusic()) musicRecycler?.stopMusic()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_soundboard, menu)
        toggleFavourite(menu.findItem(R.id.ic_favourite))
        setStopVisibility(menu.findItem(R.id.ic_stop))
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.ic_stop -> {
                musicRecycler?.let { it.stopMusic() }
                true
            }
            R.id.ic_favourite -> {
                toggleFavourite(item)
                true
            }
            else -> false
        }
    }

    private fun setupTabs() {
        val iconRes = when (heroKey) {

            getString(R.string.music) -> arrayOf(R.drawable.ic_music_note_white_24dp)
            getString(R.string.rickandmorty) -> arrayOf(
                    R.drawable.ic_sword,
                    R.drawable.ic_person_white_24dp,
                    R.drawable.ic_music_note_white_24dp)

            else -> arrayOf(
                    R.drawable.ic_sword,
                    R.drawable.ic_add_white_24dp,
                    R.drawable.ic_fitness_center_white_24dp,
                    R.drawable.ic_person_white_24dp,
                    R.drawable.ic_music_note_white_24dp
            )
        }

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        addFragments()

        container.adapter = mSectionsPagerAdapter
        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tl_categories))
        tl_categories.setupWithViewPager(container)
        tl_categories.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))

        for (i in 0 until tl_categories.tabCount) {
            tl_categories.getTabAt(i)?.icon = getDrawable(iconRes[i])
        }
    }

    private fun addFragments() {
        if (soundsListAttack.isNotEmpty()) mSectionsPagerAdapter!!.addFragment(PlaceholderFragment.newInstance(soundsListAttack))
        if (soundsListAbilities.isNotEmpty()) mSectionsPagerAdapter!!.addFragment(PlaceholderFragment.newInstance(soundsListAbilities))
        if (soundsListItems.isNotEmpty()) mSectionsPagerAdapter!!.addFragment(PlaceholderFragment.newInstance(soundsListItems))
        if (soundsListHeroRelated.isNotEmpty()) mSectionsPagerAdapter!!.addFragment(PlaceholderFragment.newInstance(soundsListHeroRelated))
        if (soundsListMisc.isNotEmpty()) mSectionsPagerAdapter!!.addFragment(PlaceholderFragment.newInstance(soundsListMisc))
    }


    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        private val fragments = ArrayList<Fragment>()

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return fragments[position]
        }

        fun addFragment(fragment: Fragment) {
            fragments.add(fragment)
        }

    }

    class PlaceholderFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater.inflate(R.layout.fragment_sample_tab, container, false)
            val activity = context as SampleTabActivity
            val numColumns = 2
            val sounds = arguments?.getSerializable("sounds") as ArrayList<Sound>

            val soundsRecycler = SoundsRecycler(activity, sounds)

            // To Enable stopping music
            val soundboardActivity = getActivity() as SampleTabActivity

            if (soundboardActivity.heroKey == getString(R.string.music)) {
                soundboardActivity.musicRecycler = soundsRecycler
                rootView.sounds_grid.adapter = soundsRecycler
            } else {
                rootView.sounds_grid.adapter = soundsRecycler
            }

            rootView.sounds_grid.layoutManager = GridLayoutManager(activity, numColumns)
            rootView.sounds_grid.addItemDecoration(SpacesItemDecoration(resources.getDimension(R.dimen.grid_spacing).toInt(), numColumns))

            return rootView
        }

        companion object {
            fun newInstance(sounds: ArrayList<Sound>): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putSerializable("sounds", sounds)
                fragment.arguments = args
                return fragment
            }
        }

    }
}
