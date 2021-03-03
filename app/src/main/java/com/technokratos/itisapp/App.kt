package com.technokratos.itisapp

import android.app.Application
import com.technokratos.itisapp.di.AppComponent
import com.technokratos.itisapp.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .build()
    }
}