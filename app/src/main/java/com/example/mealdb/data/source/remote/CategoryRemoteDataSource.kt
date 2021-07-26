package com.example.mealdb.data.source.remote

import com.example.mealdb.data.model.Category
import com.example.mealdb.data.model.CategoryResponse
import com.example.mealdb.data.source.CategoryDataSource
import io.reactivex.rxjava3.core.Observable

class CategoryRemoteDataSource(
    private val api: Api
) : CategoryDataSource {

    override fun getCategory(): Observable<CategoryResponse> = api.getCategory()
}
