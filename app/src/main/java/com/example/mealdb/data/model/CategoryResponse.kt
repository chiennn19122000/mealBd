package com.example.mealdb.data.model

import com.google.gson.annotations.SerializedName

data class CategoryResponse (
    @SerializedName("categories")
    val data: List<Category>
)
