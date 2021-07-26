package com.example.mealdb.data.model

import com.google.gson.annotations.SerializedName

data class MealResponse (
    @SerializedName("meals")
    val data: List<Meal>
)
