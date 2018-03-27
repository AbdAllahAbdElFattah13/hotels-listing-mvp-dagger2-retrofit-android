package com.tajawa.abdallah.tajawal_android_task.Mocks.DataLayerMocks

import com.tajawa.abdallah.tajawal_android_task.DataLayer.Callbacks
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelModel
import com.tajawa.abdallah.tajawal_android_task.DataLayer.RepositorySource
import com.tajawa.abdallah.tajawal_android_task.Mocks.DataLayerMocks.ModelsMocks.HotelsModelMock

/**
 * Created by AbdAllah Boda on 26-Mar-18.
 */
class RepositorySourceMock : RepositorySource {

    val mMockedModel = HotelsModelMock.getHotels()
    var mMockedCurrentSelectedHotel = -1
    var mCurrentHotelImage = ""
    var mCallSuccessCallbacks = true

    override fun getHotels(callbacks: Callbacks.GetHotelsCallbacks) {
        if (mCallSuccessCallbacks) callbacks.onSuccess(mMockedModel) else callbacks.onError("failed")
    }

    override fun setCurrentSelectedHotel(currentSelectedHotelIndex: Int) {
        mMockedCurrentSelectedHotel = currentSelectedHotelIndex
    }

    override fun getCurrentSelectedHotel(): HotelModel = mMockedModel.hotel[0]

    override fun setCurrentHotelImageUrl(imageUrl: String) {
        mCurrentHotelImage = imageUrl
    }

    override fun getCurrentHotelImageUrl(): String = mMockedModel.hotel[0].image[0].url
}