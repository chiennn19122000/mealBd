package com.example.mealdb.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "meal")
data class MealDetail(
    @PrimaryKey
    @SerializedName("idMeal")
    @ColumnInfo(name = "idMeal")
    val idMeal: Int,
    @SerializedName("strMeal")
    @ColumnInfo(name = "strMeal")
    val strMeal: String,
    @SerializedName("strCategory")
    @ColumnInfo(name = "strCategory")
    val strCategory: String,
    @SerializedName("strInstructions")
    @ColumnInfo(name = "strInstructions")
    val strInstructions: String,
    @SerializedName("strMealThumb")
    @ColumnInfo(name = "strMealThumb")
    val strMealThumb: String,
    @SerializedName("strIngredient1")
    @ColumnInfo(name = "strIngredient1")
    val strIngredient1: String,
    @SerializedName("strIngredient2")
    @ColumnInfo(name = "strIngredient2")
    val strIngredient2: String,
    @SerializedName("strIngredient3")
    @ColumnInfo(name = "strIngredient3")
    val strIngredient3: String,
    @SerializedName("strIngredient4")
    @ColumnInfo(name = "strIngredient4")
    val strIngredient4: String,
    @SerializedName("strIngredient5")
    @ColumnInfo(name = "strIngredient5")
    val strIngredient5: String,
    @SerializedName("strIngredient6")
    @ColumnInfo(name = "strIngredient6")
    val strIngredient6: String,
    @SerializedName("strIngredient7")
    @ColumnInfo(name = "strIngredient7")
    val strIngredient7: String,
    @SerializedName("strIngredient8")
    @ColumnInfo(name = "strIngredient8")
    val strIngredient8: String,
    @SerializedName("strIngredient9")
    @ColumnInfo(name = "strIngredient9")
    val strIngredient9: String,
    @SerializedName("strIngredient10")
    @ColumnInfo(name = "strIngredient10")
    val strIngredient10: String,
    @SerializedName("strIngredient11")
    @ColumnInfo(name = "strIngredient11")
    val strIngredient11: String,
    @SerializedName("strIngredient12")
    @ColumnInfo(name = "strIngredient12")
    val strIngredient12: String,
    @SerializedName("strIngredient13")
    @ColumnInfo(name = "strIngredient13")
    val strIngredient13: String,
    @SerializedName("strIngredient14")
    @ColumnInfo(name = "strIngredient14")
    val strIngredient14: String,
    @SerializedName("strIngredient15")
    @ColumnInfo(name = "strIngredient15")
    val strIngredient15: String,
    @SerializedName("strIngredient16")
    @ColumnInfo(name = "strIngredient16")
    val strIngredient16: String,
    @SerializedName("strIngredient17")
    @ColumnInfo(name = "strIngredient17")
    val strIngredient17: String,
    @SerializedName("strIngredient18")
    @ColumnInfo(name = "strIngredient18")
    val strIngredient18: String,
    @SerializedName("strIngredient19")
    @ColumnInfo(name = "strIngredient19")
    val strIngredient19: String,
    @SerializedName("strIngredient20")
    @ColumnInfo(name = "strIngredient20")
    val strIngredient20: String,
) : Parcelable {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<MealDetail>() {
            override fun areItemsTheSame(oldItem: MealDetail, newItem: MealDetail) =
                oldItem.idMeal == newItem.idMeal

            override fun areContentsTheSame(oldItem: MealDetail, newItem: MealDetail) =
                oldItem == newItem
        }
    }
}
