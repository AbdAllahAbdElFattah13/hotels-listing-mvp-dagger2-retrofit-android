package com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels

import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter.HotelItemRowView
import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter.HotelItemsAdapter
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelsModel
import com.tajawa.abdallah.tajawal_android_task.PresentationLayer.BasePresenter

/**
 * Created by AbdAllah Abd-El-Fattah on 23-Mar-18.
 */
/**
 * Following the MVP principles, we should make
 * the view as dump as we can (i.e has no logic whatsoever)
 * and move all of the presentation logic to the presenter.s
 */
interface ListingHotelsContract {

    interface View {
        fun setLoading(loading: Boolean)

        fun setError(errMsg: String)

        fun setHotelItemsAdapter(hotelItemsAdapter: HotelItemsAdapter)

        fun startDetailsActivity()
    }

    interface Presenter : BasePresenter<View> {
        fun onGetHotelsSuccess(hotelsMode: HotelsModel)

        fun onGetHotelsFail(err: String)

        fun onBindHotelRowViewAtPosition(holder: HotelItemRowView, Position: Int)

        fun getHotelNumbers(): Int
    }
}