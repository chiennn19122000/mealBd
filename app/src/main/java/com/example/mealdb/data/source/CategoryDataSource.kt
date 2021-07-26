package com.example.mealdb.data.source

import com.example.mealdb.data.model.Category
import com.example.mealdb.data.model.CategoryResponse
import io.reactivex.rxjava3.core.Observable

interface CategoryDataSource {
    fun getCategory(): Observable<CategoryResponse>
}
