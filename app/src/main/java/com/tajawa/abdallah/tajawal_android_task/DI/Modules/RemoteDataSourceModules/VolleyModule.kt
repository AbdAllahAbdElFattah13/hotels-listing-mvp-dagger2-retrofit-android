package com.tajawa.abdallah.tajawal_android_task.DI.Modules.RemoteDataSourceModules

import android.content.Context
import com.tajawa.abdallah.tajawal_android_task.DataLayer.Remote.Volley.VolleyImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class VolleyModule {
    @Provides
    @Singleton
    fun provideVolleyImplementation(context: Context): VolleyImplementation = VolleyImplementation(context)
}