package com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Volley

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Callbacks
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Callbacks.BaseNetworkCallbacks
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelsModel
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.EndPoints
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.RemoteDataSource
import org.json.JSONObject
import java.util.*


/**
 * Created by AbdAllah Abd-El-Fattah on 23-Mar-18.
 */

class RemoteDataSourceUsingVolley private constructor(context: Context) : RemoteDataSource {
    private val TAG = "B.remoteDSVolley"

    private var mQueue: VolleyImplementation = VolleyImplementation.getInstance(context)

    private fun <ResponseType> getDefaultErrorHandler(callbacks: BaseNetworkCallbacks<ResponseType>): Response.ErrorListener {
        return Response.ErrorListener { error ->
            Log.d(TAG, "onErrorResponse: error: " + error)
            if (error.networkResponse != null)
                Log.d(TAG, "onErrorResponse: error.networkResponse.statusCode: " + error.networkResponse.statusCode)
            Log.d(TAG, "onErrorResponse: error.getLocalizedMessage: " + error.localizedMessage)
            Log.d(TAG, "onErrorResponse: error.getStackTrace: " + Arrays.toString(error.stackTrace))
            callbacks.onError(error.toString())
        }
    }

    private fun <ResponseType> createGsonRequest(url: String, requestMethod: Int, responseTypeClass: Class<ResponseType>,
                                                 objectToSend: JSONObject?, callbacks: BaseNetworkCallbacks<ResponseType>): GsonRequest<ResponseType> {
        return GsonRequest(
                requestMethod,
                url,
                responseTypeClass, null,
                objectToSend,
                Response.Listener<ResponseType> { response -> callbacks.onSuccess(response) }, getDefaultErrorHandler(callbacks))
    }

    private fun <ResponseType> addRequestToTheQueue(request: Request<ResponseType>) {
        mQueue.addToRequestQueue(request)
    }

    private fun <ResponseType> addRequestToTheQueue(request: Request<ResponseType>, requestTag: String) {
        request.setTag(requestTag)
        addRequestToTheQueue<ResponseType>(request)
    }

    private fun <ResponseType> sendGetGsonRequest(url: String, responseTypeClass: Class<ResponseType>,
                                                  callbacks: BaseNetworkCallbacks<ResponseType>) {
        Log.d(TAG, "sendGetGsonRequest: " + url)
        addRequestToTheQueue(createGsonRequest(url, Request.Method.GET, responseTypeClass, null, callbacks))
    }

    override fun getHotels(callbacks: Callbacks.GetHotelsCallbacks) {
        this.sendGetGsonRequest<HotelsModel>(EndPoints.HotelsEndPoint, HotelsModel::class.java, callbacks)
    }

    companion object {
        private var INSTANCE: RemoteDataSourceUsingVolley? = null

        fun getInstance(context: Context): RemoteDataSourceUsingVolley {
            if (INSTANCE == null)
                INSTANCE = RemoteDataSourceUsingVolley(context)
            return INSTANCE!!
        }
    }
}