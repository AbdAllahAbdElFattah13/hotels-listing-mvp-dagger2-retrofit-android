package com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter


import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.tajawa.abdallah.tajawal_android_task.Activitys.ImageLoaderUtil
import com.tajawa.abdallah.tajawal_android_task.R


/**
 * Created by AbdAllah Abd-El-Fattah on 23-Mar-18.
 */
class HotelItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), HotelItemRowView, View.OnClickListener {

    private lateinit var onHotelItemClick: HotelItemRowView.HandleOnHotelItemClick
    private val mTitleTv: TextView = itemView.findViewById(R.id.tv_title)
    private val mImageIv: ImageView = itemView.findViewById(R.id.iv_hotel_image)

    init {
        itemView.setOnClickListener(this)
    }

    override fun setOnHotelItemClickHandler(onHotelItemClick: HotelItemRowView.HandleOnHotelItemClick) {
        this.onHotelItemClick = onHotelItemClick
    }

    override fun setTitle(title: String) {
        mTitleTv.text = title
    }

    override fun setImage(imageUrl: String) {
        ImageLoaderUtil.loadImage(url = imageUrl, imageView = mImageIv)
    }

    override fun onClick(v: View) {
        this.onHotelItemClick.onHotelItemClick(adapterPosition)
    }
}