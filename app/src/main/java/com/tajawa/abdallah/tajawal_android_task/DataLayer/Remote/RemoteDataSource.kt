package com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote

import com.tajawa.abdallah.tajawal_android_task.DataLayer.Callbacks

/**
 * Created by AbdAllah Abd-El-Fattah on 23-Mar-18.
 */
interface RemoteDataSource {
    fun getHotels(callbacks: Callbacks.GetHotelsCallbacks)
}