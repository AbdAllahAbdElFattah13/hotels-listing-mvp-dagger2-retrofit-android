package com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.ListingHotelsContract
import com.tajawa.abdallah.tajawal_android_task.R

/**
 * Created by AbdAllah Boda on 23-Mar-18.
 */
class HotelItemsAdapter(val presenter: ListingHotelsContract.Presenter) : RecyclerView.Adapter<HotelItemViewHolder>() {

    private val mPresenter: ListingHotelsContract.Presenter = presenter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelItemViewHolder {
        val context = parent.context
        val layoutIdForListItem = R.layout.hotel_item_view
        val inflater = LayoutInflater.from(context)
        val shouldAttachToParentImmediately = false

        val view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately)

        return HotelItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: HotelItemViewHolder, position: Int) {
        mPresenter.onBindHotelRowViewAtPosition(holder, position)
    }

    override fun getItemCount(): Int = mPresenter.getHotelNumbers()
}