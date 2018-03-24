package com.tajawa.abdallah.tajawal_android_task.Activitys

import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.tajawa.abdallah.tajawal_android_task.R

/**
 * Created by AbdAllah Boda on 24-Mar-18.
 */
object ImageLoaderUtil {

    fun loadImage(url: String, imageView: ImageView, w: Int = 300, h: Int = 300, withPlaceholder: Boolean = true) {

        var request = Picasso.with(imageView.context).load(url)

        //pass any values less than 0 to not resize. (i.e if you want it to wrap content or match parent
        if (w > 0 && h > 0) request = request.resize(w, h).centerCrop()
        if (withPlaceholder) request = request.placeholder(R.drawable.progress_animation)
        request.into(imageView)
    }

}