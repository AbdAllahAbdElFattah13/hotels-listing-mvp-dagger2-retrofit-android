package com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Volley

import com.android.volley.AuthFailureError
import com.android.volley.NetworkResponse
import com.android.volley.ParseError
import com.android.volley.Response
import com.android.volley.toolbox.HttpHeaderParser
import com.android.volley.toolbox.JsonRequest
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

import org.json.JSONObject

import java.io.UnsupportedEncodingException

/**
 * Created by AbdAllah Abd-El-Fattah on 25-Feb-18.
 */

class GsonRequest<ResponseType>(method: Int, url: String, private val clazz: Class<ResponseType>, private val headers: Map<String, String>?,
                                jsonRequest: JSONObject?, private val listener: Response.Listener<ResponseType>,
                                errorListener: Response.ErrorListener) : JsonRequest<ResponseType>(method, url, jsonRequest?.toString(), listener, errorListener) {
    private val gson = Gson()

    constructor(method: Int, url: String, classType: Class<ResponseType>, jsonRequest: JSONObject,
                listener: Response.Listener<ResponseType>, errorListener: Response.ErrorListener) : this(method, url, classType, null, jsonRequest, listener, errorListener) {
    }

    @Throws(AuthFailureError::class)
    override fun getHeaders(): Map<String, String> {
        return headers ?: super.getHeaders()
    }

    override fun deliverResponse(response: ResponseType) {
        listener.onResponse(response)
    }

    override fun parseNetworkResponse(networkResponse: NetworkResponse): Response<ResponseType> {
        try {
//            val json = String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers))
            val json = String(networkResponse.data)

            return Response.success(gson.fromJson(json, clazz),
                    HttpHeaderParser.parseCacheHeaders(networkResponse))
        } catch (e: UnsupportedEncodingException) {
            return Response.error(ParseError(e))
        } catch (e: JsonSyntaxException) {
            return Response.error(ParseError(e))
        }

    }
}
