package com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Retrofit.Services

import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelsModel
import retrofit2.Call
import retrofit2.http.GET

interface HotelsServices {
    @GET("tajawal/hotels_exercise.json")
    fun listHotels(): Call<HotelsModel>
}