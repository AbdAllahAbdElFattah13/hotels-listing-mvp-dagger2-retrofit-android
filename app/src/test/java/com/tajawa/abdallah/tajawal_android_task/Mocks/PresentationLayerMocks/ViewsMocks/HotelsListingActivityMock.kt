package com.tajawa.abdallah.tajawal_android_task.Mocks.PresentationLayerMocks.ViewsMocks

import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter.HotelItemsAdapter
import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.ListingHotelsContract

/**
 * Created by AbdAllah Boda on 26-Mar-18.
 */
class HotelsListingActivityMock : ListingHotelsContract.View {
    override fun setLoading(loading: Boolean) {
    }

    override fun setError(errMsg: String) {
    }

    override fun setHotelItemsAdapter(hotelItemsAdapter: HotelItemsAdapter) {
    }

    override fun startDetailsActivity() {
    }
}