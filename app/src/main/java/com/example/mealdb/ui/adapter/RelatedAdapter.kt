package com.example.mealdb.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.mealdb.R
import com.example.mealdb.base.BaseAdapter
import com.example.mealdb.base.BaseViewHolder
import com.example.mealdb.data.model.Meal
import com.example.mealdb.databinding.ItemRelatedMealBinding

class RelatedAdapter (
    private val itemClick: (Meal) -> Unit
) : BaseAdapter<Meal, RelatedAdapter.RelatedViewHolder>(Meal.diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatedViewHolder =
        RelatedViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_related_meal, parent, false
            ),
            itemClick
        )

    class RelatedViewHolder(
        private val relatedMealBinding: ItemRelatedMealBinding,
        itemClick: (Meal) -> Unit
    ) : BaseViewHolder<Meal>(relatedMealBinding, itemClick) {

        override fun bindData(item: Meal) {
            super.bindData(item)
            relatedMealBinding.mealRelated = item
        }
    }
}
