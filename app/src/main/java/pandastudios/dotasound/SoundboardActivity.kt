package pandastudios.dotasound

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_soundboard.*
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.muddzdev.styleabletoastlibrary.StyleableToast
import pandastudios.dotasound.data.DbHelper


@Suppress("PLUGIN_WARNING")
class SoundboardActivity : AppCompatActivity() {

    private val LOG_TAG: String = SoundboardActivity::class.java.simpleName
    private lateinit var soundArrays: SoundArrays
    private lateinit var dbHelper: DbHelper

    private var favourited = false
    private var favouriteInitialised = false

    private var isPhone = false
    private var isLandscape = false
    private var isTen = false

    private var id_attack: Int = -1
    private var id_ability: Int = -1

    private val currentSoundsList = ArrayList<Sound>()
    private val currentSoundsListUnmorphed = ArrayList<Sound>()
    private val currentSoundsListMorphed = ArrayList<Sound>()
    private lateinit var soundsRecycler: SoundsRecycler

    private val soundsListAttack = ArrayList<Sound>()
    private val soundsListAttackMorphed = ArrayList<Sound>()
    private val soundsListAbilities = ArrayList<Sound>()
    private val soundsListAbilitiesMorphed = ArrayList<Sound>()

    private var heroKey = ""
    private var imageRes = R.drawable.board_header_ti7
    private var morphed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soundboard)

        isPhone = resources.getBoolean(R.bool.is_phone)
        isLandscape = resources.getBoolean(R.bool.is_landscape)
        isTen = resources.getBoolean(R.bool.is_ten)

        this.soundArrays = SoundArrays(this)
        heroKey = intent.getStringExtra(getString(R.string.KEY_HERO))
        dbHelper = DbHelper(this)
        favourited = dbHelper.isFavourite(heroKey)

        // Setup the elements of the activity
        setupToolbar()
        setupGrids()
        setupCategories()
        setupAds()
    }

    private fun setupCategories() {
        // Get the ids of each button
        id_attack = category_attack.id
        id_ability = category_abilities.id

        // Set category icons
        category_attack.setImageResource(R.drawable.ic_sword)
        category_abilities.setImageResource(R.drawable.ic_add_white_24dp)

        // Hide empty categories
        if (soundsListAttack.size == 0) category_attack.visibility = View.GONE
        if (soundsListAbilities.size == 0) category_abilities.visibility = View.GONE

        sound_categories.setOnCheckedChangeListener { _, checkedId ->
            currentSoundsListUnmorphed.clear()
            currentSoundsListMorphed.clear()
            currentSoundsList.clear()

            when (checkedId) {
                id_attack -> {
                    currentSoundsListUnmorphed.addAll(soundsListAttack)
                    currentSoundsListMorphed.addAll(soundsListAttackMorphed)
                }
                id_ability -> {
                    currentSoundsListUnmorphed.addAll(soundsListAbilities)
                    currentSoundsListMorphed.addAll(soundsListAbilitiesMorphed)
                }
                else -> {
                    currentSoundsListUnmorphed.addAll(soundsListAttack)
                    currentSoundsListMorphed.addAll(soundsListAttackMorphed)
                }
            }

            currentSoundsList.addAll(if (!morphed) currentSoundsListUnmorphed else currentSoundsListMorphed)
            soundsRecycler.notifyDataSetChanged()
        }
    }

    private fun setupAds() {
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        if (isPhone) {
            collapsing_toolbar.setExpandedTitleTypeface(Typeface.createFromAsset(assets, "font/radiance.otf"))
            collapsing_toolbar.setExpandedTitleColor(resources.getColor(R.color.textColor))
            collapsing_toolbar.setCollapsedTitleTypeface(Typeface.createFromAsset(assets, "font/radiance.otf"))
            collapsing_toolbar.setCollapsedTitleTextColor(resources.getColor(R.color.textColor))
            collapsing_toolbar.title = heroKey
        }

        // Initialise the favourites button
        if (!isPhone) {
            if (isLandscape) soundboard_title.text = heroKey
            else collapsing_toolbar.title = heroKey
        }
    }

    private fun setupGrids() {
        val numColumns = if (isTen) 3 else 2

        assignHeroToLists()

        currentSoundsListUnmorphed.addAll(soundsListAttack)
        currentSoundsListMorphed.addAll(soundsListAttackMorphed)
        currentSoundsList.addAll(currentSoundsListUnmorphed)

        soundsRecycler = SoundsRecycler(this, currentSoundsList)
        sounds_grid.adapter = soundsRecycler
        sounds_grid.layoutManager = GridLayoutManager(this, numColumns)
        sounds_grid.addItemDecoration(SpacesItemDecoration(resources.getDimension(R.dimen.grid_spacing).toInt(), numColumns))

        // Setup the morph button
        if (heroHasMorph()) {
            morph_button.visibility = View.VISIBLE
            morph_button.setOnClickListener { toggleMorph() }
        }

    }

    private fun toggleMorph() {
        morphed = !morphed
        morph_button.setImageResource(if (morphed) R.drawable.ic_morphed_silver else R.drawable.ic_unmorphed_silver)
        currentSoundsList.clear()
        currentSoundsList.addAll(if (morphed) currentSoundsListMorphed else currentSoundsListUnmorphed)
        soundsRecycler.notifyDataSetChanged()
    }

    private fun heroHasMorph(): Boolean = when (heroKey) {
        getString(R.string.Alchemist) -> true
        else -> false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return if (menu != null) {
            menuInflater.inflate(R.menu.menu_soundboard, menu)
            toggleFavourite(menu.findItem(R.id.ic_favourite))
            true
        } else false
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null && item.itemId == R.id.ic_favourite) {
            toggleFavourite(item)
            return true
        }
        return super.onOptionsItemSelected(item)
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

    private fun assignHeroToLists() {
        val soundResListAttack = ArrayList<Int>()
        val soundResListAttackMorphed = ArrayList<Int>()
        val soundTitlesListAttack = ArrayList<String>()

        val soundResListAbilities = ArrayList<Int>()
        val soundResListAbilitiesMorphed = ArrayList<Int>()
        val soundTitlesListAbilities = ArrayList<String>()

        when (heroKey) {
            getString(R.string.ti7) -> {
                imageRes = soundArrays.ti7_board_header
                soundResListAttack.addAll(soundArrays.ti7_sound_res)
                soundTitlesListAttack.addAll(soundArrays.ti7_sound_titles)
            }

            getString(R.string.Abaddon) -> {
                imageRes = soundArrays.board_header_abaddon
                soundResListAttack.addAll(soundArrays.abaddon_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.abaddon_sound_titles_attack)
                soundResListAbilities.addAll(soundArrays.abaddon_sound_res_abilities)
                soundTitlesListAbilities.addAll(soundArrays.abaddon_sound_titles_abilities)
            }

            getString(R.string.Alchemist) -> {
                imageRes = soundArrays.board_header_alchemist
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundResListAttackMorphed.addAll(soundArrays.alchemist_sound_res_attack_morphed)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
                soundResListAbilities.addAll(soundArrays.alchemist_sound_res_abilities)
                soundResListAbilitiesMorphed.addAll(soundArrays.alchemist_sound_res_abilities_morphed)
                soundTitlesListAbilities.addAll(soundArrays.alchemist_sound_titles_abilities)
            }

            getString(R.string.Axe) -> {
                imageRes = soundArrays.board_header_axe
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
                soundResListAbilities.addAll(soundArrays.alchemist_sound_res_abilities)
                soundTitlesListAbilities.addAll(soundArrays.alchemist_sound_titles_abilities)
            }

            getString(R.string.Beastmaster) -> {
                imageRes = soundArrays.board_header_beastmaster
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Brewmaster) -> {
                imageRes = soundArrays.board_header_brewmaster
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Bristleback) -> {
                imageRes = soundArrays.board_header_bristleback
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Centaur) -> {
                imageRes = soundArrays.board_header_centaur
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Chaosknight) -> {
                imageRes = soundArrays.board_header_ck
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Clockwerk) -> {
                imageRes = soundArrays.board_header_clock
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Doom) -> {
                imageRes = soundArrays.board_header_doom
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Dragonknight) -> {
                imageRes = soundArrays.board_header_dk
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Earthspirit) -> {
                imageRes = soundArrays.board_header_earth
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Earthshaker) -> {
                imageRes = soundArrays.board_header_es
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Eldertitan) -> {
                imageRes = soundArrays.board_header_elder
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Huskar) -> {
                imageRes = soundArrays.board_header_huskar
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Io) -> {
                imageRes = soundArrays.board_header_io
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Kunkka) -> {
                imageRes = soundArrays.board_header_kunkka
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Legioncommander) -> {
                imageRes = soundArrays.board_header_lc
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Lifestealer) -> {
                imageRes = soundArrays.board_header_lifestealer
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Lycan) -> {
                imageRes = soundArrays.board_header_lycan
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Magnus) -> {
                imageRes = soundArrays.board_header_magnus
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Nightstalker) -> {
                imageRes = soundArrays.board_header_ns
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Omniknight) -> {
                imageRes = soundArrays.board_header_omniknight
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Phoenix) -> {
                imageRes = soundArrays.board_header_phoenix
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Pudge) -> {
                imageRes = soundArrays.board_header_pudge
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Sandking) -> {
                imageRes = soundArrays.board_header_sk
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Slardar) -> {
                imageRes = soundArrays.board_header_slardar
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Spiritbreaker) -> {
                imageRes = soundArrays.board_header_sb
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Sven) -> {
                imageRes = soundArrays.board_header_sven
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Tidehunter) -> {
                imageRes = soundArrays.board_header_tide
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Timbersaw) -> {
                imageRes = soundArrays.board_header_timber
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Tiny) -> {
                imageRes = soundArrays.board_header_tiny
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Treantprotector) -> {
                imageRes = soundArrays.board_header_treant
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Tusk) -> {
                imageRes = soundArrays.board_header_tusk
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Underlord) -> {
                imageRes = soundArrays.board_header_underlord
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Undying) -> {
                imageRes = soundArrays.board_header_undying
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Wraithking) -> {
                imageRes = soundArrays.board_header_wk
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Antimage) -> {
                imageRes = soundArrays.board_header_antimage
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Arcwarden) -> {
                imageRes = soundArrays.board_header_arc
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Bloodseeker) -> {
                imageRes = soundArrays.board_header_bloodseeker
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Bountyhunter) -> {
                imageRes = soundArrays.board_header_bh
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Broodmother) -> {
                imageRes = soundArrays.board_header_brood
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Clinkz) -> {
                imageRes = soundArrays.board_header_clinkz
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Drowranger) -> {
                imageRes = soundArrays.board_header_drow
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Emberspirit) -> {
                imageRes = soundArrays.board_header_ember
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Facelessvoid) -> {
                imageRes = soundArrays.board_header_faceless
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Gyrocopter) -> {
                imageRes = soundArrays.board_header_gyro
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Juggernaut) -> {
                imageRes = soundArrays.board_header_juggernaut
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Lonedruid) -> {
                imageRes = soundArrays.board_header_ld
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Luna) -> {
                imageRes = soundArrays.board_header_luna
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Medusa) -> {
                imageRes = soundArrays.board_header_medusa
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Meepo) -> {
                imageRes = soundArrays.board_header_meepo
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Mirana) -> {
                imageRes = soundArrays.board_header_mirana
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Monkeyking) -> {
                imageRes = soundArrays.board_header_mk
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Morphling) -> {
                imageRes = soundArrays.board_header_morph
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Nagasiren) -> {
                imageRes = soundArrays.board_header_naga
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Nyx) -> {
                imageRes = soundArrays.board_header_nyx
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Pangolier) -> {
                imageRes = soundArrays.board_header_pango
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Phantomassassin) -> {
                imageRes = soundArrays.board_header_pa
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Phantomlancer) -> {
                imageRes = soundArrays.board_header_pl
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Razor) -> {
                imageRes = soundArrays.board_header_razor
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Riki) -> {
                imageRes = soundArrays.board_header_riki
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Shadowfiend) -> {
                imageRes = soundArrays.board_header_sf
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Slark) -> {
                imageRes = soundArrays.board_header_slark
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Sniper) -> {
                imageRes = soundArrays.board_header_sniper
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Spectre) -> {
                imageRes = soundArrays.board_header_spectre
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Templarassassin) -> {
                imageRes = soundArrays.board_header_ta
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Terrorblade) -> {
                imageRes = soundArrays.board_header_terrorblade
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Trollwarlord) -> {
                imageRes = soundArrays.board_header_troll
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Ursa) -> {
                imageRes = soundArrays.board_header_ursa
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Vengefulspirit) -> {
                imageRes = soundArrays.board_header_vengeful
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Venomancer) -> {
                imageRes = soundArrays.board_header_venomancer
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Viper) -> {
                imageRes = soundArrays.board_header_viper
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Weaver) -> {
                imageRes = soundArrays.board_header_weaver
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Ancientapparition) -> {
                imageRes = soundArrays.board_header_ancient
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Bane) -> {
                imageRes = soundArrays.board_header_bane
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Batrider) -> {
                imageRes = soundArrays.board_header_batrider
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Chen) -> {
                imageRes = soundArrays.board_header_chen
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Crystalmaiden) -> {
                imageRes = soundArrays.board_header_cm
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Darkseer) -> {
                imageRes = soundArrays.board_header_ds
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Darkwillow) -> {
                imageRes = soundArrays.board_header_dw
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Dazzle) -> {
                imageRes = soundArrays.board_header_dazzle
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Deathprophet) -> {
                imageRes = soundArrays.board_header_dp
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Disruptor) -> {
                imageRes = soundArrays.board_header_disruptor
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Enchantress) -> {
                imageRes = soundArrays.board_header_enchantress
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Enigma) -> {
                imageRes = soundArrays.board_header_enigma
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Invoker) -> {
                imageRes = soundArrays.board_header_invoker
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Jakiro) -> {
                imageRes = soundArrays.board_header_jakiro
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Keeperofthelight) -> {
                imageRes = soundArrays.board_header_kotl
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Leshrac) -> {
                imageRes = soundArrays.board_header_leshrac
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Lich) -> {
                imageRes = soundArrays.board_header_lich
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Lina) -> {
                imageRes = soundArrays.board_header_lina
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Lion) -> {
                imageRes = soundArrays.board_header_lion
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Naturesprophet) -> {
                imageRes = soundArrays.board_header_np
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Necrophos) -> {
                imageRes = soundArrays.board_header_necro
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Ogremagi) -> {
                imageRes = soundArrays.board_header_ogre
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Oracle) -> {
                imageRes = soundArrays.board_header_oracle
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Outworlddevourer) -> {
                imageRes = soundArrays.board_header_od
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Puck) -> {
                imageRes = soundArrays.board_header_puck
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Pugna) -> {
                imageRes = soundArrays.board_header_pugna
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Queenofpain) -> {
                imageRes = soundArrays.board_header_qop
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Rubick) -> {
                imageRes = soundArrays.board_header_rubick
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Shadowdemon) -> {
                imageRes = soundArrays.board_header_sd
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Shadowshaman) -> {
                imageRes = soundArrays.board_header_ss
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Silencer) -> {
                imageRes = soundArrays.board_header_silencer
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Skywrathmage) -> {
                imageRes = soundArrays.board_header_sm
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Stormspirit) -> {
                imageRes = soundArrays.board_header_storm
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Techies) -> {
                imageRes = soundArrays.board_header_techies
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Tinker) -> {
                imageRes = soundArrays.board_header_tinker
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Visage) -> {
                imageRes = soundArrays.board_header_visage
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Warlock) -> {
                imageRes = soundArrays.board_header_warlock
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Windranger) -> {
                imageRes = soundArrays.board_header_wr
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Winterwyvern) -> {
                imageRes = soundArrays.board_header_ww
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Witchdoctor) -> {
                imageRes = soundArrays.board_header_wd
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            getString(R.string.Zeus) -> {
                imageRes = soundArrays.board_header_zeus
                soundResListAttack.addAll(soundArrays.alchemist_sound_res_attack)
                soundTitlesListAttack.addAll(soundArrays.alchemist_sound_titles_attack)
            }

            else -> {
                imageRes = soundArrays.ti7_board_header
                soundResListAttack.addAll(soundArrays.ti7_sound_res)
                soundTitlesListAttack.addAll(soundArrays.ti7_sound_titles)
            }
        }

        (0 until soundResListAttack.size).mapTo(soundsListAttack) { Sound(soundResListAttack[it], soundTitlesListAttack[it]) }
        (0 until soundResListAttackMorphed.size).mapTo(soundsListAttackMorphed) { Sound(soundResListAttackMorphed[it], soundTitlesListAttack[it]) }
        (0 until soundResListAbilities.size).mapTo(soundsListAbilities) { Sound(soundResListAbilities[it], soundTitlesListAbilities[it]) }
        (0 until soundResListAbilitiesMorphed.size).mapTo(soundsListAbilitiesMorphed) { Sound(soundResListAbilitiesMorphed[it], soundTitlesListAbilities[it]) }

        (header_image as ImageView).setImageResource(imageRes)

        // Add the board to the recents database table
        dbHelper.insertRecent(heroKey, imageRes)
    }

}
