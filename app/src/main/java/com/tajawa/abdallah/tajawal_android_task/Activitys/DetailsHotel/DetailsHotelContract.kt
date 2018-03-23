package com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel

import com.tajawa.abdallah.tajawal_android_task.BasePresenter

/**
 * Created by AbdAllah Boda on 23-Mar-18.
 */
interface DetailsHotelContract {

    interface View {
        fun setImageUrl(imageUrl: String)

        fun setHotelName(name: String)

        fun setHotelAddress(address: String)

        fun setLowRate(lowRate: String)

        fun setHighRate(highRate: String)
    }

    interface Presenter : BasePresenter

}