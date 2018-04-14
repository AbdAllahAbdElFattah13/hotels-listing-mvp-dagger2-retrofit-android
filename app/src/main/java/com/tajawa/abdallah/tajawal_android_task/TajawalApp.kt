package com.tajawa.abdallah.tajawal_android_task

import android.app.Application
import com.tajawa.abdallah.tajawal_android_task.DI.Components.AppComponent
import com.tajawa.abdallah.tajawal_android_task.DI.Components.DaggerAppComponent
import com.tajawa.abdallah.tajawal_android_task.DI.Modules.ContextModule

/**
 * Created by AbdAllah Boda on 25-Mar-18.
 */
class TajawalApp : Application() {

    lateinit var mTajawalComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        mTajawalComponent = initDagger(this)
    }

    private fun initDagger(app: TajawalApp): AppComponent =
            DaggerAppComponent.builder()
                    .contextModule(ContextModule(app))
                    .build()
}