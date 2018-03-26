package com.tajawa.abdallah.tajawal_android_task.DataLayer.Mocks.DataLayerMocks

import com.tajawa.abdallah.tajawal_android_task.DataLayer.Callbacks
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Mocks.DataLayerMocks.ModelsMocks.HotelsModelMock
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelModel
import com.tajawa.abdallah.tajawal_android_task.DataLayer.RepositorySource

/**
 * Created by AbdAllah Boda on 26-Mar-18.
 */
class RepositorySourceMock : RepositorySource {

    val mMockedModel = HotelsModelMock.getHotels()
    var mMockedCurrentSelectedHotel = -1

    override fun getHotels(callbacks: Callbacks.GetHotelsCallbacks) {
        callbacks.onSuccess(mMockedModel)
    }

    override fun setCurrentSelectedHotel(currentSelectedHotelIndex: Int) {
        mMockedCurrentSelectedHotel = currentSelectedHotelIndex
    }

    override fun getCurrentSelectedHotel(): HotelModel = mMockedModel.hotel[0]
}