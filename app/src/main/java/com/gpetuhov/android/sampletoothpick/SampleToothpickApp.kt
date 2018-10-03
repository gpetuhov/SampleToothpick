package com.gpetuhov.android.sampletoothpick

import android.app.Application
import com.gpetuhov.android.sampletoothpick.model.Diesel
import com.gpetuhov.android.sampletoothpick.model.Engine
import toothpick.Toothpick
import toothpick.config.Module


class SampleToothpickApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val appScope = Toothpick.openScope(this)
        appScope.installModules(object : Module() {
            init {
                bind(Engine::class.java).to(Diesel::class.java)
            }
        })
        Toothpick.inject(this, appScope)
    }
}