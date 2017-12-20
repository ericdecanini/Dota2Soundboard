package pandastudios.dotasound

import android.content.Intent
import android.media.AudioManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_misc.*


class MiscActivity : AppCompatActivity() {

    lateinit var soundArrays: SoundArrays

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_misc)
        soundArrays = SoundArrays(this)
        volumeControlStream = AudioManager.STREAM_MUSIC

        setupToolbar()
        setupGrid()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupGrid() {
        val misc_images_res = soundArrays.misc_items
        val misc_titles = resources.getStringArray(R.array.misc_items)
        val misc_items = ArrayList<Board>()

        if (misc_images_res.size != misc_titles.size)
            return

        (0 until misc_images_res.size).mapTo(misc_items) { Board(misc_images_res[it], misc_titles[it]) }

        misc_grid.adapter = MiscAdapter(this, R.layout.grid_item_misc, misc_items)

        misc_grid.setOnItemClickListener {_,_, i, _ ->
            val intent = Intent(this, SoundboardActivity::class.java)
            intent.putExtra(getString(R.string.KEY_HERO), misc_items[i].name)
            startActivity(intent)
        }
    }

}
