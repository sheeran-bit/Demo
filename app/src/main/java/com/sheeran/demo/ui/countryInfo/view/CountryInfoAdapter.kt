package com.sheeran.demo.ui.countryInfo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sheeran.demo.R
import com.sheeran.demo.data.network.AboutCountry
import com.sheeran.demo.ui.util.loadImage
import kotlinx.android.synthetic.main.item_about_country.view.*


class CountryInfoAdapter(private val CountryInfoListItems: MutableList<AboutCountry>) :
    RecyclerView.Adapter<CountryInfoAdapter.CountryInfoViewHolder>() {

    override fun getItemCount() = this.CountryInfoListItems.size

    override fun onBindViewHolder(holder: CountryInfoViewHolder, position: Int) = holder.let {
        it.clear()
        it.onBind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryInfoViewHolder =
        CountryInfoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_about_country, parent, false)
        )

    internal fun addDataToList(list: List<AboutCountry>) {
        this.CountryInfoListItems.clear()
        this.CountryInfoListItems.addAll(list.filter { !it.description.isNullOrEmpty() && !it.title.isNullOrEmpty() && !it.imageHref.isNullOrEmpty() })
        notifyDataSetChanged()
    }

    inner class CountryInfoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun clear() {
            itemView.tvTitle.text = ""
            itemView.tvDescription.text = ""
            itemView.ivThumbnail.setImageDrawable(null)
        }

        fun onBind(position: Int) {
            val (title, description, imageHref) = CountryInfoListItems[position]
            inflateData(title, description, imageHref)
        }

        private fun inflateData(
            title: String?,
            description: String?,
            imageHref: String?
        ) {
            title?.let {
                itemView.tvTitle.text = it
            }
            description?.let {
                itemView.tvDescription.text = it
            }
            imageHref?.let {
                itemView.ivThumbnail.loadImage(it)
            }

        }

    }

}
