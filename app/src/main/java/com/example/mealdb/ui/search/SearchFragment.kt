package com.example.mealdb.ui.search

import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.mealdb.R
import com.example.mealdb.base.BaseFragment
import com.example.mealdb.data.model.Meal
import com.example.mealdb.databinding.FragmentSearchBinding
import com.example.mealdb.ui.adapter.MealAdapter
import com.example.mealdb.ui.home.HomeFragmentDirections
import com.example.mealdb.utils.Constants
import com.example.mealdb.utils.hideKeyboard
import com.example.mealdb.utils.showKeyboard
import kotlinx.android.synthetic.main.fragment_meal.*
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.jvm.internal.impl.load.java.Constant

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val layoutResource get() = R.layout.fragment_search
    override val viewModel by viewModel<SearchViewModel>()

    private val adapter = MealAdapter(::clickMeal)

    override fun setupViews() {
    }

    override fun setupData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            searchVM = viewModel
            recyclerSearch.adapter = adapter
        }
    }

    override fun setupActions() {
        binding?.apply {
            buttonBack.setOnClickListener {
                findNavController().popBackStack()
                editTextSearch.hideKeyboard()
            }
            buttonSearch.setOnClickListener {
                if (editTextSearch.text.toString().isNullOrEmpty() == false) {
                    search(editTextSearch.text.toString())
                    editTextSearch.hideKeyboard()
                }
            }
            editTextSearch.showKeyboard()
        }
    }

    private fun search(keyword: String) {
        textSearchTitle.text = Constants.RESULT_FOR + "  '" + keyword + "'"
        viewModel.getSeachMeal(keyword)

    }

    private fun clickMeal(meal: Meal) {
        val action = SearchFragmentDirections.actionSearchToMealDetail(meal)
        findNavController().navigate(action)
    }
}
