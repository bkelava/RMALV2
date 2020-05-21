package ferit.bozidarkelava.myapplication2

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

//abstract
class InspiringPersonViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    //prema https://www.youtube.com/watch?v=japhFMXAJZw
    //za prikaz slika s linka treba Picasso library https://www.simplifiedcoding.net/picasso-android-tutorial-picasso-image-loader-library/
    fun populateOnViewHolder (person: InspiringPerson, personOnClick: quoteOnClick) {
        itemView.tvName.text = person.name
        itemView.tvDates.text = person.birthday
        itemView.tvInformation.text = person.description
        itemView.civImage.setOnClickListener {
            personOnClick.getQuote(person.index)
        }

        itemView.btnDeleteItem.setOnClickListener() {
            personOnClick.delete(person.index)
        }

        itemView.btnEdit.setOnClickListener( {
            personOnClick.edit(person.index)
        })
    }
}