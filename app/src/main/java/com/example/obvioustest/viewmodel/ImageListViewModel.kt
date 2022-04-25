package com.example.obvioustest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.obvioustest.model.SpaceImagesModel
import com.google.gson.Gson

class ImageListViewModel(application: Application) : AndroidViewModel(application) {

    private val imageList = MutableLiveData<List<SpaceImagesModel>>()

    init {
        val data = application.assets.open("data.json").bufferedReader().use { it.readText() }
        imageList.postValue(Gson().fromJson(data, Array<SpaceImagesModel>::class.java).toList())
    }

    fun getImageList(): MutableLiveData<List<SpaceImagesModel>> {
        return imageList
    }
}