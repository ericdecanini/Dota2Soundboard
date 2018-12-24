package pandastudios.dotasound

import android.content.Intent
import android.media.AudioManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_misc.*
import pandastudios.dotasound.arrays.MiscArrays
import pandastudios.dotasound.arrays.SoundArraysS1


class MiscActivity : AppCompatActivity() {

    val LOG_TAG = MiscActivity::class.java.simpleName

    lateinit var miscArrays: MiscArrays
    var selectingSound = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_misc)
        miscArrays = MiscArrays(this)
        volumeControlStream = AudioManager.STREAM_MUSIC

        setupToolbar()
        setupGrid()
        checkIncomingIntent()
    }

    private fun checkIncomingIntent() {
        if (intent.hasExtra(getString(R.string.INTENT_SELECTING_SOUND))) {
            selectingSound = intent.getIntExtra(getString(R.string.INTENT_SELECTING_SOUND), -1)
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupGrid() {
        val misc_images_res = miscArrays.misc_items
        val misc_titles = resources.getStringArray(R.array.misc_items)
        val misc_items = ArrayList<Board>()

        if (misc_images_res.size != misc_titles.size)
            return

        (0 until misc_images_res.size).mapTo(misc_items) { Board(misc_images_res[it], misc_titles[it]) }

        misc_grid.adapter = MiscAdapter(this, R.layout.grid_item_misc, misc_items)

        misc_grid.setOnItemClickListener {_,_, i, _ ->
            val intent = Intent(this, SoundboardActivity::class.java)
            intent.putExtra(getString(R.string.KEY_HERO), misc_items[i].name)

            if (selectingSound > -1)
                intent.putExtra(getString(R.string.INTENT_SELECTING_SOUND), selectingSound)
            startActivity(intent)
        }
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
