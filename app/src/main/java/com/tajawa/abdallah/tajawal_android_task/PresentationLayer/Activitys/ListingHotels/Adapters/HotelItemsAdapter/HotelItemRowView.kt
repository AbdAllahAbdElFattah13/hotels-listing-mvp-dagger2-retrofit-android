package com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter

/**
 * Created by AbdAllah Abd-El-Fattah on 23-Mar-18.
 */
/**
 * Converting the ViewHolder class into normal View
 * in the spirit of MVP.
 * Should be implemented by the ViewHolderClass.
 * To read more: https://android.jlelse.eu/recyclerview-in-mvp-passive-views-approach-8dd74633158
 */
interface HotelItemRowView {
    fun setOnHotelItemClickHandler(onHotelItemClick: HotelItemRowView.HandleOnHotelItemClick)

    fun setTitle(title: String)

    fun setImage(imageUrl: String)

    interface HandleOnHotelItemClick {
        fun onHotelItemClick(index: Int)
    }
}