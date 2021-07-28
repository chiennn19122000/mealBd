package com.example.mealdb.ui.imagezoom

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mealdb.base.BaseViewModel
import com.example.mealdb.data.source.remote.Api
import com.example.mealdb.utils.BASE_URL
import com.example.mealdb.utils.FOLDER
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream


class ImageZoomViewModel : BaseViewModel() {

    private val _image = MutableLiveData<String>()
    val image: LiveData<String>
        get() = _image

    fun loadImage(img: String) {
        _image.value = img
    }

    fun downloadImg(url: String) {
        val retrofitImage = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val imageApi = retrofitImage.create(Api::class.java)
        val imageCall: Call<ResponseBody> = imageApi.downloadFileWithFixedUrl(url)
        imageCall.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>?, response: Response<ResponseBody?>) {
                if (response.isSuccessful) {
                    val inputStream: InputStream = response.body()!!.byteStream()
                    val bitmap = BitmapFactory.decodeStream(inputStream)
                    saveImage1(bitmap)
                }
            }

            override fun onFailure(call: Call<ResponseBody?>?, t: Throwable) {
            }
        })
    }

    private fun saveImage1(bitmap: Bitmap?) {
        val path = Environment.getExternalStorageDirectory().toString() + FOLDER
        val dir = File(path)
        if (!dir.exists()) {
            dir.mkdirs()
        }
        val file = File(
            path, System.currentTimeMillis().toString() + ".jpg"
        )
        try {
            val out = FileOutputStream(file)
            bitmap?.compress(Bitmap.CompressFormat.JPEG, 100, out)
            out.flush()
            out.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
