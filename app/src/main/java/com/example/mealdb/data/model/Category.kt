package com.example.mealdb.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    @SerializedName("idCategory")
    val idCategory: Int,
    @SerializedName("strCategory")
    val strCategory: String,
    @SerializedName("strCategoryThumb")
    val strCategoryThumb: String,
) : Parcelable {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Category>() {
            override fun areItemsTheSame(oldItem: Category, newItem: Category) =
                oldItem.idCategory == newItem.idCategory

            override fun areContentsTheSame(oldItem: Category, newItem: Category) =
                oldItem == newItem
        }
    }
}
