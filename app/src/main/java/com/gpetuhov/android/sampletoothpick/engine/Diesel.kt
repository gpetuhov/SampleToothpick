package com.gpetuhov.android.sampletoothpick.engine

import javax.inject.Inject

// This is Diesel, that implements Engine interface.
// For this class to be injected, its constructor must be annotated with @Inject annotation.
class Diesel @Inject constructor() : Engine {
    override fun getType(): String {
        return "Diesel"
    }
}