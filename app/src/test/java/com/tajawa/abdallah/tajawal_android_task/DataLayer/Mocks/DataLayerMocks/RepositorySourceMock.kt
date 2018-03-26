package com.tajawa.abdallah.tajawal_android_task.DataLayer.Mocks.DataLayerMocks

import com.tajawa.abdallah.tajawal_android_task.DataLayer.Callbacks
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelModel
import com.tajawa.abdallah.tajawal_android_task.DataLayer.RepositorySource

/**
 * Created by AbdAllah Boda on 26-Mar-18.
 */
class RepositorySourceMock : RepositorySource {


    override fun getHotels(callbacks: Callbacks.GetHotelsCallbacks) {
    }

    override fun setCurrentSelectedHotel(currentSelectedHotelIndex: Int) {
    }

    override fun getCurrentSelectedHotel(): HotelModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}