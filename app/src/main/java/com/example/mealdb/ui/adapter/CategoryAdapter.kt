package com.example.mealdb.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.mealdb.R
import com.example.mealdb.base.BaseAdapter
import com.example.mealdb.base.BaseViewHolder
import com.example.mealdb.data.model.Category
import com.example.mealdb.databinding.ItemCategoryBinding

class CategoryAdapter(
    private val itemClick: (Category) -> Unit
) : BaseAdapter<Category, CategoryAdapter.CategoryViewHolder>(Category.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
        CategoryViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_category, parent, false
            ),
            itemClick
        )

    class CategoryViewHolder(
        private val itemCategoryBinding: ItemCategoryBinding,
        itemClick: (Category) -> Unit
    ) : BaseViewHolder<Category>(itemCategoryBinding, itemClick) {

        override fun bindData(item: Category) {
            super.bindData(item)
            itemCategoryBinding.category = item
        }
    }
}
