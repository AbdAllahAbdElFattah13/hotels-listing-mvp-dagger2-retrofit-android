package com.tajawa.abdallah.tajawal_android_task.Mocks.PresentationLayerMocks.ViewsMocks

import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter.HotelItemsAdapter
import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.ListingHotelsContract

/**
 * Created by AbdAllah Boda on 26-Mar-18.
 */
class HotelsListingActivityMock : ListingHotelsContract.View {

    var mLoading: Boolean = false
    lateinit var mError: String
    var mHotelItemsAdapter: HotelItemsAdapter? = null
    var mComingFromHome: Boolean = false
    var mDetailsViewStarted: Boolean = false

    override fun setLoading(loading: Boolean) {
        this.mLoading = loading
    }

    override fun setError(errMsg: String) {
        this.mError = errMsg
    }

    override fun setHotelItemsAdapter(hotelItemsAdapter: HotelItemsAdapter) {
        mHotelItemsAdapter = hotelItemsAdapter
    }

    override fun isComingFromChild(): Boolean = mComingFromHome

    override fun startDetailsActivity() {
        mComingFromHome = true
        mDetailsViewStarted = true
    }
}