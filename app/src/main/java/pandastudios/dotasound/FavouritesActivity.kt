package pandastudios.dotasound

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.activity_favourites.*
import pandastudios.dotasound.data.DbHelper

class FavouritesActivity : AppCompatActivity() {

    private lateinit var dbHelper: DbHelper
    private lateinit var favouritesList: ArrayList<Board>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourites)

        setupToolbar()
        setupGrid()
        setupAds()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        title = ""
    }

    private fun setupGrid() {
        dbHelper = DbHelper(this)
        favouritesList = dbHelper.getFavouritesList()
        favourites_grid.adapter = MiscAdapter(this, R.layout.list_item_home, favouritesList)

        favourites_grid.setOnItemClickListener { _, _, i, _ ->
            val intent = Intent(this, SampleTabActivity::class.java)
            intent.putExtra(getString(R.string.KEY_HERO), favouritesList[i].name)
            startActivity(intent)
        }
    }

    private fun setupAds() {
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
    }


}
