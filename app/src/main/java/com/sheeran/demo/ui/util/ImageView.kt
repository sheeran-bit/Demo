package com.sheeran.demo.ui.util

import android.widget.ImageView
import com.sheeran.demo.R
import com.squareup.picasso.Picasso

internal fun ImageView.loadImage(url: String) {
    Picasso.get()
        .load(url)
        .placeholder(R.mipmap.ic_launcher_round)
        .error(R.mipmap.ic_launcher_round)
        .fit()
        .noFade()
        .into(this)
}