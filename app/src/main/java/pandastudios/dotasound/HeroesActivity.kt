package pandastudios.dotasound

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.MenuItem
import android.view.View
import android.view.ViewTreeObserver
import android.widget.ArrayAdapter
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.activity_heroes.*
import pandastudios.dotasound.arrays.MiscArrays

class HeroesActivity : AppCompatActivity() {

    val LOG_TAG = HeroesActivity::class.java.simpleName
    var isPhone = false

    lateinit var miscArrays: MiscArrays

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)
        miscArrays = MiscArrays(this)
        isPhone = resources.getBoolean(R.bool.is_phone)

        // Add the up button on the toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        // Setup Grid
        if (isPhone) setupGridForPhone() else setupGridForTablet()

        // Show Select Misc view if applicable
        setupMisc()
    }

    private fun setupMisc() {
        val selectingSound = intent.getIntExtra(getString(R.string.INTENT_SELECTING_SOUND), -1)
        if (selectingSound > -1) {
            toolbar_title.text = getString(R.string.selecting_sound)
            rl_select_misc.visibility = View.VISIBLE
            rl_select_misc.setOnClickListener { launchMiscActivity(selectingSound) }
        }
    }

    private fun launchMiscActivity(selectingSound: Int) {
        val intent = Intent(this, MiscActivity::class.java)
        intent.putExtra(getString(R.string.INTENT_SELECTING_SOUND), selectingSound)
        startActivity(intent)
    }

    private fun setupGridForPhone() {
        // Get the lists and set the layout manager's span mode
        val layoutManager = GridLayoutManager(this, 5)
        val strength_list = getStrengthHeroes()
        val agility_list = getAgilityHeroes()
        val intelligence_list = getIntelligenceHeroes()

        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                // If on top of strength heroes
                var benchmark = 0
                if (position == benchmark)
                    return 5

                // If on top of agility heroes
                benchmark += strength_list.size
                if (position == benchmark)
                    return 5

                // If on top of intelligence heroes
                benchmark += agility_list.size
                if (position == benchmark)
                    return 5

                // If last item
                benchmark += intelligence_list.size
                if (position == benchmark)
                    return 5

                return 1
            }
        }

        // Gather all the hero lists into one big list
        val all_heroes_list = ArrayList<SectionOrRow>()
        all_heroes_list.addAll(strength_list)
        all_heroes_list.addAll(agility_list)
        all_heroes_list.addAll(intelligence_list)
        all_heroes_list.add(SectionOrRow.createSection(""))

        // Apply the attributes to the adapter
        val adapter = HeroesRecycler(this, all_heroes_list)
        grid.adapter = adapter
        grid.layoutManager = layoutManager
    }

    private fun setupGridForTablet() {
        val sample_array = ArrayList<String>()
        for (i in 0 until 30)
            sample_array.add("a")
        sample_grid.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, sample_array)

        sample_grid.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                sample_grid.viewTreeObserver.removeOnPreDrawListener(this)
                val numColumns = sample_grid.numColumns
                strength_group.removeView(sample_grid)

                val strength_list = getStrengthHeroes()
                val agility_list = getAgilityHeroes()
                val intelligence_list = getIntelligenceHeroes()

                val strength_adapter = HeroesRecycler(this@HeroesActivity, strength_list)
                val agility_adapter = HeroesRecycler(this@HeroesActivity, agility_list)
                val intelligence_adapter = HeroesRecycler(this@HeroesActivity, intelligence_list)

                // Error proof method
                if (strength_grid == null) {
                    setupGridForPhone()
                    return false
                }

                strength_grid.adapter = strength_adapter
                agility_grid.adapter = agility_adapter
                intelligence_grid.adapter = intelligence_adapter

                strength_grid.layoutManager = GridLayoutManager(this@HeroesActivity, numColumns)
                agility_grid.layoutManager = GridLayoutManager(this@HeroesActivity, numColumns)
                intelligence_grid.layoutManager = GridLayoutManager(this@HeroesActivity, numColumns)

                return true
            }
        })

    }

    private fun getStrengthHeroes(): List<SectionOrRow> {
        val list = ArrayList<SectionOrRow>()

        // Add the header first
        if (isPhone) list.add(SectionOrRow.createSection(getString(R.string.strength)))

        val icons = miscArrays.strength_heroes
        val names = resources.getStringArray(R.array.strength_heroes)

        // Prevents crashing
        if (icons.size != names.size)
            return list

        (0 until names.size).mapTo(list) { SectionOrRow.createRow(Board(icons[it], names[it])) }

        return list
    }

    private fun getAgilityHeroes(): List<SectionOrRow> {
        val list = ArrayList<SectionOrRow>()

        // Add the header first
        if (isPhone) list.add(SectionOrRow.createSection(getString(R.string.agility)))

        val icons = miscArrays.agility_heroes
        val names = resources.getStringArray(R.array.agility_heroes)

        // Prevents crashing
        if (icons.size != names.size)
            return list

        (0 until names.size).mapTo(list) { SectionOrRow.createRow(Board(icons[it], names[it])) }

        return list
    }

    private fun getIntelligenceHeroes(): List<SectionOrRow> {
        val list = ArrayList<SectionOrRow>()

        // Add the header first
        if (isPhone) list.add(SectionOrRow.createSection(getString(R.string.intelligence)))

        val icons = miscArrays.intelligence_heroes
        val names = resources.getStringArray(R.array.intelligence_heroes)

        // Prevents crashing
        if (icons.size != names.size)
            return list

        (0 until names.size).mapTo(list) { SectionOrRow.createRow(Board(icons[it], names[it])) }

        return list
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }

        return false
    }

}
