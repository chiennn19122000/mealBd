package com.example.mealdb.ui.imagezoom

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mealdb.base.BaseViewModel

class ImageZoomViewModel: BaseViewModel() {

    private val _image = MutableLiveData<String>()
    val image: LiveData<String>
        get() = _image

    fun loadImage(img: String){
        _image.value = img
    }
}
