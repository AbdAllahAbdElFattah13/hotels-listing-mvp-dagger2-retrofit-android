package com.tajawa.abdallah.tajawal_android_task.Mocks.PresentationLayerMocks.ViewsMocks

import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter.HotelItemRowView

/**
 * Created by AbdAllah Boda on 27-Mar-18.
 */
class HotelRowViewMock : HotelItemRowView {

    var mOnItemRowClick: HotelItemRowView.HandleOnHotelItemClick? = null
    lateinit var mTitle: String
    lateinit var mUrl: String

    override fun setOnHotelItemClickHandler(onHotelItemClick: HotelItemRowView.HandleOnHotelItemClick) {
        mOnItemRowClick = onHotelItemClick
    }

    override fun setTitle(title: String) {
        mTitle = title
    }

    override fun setImage(imageUrl: String) {
        mUrl = imageUrl
    }
}