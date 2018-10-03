package com.gpetuhov.android.sampletoothpick.model

class Jeep : Car {
    val engine = Diesel()

    override fun getEngineType() = engine.getType()
}