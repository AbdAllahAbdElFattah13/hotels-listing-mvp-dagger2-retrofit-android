package com.tajawa.abdallah.tajawal_android_task.PresentationLayer

/**
 * Created by AbdAllah Abd-El-Fattah on 23-Mar-18.
 */
interface BasePresenter<tView> {
    fun setView(view: tView)

    fun removeView(view: tView)
}