package com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Volley

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import javax.inject.Inject

/**
 * Created by AbdAllah Abd-El-Fattah on 23-Mar-18.
 */
class VolleyImplementation @Inject constructor(context: Context) {

    private val mRequestQueue: RequestQueue = Volley.newRequestQueue(context.applicationContext)

    fun <T> addToRequestQueue(req: Request<T>) {
        mRequestQueue.add(req)
    }
}
