package com.example.mealdb.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.mealdb.R
import com.example.mealdb.base.BaseAdapter
import com.example.mealdb.base.BaseViewHolder
import com.example.mealdb.data.model.MealDetail
import com.example.mealdb.databinding.ItemMealFavoriteBinding

class FavoriteAdapter (
    private val itemClick: (MealDetail) -> Unit
) : BaseAdapter<MealDetail, FavoriteAdapter.FavoriteViewHolder>(MealDetail.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder =
        FavoriteViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_meal_favorite, parent, false
            ),
            itemClick
        )

    class FavoriteViewHolder(
        private val itemMealFavoriteBinding: ItemMealFavoriteBinding,
        itemClick: (MealDetail) -> Unit
    ) : BaseViewHolder<MealDetail>(itemMealFavoriteBinding, itemClick) {

        override fun bindData(item: MealDetail) {
            super.bindData(item)
            itemMealFavoriteBinding.favotite = item
        }
    }
}
