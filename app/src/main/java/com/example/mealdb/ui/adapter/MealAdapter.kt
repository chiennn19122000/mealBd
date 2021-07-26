package com.example.mealdb.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.mealdb.R
import com.example.mealdb.base.BaseAdapter
import com.example.mealdb.base.BaseViewHolder
import com.example.mealdb.data.model.Meal
import com.example.mealdb.databinding.ItemMealBinding

class MealAdapter(
    private val itemClick: (Meal) -> Unit
) : BaseAdapter<Meal, MealAdapter.MealViewHolder>(Meal.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder =
        MealViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_meal, parent, false
            ),
            itemClick
        )

    class MealViewHolder(
        private val itemMealBinding: ItemMealBinding,
        itemClick: (Meal) -> Unit
    ) : BaseViewHolder<Meal>(itemMealBinding, itemClick) {

        override fun bindData(item: Meal) {
            super.bindData(item)
            itemMealBinding.meal = item
        }
    }
}
