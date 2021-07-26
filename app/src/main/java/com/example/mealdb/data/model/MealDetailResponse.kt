package com.example.mealdb.data.model

import com.google.gson.annotations.SerializedName

data class MealDetailResponse(
    @SerializedName("meals")
    val data: List<MealDetail>
)
