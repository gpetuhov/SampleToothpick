package com.gpetuhov.android.sampletoothpick

import android.app.Application
import com.gpetuhov.android.sampletoothpick.model.Diesel
import com.gpetuhov.android.sampletoothpick.model.Engine
import toothpick.Toothpick
import toothpick.config.Module


class SampleToothpickApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // Open new scope for the application.
        // This will be the root scope.
        val appScope = Toothpick.openScope(this)

        // Create new module and install it for the scope
        // (this is like Dagger's module).
        appScope.installModules(object : Module() {
            init {
                // Tell Toothpick to inject Diesel instances for
                // the injected values of type Engine.
                bind(Engine::class.java).to(Diesel::class.java)
            }
        })
//        Toothpick.inject(this, appScope)
    }
}