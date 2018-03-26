package com.tajawa.abdallah.tajawal_android_task.DataLayer.Mocks.PresentationLayerMocks.PresentersMocks

import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter.HotelItemViewHolder
import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.ListingHotelsContract
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelsModel

/**
 * Created by AbdAllah Boda on 26-Mar-18.
 */
class HotelsListingPresenterMock : ListingHotelsContract.Presenter {
    override fun setView(view: ListingHotelsContract.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeView(view: ListingHotelsContract.View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onGetHotelsSuccess(hotelsMode: HotelsModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onGetHotelsFail(err: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindHotelRowViewAtPosition(holder: HotelItemViewHolder, Position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getHotelNumbers(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}