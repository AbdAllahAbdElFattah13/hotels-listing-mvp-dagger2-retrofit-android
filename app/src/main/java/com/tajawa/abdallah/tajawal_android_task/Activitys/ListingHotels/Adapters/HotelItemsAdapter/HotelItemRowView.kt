package com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter

/**
 * Created by AbdAllah Abd-El-Fattah on 23-Mar-18.
 */
interface HotelItemRowView {
    fun setOnHotelItemClickHandler(onHotelItemClick: HotelItemRowView.HandleOnHotelItemClick)

    fun setTitle(title: String)

    fun setImage(imageUrl: String)

    interface HandleOnHotelItemClick {
        fun onHotelItemClick(index: Int)
    }
}