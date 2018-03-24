package com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Volley

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

/**
 * Created by AbdAllah Abd-El-Fattah on 23-Mar-18.
 */
class VolleyImplementation private constructor(context: Context) {
    private val mRequestQueue: RequestQueue

    init {
        mRequestQueue = Volley.newRequestQueue(context.applicationContext)
    }


    fun <T> addToRequestQueue(req: Request<T>) {
        mRequestQueue.add(req)
    }

    companion object {
        @Volatile private var ourInstance: VolleyImplementation? = null


        @Synchronized
        fun getInstance(context: Context): VolleyImplementation {
            if (ourInstance == null) {
                ourInstance = VolleyImplementation(context)
            }
            return ourInstance!!
        }
    }
}
