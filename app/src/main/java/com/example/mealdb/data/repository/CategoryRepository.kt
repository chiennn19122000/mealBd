package com.example.mealdb.data.repository

import com.example.mealdb.data.model.Category
import io.reactivex.rxjava3.core.Observable

interface CategoryRepository {

    fun getCategory(): Observable<List<Category>>
}
