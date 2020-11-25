package pandastudios.dotasound

import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.media.AudioManager
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import pandastudios.dotasound.arrays.MiscArrays
import pandastudios.dotasound.data.DbHelper
import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import android.content.ActivityNotFoundException

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    val LOG_TAG = MainActivity::class.java.simpleName
    private lateinit var dbHelper: DbHelper

    var favouritesList: ArrayList<Board>? = null
    lateinit var recentsList: ArrayList<Board>
    var expanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        volumeControlStream = AudioManager.STREAM_MUSIC
        dbHelper = DbHelper(this)

        // Set the custom toolbar
        setSupportActionBar(toolbar)
        title = ""

        // Initialise the navigation drawer
        setupNavigationDrawer()

        // Initialise Ads
        setupAds()

        // Initialise the favourites and recents
        setupLists()

        // Pick a random soundboard for the discover board
        setupDiscover()
    }

    override fun onStart() {
        super.onStart()
        favouritesList?.let { refreshLists() }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_about -> {
            startActivity(Intent(this@MainActivity, AboutActivity::class.java))
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    private fun setupNavigationDrawer() {
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        if (drawer_layout != null) {
            drawer_layout.setDrawerListener(toggle)
            toggle.syncState()
        }

        navigation.setNavigationItemSelectedListener(this)

        // Set icon colour
        navigation.itemTextColor = ColorStateList.valueOf(resources.getColor(R.color.textColor))
        navigation.itemIconTintList = ColorStateList.valueOf(resources.getColor(R.color.textColor))
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.nav_heroes -> {
            startActivity(Intent(this, HeroesActivity::class.java))
            true
        }
        R.id.nav_launchpad -> {
            startActivity(Intent(this, LaunchpadActivity::class.java))
            true
        }
        R.id.nav_misc -> {
            startActivity(Intent(this, MiscActivity::class.java))
            true
        }
        R.id.nav_settings -> {
            startActivity(Intent(this, AboutActivity::class.java))
            true
        }
        R.id.nav_feedback -> {
            openFeedbackDialog()
            true
        }
//        R.id.nav_share_facebook -> {
////            val portrait = ShareLinkContent.Builder()
////                    .setContentUrl(Uri.parse("https://play.google.com/store/apps/details?id=pandastudios.dotasound"))
////                    .build()
////            ShareDialog.show(this, portrait)
//            StyleableToast.makeText(this, "Not yet implemented", Toast.LENGTH_SHORT, R.style.DotaToast).show()
//            true
//        }
//        R.id.nav_share_twitter -> {
////            shareToTwitter()
//            StyleableToast.makeText(this, "Not yet implemented", Toast.LENGTH_SHORT, R.style.DotaToast).show()
//            true
//        }
//        R.id.nav_review -> {
////            val uri = Uri.parse("market://details?id=" + packageName)
////            val openPlayStore = Intent(Intent.ACTION_VIEW, uri)
////            try {
////                startActivity(openPlayStore)
////            } catch (e: ActivityNotFoundException) {
////                Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show()
////            }
//
//            StyleableToast.makeText(this, "Not yet implemented", Toast.LENGTH_SHORT, R.style.DotaToast).show()
//            true
//        }
        else -> false
    }

    private fun openFeedbackDialog() {
        AlertDialog.Builder(this)
                .setItems(R.array.dialog_feedback_options) { dialogInterface, choice ->
                    when (choice) {
                        0 -> {
                            // Send an Email
                            val intent = Intent(Intent.ACTION_SENDTO)
                            intent.data = Uri.parse("mailto:tinker@dota2soundboard.com?subject=${getString(R.string.feedback_email_subject)}")
                            startActivity(intent)
                        }
                        1 -> {
                            // Leave a Review
                            val uri = Uri.parse("market://details?id=$packageName")
                            val goToMarket = Intent(Intent.ACTION_VIEW, uri)

                            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or
                                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
                            try {
                                startActivity(goToMarket)
                            } catch (e: ActivityNotFoundException) {
                                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=$packageName")))
                            }
                        }
                    }
                }.show()
    }

    private fun setupAds() {
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }

    private fun setupLists() {
        favouritesList = dbHelper.getFavouritesList()
        recentsList = dbHelper.getRecentsList()

        favourites_list.adapter = HomeRecycler(this, favouritesList!!)
        favourites_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recents_list.adapter = HomeRecycler(this, recentsList)
        recents_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        favourites_title.setOnClickListener { startActivity(Intent(this, FavouritesActivity::class.java)) }
    }

    private fun refreshLists() {
        favouritesList?.clear()
        recentsList.clear()
        favouritesList?.addAll(dbHelper.getFavouritesList())
        recentsList.addAll(dbHelper.getRecentsList())
        favourites_list.adapter.notifyDataSetChanged()
        recents_list.adapter.notifyDataSetChanged()
    }

    private fun setupDiscover() {
        val titleArray: Array<String>
        val imageArray: Array<Int>

        // Do a random for the general board category to choose from
        val miscArrays = MiscArrays(this)
        val boardCategory = Math.floor(Math.random() * 70).toInt()

        if (boardCategory > 20) {
            titleArray = resources.getStringArray(R.array.strength_heroes)
            imageArray = miscArrays.strength_board_headers
        } else if (boardCategory > 40) {
            titleArray = resources.getStringArray(R.array.agility_heroes)
            imageArray = miscArrays.agility_board_headers
        } else if (boardCategory > 60) {
            titleArray = resources.getStringArray(R.array.intelligence_heroes)
            imageArray = miscArrays.intelligence_board_headers
        } else {
            titleArray = resources.getStringArray(R.array.misc_items)
            imageArray = miscArrays.misc_items
        }

        // Now randomise between a random item in the array
        if (titleArray.size != imageArray.size) {
            Log.w(LOG_TAG, "WARNING: Title array and image array are of different sizes")
            discover_title.text = titleArray[0]
            (discover_image as ImageView).setImageResource(imageArray[0])
            return
        }

        val max = titleArray.size
        val index = Math.floor(Math.random() * max).toInt()
        val title = titleArray[index]
        val imageRes = imageArray[index]

        // Set the discover board
        discover_title.text = title
        (discover_image as ImageView).setImageResource(imageRes)
        discover_image.setOnClickListener {
            val intent = Intent(this, SampleTabActivity::class.java)
            intent.putExtra(getString(R.string.KEY_HERO), title)
            startActivity(intent)
        }
    }

    fun shareToTwitter() {
        val tweetIntent = Intent(Intent.ACTION_SEND)
        val message = "${getString(R.string.intent_share)}\n\nhttps://play.google.com/store/apps/details?id=com.pdt.plume"
        tweetIntent.putExtra(Intent.EXTRA_TEXT, message)
        tweetIntent.type = "text/plain"

        val packManager = packageManager
        val resolvedInfoList = packManager.queryIntentActivities(tweetIntent, PackageManager.MATCH_DEFAULT_ONLY);

        var resolved = false
        for (resolveInfo in resolvedInfoList) {
            if (resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")) {
                tweetIntent.setClassName(
                        resolveInfo.activityInfo.packageName,
                        resolveInfo.activityInfo.name)
                resolved = true
                break
            }
        }
        if (resolved) {
            startActivity(tweetIntent);
        } else {
            val i = Intent()
            val message = "${getString(R.string.intent_share)}\nhttps://play.google.com/store/apps/details?id=pandastudios.dotasound"
            i.putExtra(Intent.EXTRA_TEXT, message)
            i.action = Intent.ACTION_VIEW
            i.data = Uri.parse("https://twitter.com/intent/tweet?text=" + urlEncode("https://play.google.com/store/apps/details?id=com.pdt.plume"))
            startActivity(i)
            Toast.makeText(this, "Twitter app isn't found", Toast.LENGTH_LONG).show()
        }
    }

    private fun urlEncode(s: String): String {
        return try {
            URLEncoder.encode(s, "UTF-8")
        } catch (e: UnsupportedEncodingException) {
            Log.wtf(LOG_TAG, "UTF-8 should always be supported", e)
            ""
        }

    }

}
