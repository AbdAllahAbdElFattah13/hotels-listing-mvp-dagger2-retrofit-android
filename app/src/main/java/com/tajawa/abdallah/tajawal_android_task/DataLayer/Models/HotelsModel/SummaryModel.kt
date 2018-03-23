package com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel

import com.google.gson.annotations.SerializedName

data class SummaryModel(

        @field:SerializedName("highRate")
        val highRate: Double,

        @field:SerializedName("lowRate")
        val lowRate: Double,

        @field:SerializedName("hotelName")
        val hotelName: String
)