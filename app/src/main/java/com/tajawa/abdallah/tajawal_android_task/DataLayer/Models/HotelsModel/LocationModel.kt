package com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel

import com.google.gson.annotations.SerializedName

data class LocationModel(

	@field:SerializedName("address")
	val address: String,

	@field:SerializedName("latitude")
	val latitude: Double,

	@field:SerializedName("longitude")
	val longitude: Double
)