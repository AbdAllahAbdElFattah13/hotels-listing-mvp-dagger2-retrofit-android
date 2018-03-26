package com.tajawa.abdallah.tajawal_android_task.DataLayer

import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelModel

/**
 * Created by AbdAllah Abd-El-Fattah on 23-Mar-18.
 */
interface RepositorySource {
    fun getHotels(callbacks: Callbacks.GetHotelsCallbacks)

    //to allow presenters to send data to each other,
    //it should be provided throw the repo.
    //refer to this link for more thought about the topic.
    //
    fun setCurrentSelectedHotel(currentSelectedHotelIndex: Int)

    fun getCurrentSelectedHotel(): HotelModel

    fun setCurrentHotelImageUrl(imageUrl: String)

    fun getCurrentHotelImageUrl(): String
}