package com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel

import com.google.gson.annotations.SerializedName

data class HotelsModel(

	@field:SerializedName("hotel")
	val hotel: List<HotelModel>
)