package com.tajawa.abdallah.tajawal_android_task.DataLayer.Mocks.PresentationLayerMocks.ViewsMocks

import com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel.DetailsHotelContract

/**
 * Created by AbdAllah Boda on 26-Mar-18.
 */
class HotelDetailsViewMock : DetailsHotelContract.View {

    lateinit var mImageUrl: String
    lateinit var mName: String
    lateinit var mAddress: String
    lateinit var mLowRate: String
    lateinit var mHighRate: String

    override fun setImageUrl(imageUrl: String) {
        this.mImageUrl = imageUrl
    }

    override fun setHotelName(name: String) {
        this.mName = name
    }

    override fun setHotelAddress(address: String) {
        this.mAddress = address
    }

    override fun setLowRate(lowRate: String) {
        this.mLowRate = lowRate
    }

    override fun setHighRate(highRate: String) {
        this.mHighRate = highRate
    }
}