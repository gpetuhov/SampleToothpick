package com.gpetuhov.android.sampletoothpick

import android.app.Application
import com.gpetuhov.android.sampletoothpick.engine.Diesel
import com.gpetuhov.android.sampletoothpick.engine.Engine
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
                // Since this is the module of the root scope,
                // this rule will be valid throughout the application.
                bind(Engine::class.java).to(Diesel::class.java)
            }
        })

        // Our application class has no injected properties,
        // so no need to call Toothpick.inject() here.
    }
}