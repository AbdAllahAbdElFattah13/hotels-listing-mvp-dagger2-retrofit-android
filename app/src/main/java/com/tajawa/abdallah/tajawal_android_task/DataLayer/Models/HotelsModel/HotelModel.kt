package com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel

import com.google.gson.annotations.SerializedName

data class HotelModel(

        @field:SerializedName("summary")
        val summary: SummaryModel,

        @field:SerializedName("image")
        val image: List<ImageModel>,

        @field:SerializedName("location")
        val location: LocationModel,

        @field:SerializedName("hotelId")
        val hotelId: Int
)