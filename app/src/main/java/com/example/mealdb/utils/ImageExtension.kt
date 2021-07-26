package com.example.mealdb.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mealdb.R

fun ImageView.loadImage(url: String?) {
    Glide.with(context)
        .load(url)
        .error(R.drawable.ic_error)
        .placeholder(R.drawable.ic_error)
        .into(this)
}
