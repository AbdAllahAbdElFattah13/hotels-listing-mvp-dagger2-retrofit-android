package com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter


import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.tajawa.abdallah.tajawal_android_task.R


/**
 * Created by AbdAllah Boda on 23-Mar-18.
 */
class HotelItemViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), HotelItemRowView {

    private val mTitleTv: TextView = itemView?.findViewById(R.id.tv_title)!!
    private val mImageIv: ImageView = itemView?.findViewById(R.id.iv_hotel_image)!!


    override fun setTitle(title: String) {
        mTitleTv.text = title
    }

    override fun setImage(imageUrl: String) {
    }

}