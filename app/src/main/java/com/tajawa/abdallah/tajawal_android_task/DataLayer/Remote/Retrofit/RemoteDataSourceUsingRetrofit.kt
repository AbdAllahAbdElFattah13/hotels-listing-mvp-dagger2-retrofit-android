package com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Retrofit

import com.tajawa.abdallah.tajawal_android_task.DataLayer.Callbacks
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelsModel
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.RemoteDataSource
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Retrofit.Services.HotelsServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceUsingRetrofit @Inject constructor(val mHotelsServices: HotelsServices) : RemoteDataSource {
    override fun getHotels(callbacks: Callbacks.GetHotelsCallbacks) {
        val call = mHotelsServices.listHotels()
        call.enqueue(object : Callback<HotelsModel> {
            override fun onResponse(call: Call<HotelsModel>?, response: Response<HotelsModel>) {
                if (response.isSuccessful)
                    callbacks.onSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<HotelsModel>?, t: Throwable) {
                callbacks.onError(t.toString())
            }
        })
    }
}