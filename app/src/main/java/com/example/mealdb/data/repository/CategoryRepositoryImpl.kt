package com.example.mealdb.data.repository

import com.example.mealdb.data.model.Category
import com.example.mealdb.data.source.CategoryDataSource
import io.reactivex.rxjava3.core.Observable

class CategoryRepositoryImpl(
    private val remote: CategoryDataSource
) : CategoryRepository {

    override fun getCategory(): Observable<List<Category>> = remote.getCategory().map{it.data}
}
