package com.tajawa.abdallah.tajawal_android_task.DataLayer

import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelModel

/**
 * Created by AbdAllah Abd-El-Fattah on 23-Mar-18.
 */
interface RepositorySource {
    fun getHotels(callbacks: Callbacks.GetHotelsCallbacks)

    fun setCurrentSelectedHotel(currentSelectedHotelIndex: Int)

    fun getCurrentSelectedHotel(): HotelModel
}