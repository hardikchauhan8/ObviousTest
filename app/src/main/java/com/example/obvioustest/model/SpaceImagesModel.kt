package com.example.obvioustest.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SpaceImagesModel(

    @SerializedName("date")
    val date: String,

    @SerializedName("copyright")
    val copyright: String,

    @SerializedName("mediaType")
    val mediaType: String,

    @SerializedName("hdurl")
    val hdurl: String,

    @SerializedName("serviceVersion")
    val serviceVersion: String,

    @SerializedName("explanation")
    val explanation: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("url")
    val url: String

) : Parcelable