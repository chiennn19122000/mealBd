package com.example.mealdb.ui.search

import android.annotation.SuppressLint
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.mealdb.R
import com.example.mealdb.base.BaseFragment
import com.example.mealdb.data.model.Meal
import com.example.mealdb.databinding.FragmentSearchBinding
import com.example.mealdb.ui.adapter.MealAdapter
import com.example.mealdb.utils.RESULT_FOR
import com.example.mealdb.utils.hideKeyboard
import com.example.mealdb.utils.showKeyboard
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val layoutResource get() = R.layout.fragment_search
    override val viewModel by viewModel<SearchViewModel>()

    private val adapter = MealAdapter(::clickMeal)

    override fun setupViews() {
    }

    override fun setupData() {
        var arrayAdapter =
            this.context?.let { ArrayAdapter(it,android.R.layout.simple_list_item_1, SUGGESTIONS) }
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            searchVM = viewModel
            recyclerSearch.adapter = adapter

            editTextSearch.threshold = 1
            editTextSearch.setAdapter(arrayAdapter)
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
            editTextSearch.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    search(editTextSearch.text.toString())
                    editTextSearch.hideKeyboard()
                }
                false
            }
            editTextSearch.showKeyboard()
        }
    }

    private fun search(keyword: String) {
        textSearchTitle.text = RESULT_FOR + "  '" + keyword + "'"
        viewModel.getSeachMeal(keyword)

    }

    private fun clickMeal(meal: Meal) {
        val action = SearchFragmentDirections.actionSearchToMealDetail(meal)
        findNavController().navigate(action)
    }

    companion object {
        val SUGGESTIONS = arrayOf(
            "Beef and Mustard Pie",
            "Beef and Oyster pie",
            "Beef Banh Mi Bowls with Sriracha Mayo, Carrot & Pickled Cucumber",
            "Beef Bourguignon",
            "Beef Brisket Pot Roast",
            "Beef Dumpling Stew",
            "Beef Lo Mein",
            "Beef Rendang",
            "Beef stroganoff",
            "Beef Sunday Roast",
            "Beef Wellington",
            "Big Mac",
            "Bitterballen (Dutch meatballs)",
            "Braised Beef Chilli",
            "Corned Beef and Cabbage",
            "Egyptian Fatteh",
            "Gołąbki (cabbage roll)",
            "Irish stew",
            "Jamaican Beef Patties",
            "Ma Po Tofu",
            "Massaman Beef curry",
            "Minced Beef Pie",
            "Montreal Smoked Meat",
            "Moussaka",
            "Mulukhiyah",
            "Oxtail with broad beans",
            "Paszteciki (Polish Pasties)",
            "Pate Chinois",
            "Portuguese prego with green piri-piri",
            "Red Peas Soup",
            "Roti john",
            "Soy-Glazed Meatloaves with Wasabi Mashed Potatoes & Roasted Carrots",
            "Spaghetti Bolognese",
            "Steak and Kidney Pie",
            "Steak Diane",
            "Szechuan Beef",
            "Vegetable Shepherd’s Pie",
            "Ayam Percik",
            "Brown Stew Chicken",
            "Chick-Fil-A Sandwich",
            "Chicken & mushroom Hotpot",
            "Chicken Alfredo Primavera",
            "Chicken Basquaise",
            "Chicken Congee",
            "Chicken Couscous",
            "Chicken Enchilada Casserole",
            "Chicken Fajita Mac and Cheese",
            "Chicken Ham and Leek Pie",
            "Chicken Handi",
            "Chicken Karaage",
            "Chicken Marengo",
            "Chicken Parmentier",
            "Chicken Quinoa Greek Salad",
            "Coq au vin",
            "Crock Pot Chicken Baked Tacos",
            "French Onion Chicken with Roasted Carrots & Mashed Potatoes",
            "General Tso's Chicken",
            "Honey Balsamic Chicken with Crispy Broccoli & Potatoes",
            "Jerk chicken with rice & peas",
            "Katsu Chicken curry",
            "Kentucky Fried Chicken",
            "Kung Pao Chicken",
            "Nutty Chicken Curry",
            "Pad See Ew",
            "Piri-piri chicken and slaw",
            "Potato Gratin with Chicken",
            "Rappie Pie",
            "Rosół (Polish Chicken Soup)",
            "Shawarma",
            "Tandoori chicken",
            "Teriyaki Chicken Casserole",
            "Thai Green Curry",
            "Apam balik",
            "Apple & Blackberry Crumble",
            "Apple Frangipan Tart",
            "Bakewell tart",
            "Banana Pancakes",
            "Battenberg Cake",
            "BeaverTails",
            "Blackberry Fool",
            "Bread and Butter Pudding",
            "Budino Di Ricotta",
            "Canadian Butter Tarts",
            "Carrot Cake",
            "Cashew Ghoriba Biscuits",
            "Chelsea Buns",
            "Chinon Apple Tarts",
            "Choc Chip Pecan Pie",
            "Chocolate Avocado Mousse",
            "Chocolate Caramel Crispy",
            "Chocolate Gateau",
            "Chocolate Raspberry Brownies",
            "Chocolate Souffle",
            "Christmas cake",
            "Christmas Pudding Flapjack",
            "Christmas Pudding Trifle",
            "Classic Christmas pudding",
            "Dundee cake",
            "Eccles Cakes",
            "Eton Mess",
            "Honey Yogurt Cheesecake",
            "Hot Chocolate Fudge",
            "Jam Roly-Poly",
            "Key Lime Pie",
            "Krispy Kreme Donut",
            "Madeira Cake",
            "Mince Pies",
            "Nanaimo Bars",
            "New York cheesecake",
            "Pancakes",
            "Parkin Cake",
            "Peach & Blueberry Grunt",
            "Peanut Butter Cheesecake",
            "Peanut Butter Cookies",
            "Pear Tarte Tatin",
            "Polskie Naleśniki (Polish Pancakes)",
            "Portuguese custard tarts",
            "Pouding chomeur",
            "Pumpkin Pie",
            "Rock Cakes",
            "Rocky Road Fudge",
            "Rogaliki (Polish Croissant Cookies)",
            "Salted Caramel Cheescake",
            "Seri muka kuih",
            "Spotted Dick",
            "Sticky Toffee Pudding",
            "Sticky Toffee Pudding Ultimate",
            "Strawberry Rhubarb Pie",
            "Sugar Pie",
            "Summer Pudding",
            "Tarte Tatin",
            "Timbits",
            "Treacle Tart",
            "Tunisian Orange Cake",
            "White chocolate creme brulee",
            "Kapsalon",
            "Keleya Zaara",
            "Lamb and Lemon Souvlaki",
            "Lamb and Potato pie",
            "Lamb Biryani",
            "Lamb Rogan josh",
            "Lamb Tagine",
            "Lamb tomato and sweet spices",
            "Lamb Tzatziki Burgers",
            "Lancashire hotpot",
            "McSinghs Scotch pie",
            "Rigatoni with fennel sausage sauce",
            "Stuffed Lamb Tomatoes",
            "Tunisian Lamb Soup",
            "Bean & Sausage Hotpot",
            "Callaloo Jamaican Style",
            "Chakchouka ",
            "Duck Confit",
            "French Lentils With Garlic and Thyme",
            "French Omelette",
            "Osso Buco alla Milanese",
            "Pizza Express Margherita",
            "Poutine",
            "Three-cheese souffles",
            "Turkey Meatloaf",
            "Chilli prawn linguine",
            "Fettucine alfredo",
            "Grilled Mac and Cheese Sandwich",
            "Lasagna Sandwiches",
            "Lasagne",
            "Pilchard puttanesca",
            "Spaghetti alla Carbonara",
            "Venetian Duck Ragu",
            " Bubble & Squeak",
            "BBQ Pork Sloppy Joes",
            "Bigos (Hunters Stew)",
            "Boxty Breakfast",
            "Coddled pork with cider",
            "Crispy Sausages and Greens",
            "Ham hock colcannon",
            "Hot and Sour Soup",
            "Japanese Katsudon",
            "Pork Cassoulet",
            "Portuguese barbecued pork (Febras assadas)",
            "Skillet Apple Pork Chops with Roasted Sweet Potatoes & Zucchini",
            "Stamppot",
            "Sweet and Sour Pork",
            "Toad In The Hole",
            "Tonkatsu pork",
            "Tourtiere",
            "Vietnamese Grilled Pork (bun-thit-nuong)",
            "Wontons",
            "Baked salmon with fennel & tomatoes",
            "Cajun spiced fish tacos",
            "Escovitch Fish",
            "Fish fofos",
            "Fish pie",
            "Fish Stew with Rouille",
            "Garides Saganaki",
            "Grilled Portuguese sardines",
            "Honey Teriyaki Salmon",
            "Kedgeree",
            "Kung Po Prawns",
            "Laksa King Prawn Noodles",
            "Mediterranean Pasta Salad",
            "Mee goreng mamak",
            "Nasi lemak",
            "Portuguese fish stew (Caldeirada de peixe)",
            "Recheado Masala Fish",
            "Salmon Avocado Salad",
            "Salmon Prawn Risotto",
            "Saltfish and Ackee",
            "Seafood fideuà",
            "Shrimp Chow Fun",
            "Sledz w Oleju (Polish Herrings)",
            "Spring onion and prawn empanadas",
            "Three Fish Pie",
            "Tuna and Egg Briks",
            "Tuna Nicoise",
            "Boulangère Potatoes",
            "Brie wrapped in prosciutto & brioche",
            "Corba",
            "Fennel Dauphinoise",
            "Feteer Meshaltet",
            "French Onion Soup",
            "Japanese gohan rice",
            "Kumpir",
            "Mustard champ",
            "Pierogi (Polish Dumplings)",
            "Prawn & Fennel Bisque",
            "Snert (Dutch Split Pea Soup)",
            "Split Pea Soup",
            "Broccoli & Stilton soup",
            "Clam chowder",
            "Cream Cheese Tart",
            "Creamy Tomato Soup",
            "Roast fennel and aubergine paella",
            "Vegan Chocolate Cake",
            "Vegan Lasagna",
            "Baingan Bharta",
            "Chickpea Fajitas",
            "Dal fry",
            "Egg Drop Soup",
            "Flamiche",
            "Ful Medames",
            "Gigantes Plaki",
            "Kafteji",
            "Kidney Bean Curry",
            "Koshari",
            "Leblebi Soup",
            "Matar Paneer",
            "Moroccan Carrot Soup",
            "Mushroom & Chestnut Rotolo",
            "Provençal Omelette Cake",
            "Ratatouille",
            "Ribollita",
            "Roasted Eggplant With Tahini, Pine Nuts, and Lentils",
            "Shakshuka",
            "Smoky Lentil Chili with Squash",
            "Spanish Tortilla",
            "Spicy Arrabiata Penne",
            "Spicy North African Potato Salad",
            "Spinach & Ricotta Cannelloni",
            "Squash linguine",
            "Stovetop Eggplant With Harissa, Chickpeas, and Cumin Yogurt",
            "Summer Pistou",
            "Tahini Lentils",
            "Tamiya",
            "Vegetarian Casserole",
            "Vegetarian Chilli",
            "Yaki Udon",
            "Breakfast Potatoes",
            "English Breakfast",
            "Fruit and Cream Cheese Breakfast Pastries",
            "Full English Breakfast",
            "Home-made Mandazi",
            "Salmon Eggs Eggs Benedict",
            "Smoked Haddock Kedgeree",
            "Mbuzi Choma (Roasted Goat)",
        )
    }
}
