package com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels

import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter.HotelItemRowView
import com.tajawa.abdallah.tajawal_android_task.Activitys.ListingHotels.Adapters.HotelItemsAdapter.HotelItemsAdapter
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Callbacks
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Models.HotelsModel.HotelsModel
import com.tajawa.abdallah.tajawal_android_task.DataLayer.RepositorySource
import javax.inject.Inject

/**
 * Created by AbdAllah Abd-El-Fattah on 23-Mar-18.
 */
class ListingHotelsPresenter @Inject constructor(private val mDataRepo: RepositorySource) : ListingHotelsContract.Presenter, HotelItemRowView.HandleOnHotelItemClick {

    var mView: ListingHotelsContract.View? = null
    var mModel: HotelsModel? = null

    override fun setView(view: ListingHotelsContract.View) {
        mView = view
        /**
         * if (created || recreated && !comingFromChild)
         *
         */
        mView!!.setLoading(loading = true)
        mDataRepo.getHotels(object : Callbacks.GetHotelsCallbacks {
            override fun onSuccess(result: HotelsModel) {
                onGetHotelsSuccess(hotelsMode = result)
            }

            override fun onError(err: String) {
                onGetHotelsFail(err)
            }
        })
    }

    override fun removeView() {
        //to do any clearing logic required
    }

    override fun onGetHotelsSuccess(hotelsMode: HotelsModel) {
        if (mView == null)//i.e calling onGetHotelsSuccess before setting the view
            throw IllegalStateException("Should've called setView first")
        mModel = hotelsMode
        mView!!.setHotelItemsAdapter(HotelItemsAdapter(presenter = this@ListingHotelsPresenter))
        mView!!.setError("")
        mView!!.setLoading(loading = false)
    }

    override fun onGetHotelsFail(err: String) {
        if (mView == null) //i.e calling before calling setView
            throw IllegalStateException("Should've called setView first")

        mView!!.setLoading(loading = false)
        mView!!.setError(errMsg = err)
    }

    override fun onBindHotelRowViewAtPosition(holder: HotelItemRowView, Position: Int) {
        //we won't check for the position [0, mModel.size) here,
        //onBindHotelRowViewAtPosition will be called from
        //within the recycler view class. Will consider it safe
        //for now.

        //will also assume that the model completely
        //constructed internally. (i.e HotelsModel doesn't
        //contain any nulls)

        //but we have to check if the model has been set or
        //not though.

        if (mModel == null)
            throw IllegalStateException("should've called" +
                    " onGetHotelsSuccess be for starting to " +
                    "bind")

        val sCurrentHotel = mModel!!.hotel[Position]
        holder.setOnHotelItemClickHandler(this)
        holder.setTitle(sCurrentHotel.summary.hotelName)
        holder.setImage(sCurrentHotel.image[0].url)
    }

    override fun getHotelNumbers(): Int {
        //will also assume that the model completely
        //constructed internally. (i.e HotelsModel doesn't
        //contain any nulls)

        //but we have to check if the model has been set or
        //not though.
        if (mModel == null)
            throw IllegalStateException("should've called" +
                    " onGetHotelsSuccess be for starting to " +
                    "bind")

        return mModel!!.hotel.size
    }

    override fun onHotelItemClick(index: Int) {
        if (mView == null) //i.e without calling setView
            throw IllegalStateException("Should've called setView first!")
        mDataRepo.setCurrentSelectedHotel(index)
        mView!!.startDetailsActivity()
    }
}