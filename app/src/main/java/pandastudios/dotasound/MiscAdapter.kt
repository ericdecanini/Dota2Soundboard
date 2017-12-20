package pandastudios.dotasound

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class MiscAdapter(context: Context, private val resID: Int, items: ArrayList<Board>): ArrayAdapter<Board>(context, resID, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val item = getItem(position)
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resID, parent, false)!!
        }
        // Lookup view for data population
        val name = convertView.findViewById<TextView>(R.id.name)
        val image = convertView.findViewById<ImageView>(R.id.image)

        // Populate the data into the template view using the data object
        name.text = item!!.name
        image.setImageResource(item.img)

        // Return the completed view to render on screen
        return convertView
    }

}