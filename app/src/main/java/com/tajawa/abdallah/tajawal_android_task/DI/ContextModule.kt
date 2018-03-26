package com.tajawa.abdallah.tajawal_android_task.DI

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by AbdAllah Boda on 25-Mar-18.
 */
@Module
class ContextModule(private val appContext: Application) {
    @Provides
    @Singleton
    fun provideContext(): Context = appContext
}