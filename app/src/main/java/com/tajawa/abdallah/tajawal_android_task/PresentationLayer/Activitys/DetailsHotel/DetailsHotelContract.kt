package com.tajawa.abdallah.tajawal_android_task.Activitys.DetailsHotel

import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelModel
import com.tajawa.abdallah.tajawal_android_task.PresentationLayer.BasePresenter

/**
 * Created by AbdAllah Abd-El-Fattah on 23-Mar-18.
 */
/**
 * Following the MVP principles, we should make
 * the view as dump as we can (i.e has no logic whatsoever)
 * and move all of the presentation logic to the presenter.s
 */
interface DetailsHotelContract {

    interface View {
        fun setImageUrl(imageUrl: String)

        fun setHotelName(name: String)

        fun setHotelAddress(address: String)

        fun setLowRate(lowRate: String)

        fun setHighRate(highRate: String)
    }

    interface Presenter : BasePresenter<View> {
        fun onGetCurrentSelectedHotelSuccess(currentHotel: HotelModel)
    }

}