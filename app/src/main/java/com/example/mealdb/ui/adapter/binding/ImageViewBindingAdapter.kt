package com.example.mealdb.ui.adapter.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.mealdb.utils.loadImage

@BindingAdapter("app:image")
fun loadImage(imageView: ImageView, url: String?) {
    imageView.loadImage(url)
}
