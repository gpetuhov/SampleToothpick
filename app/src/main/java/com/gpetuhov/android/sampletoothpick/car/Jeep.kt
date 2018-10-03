package com.gpetuhov.android.sampletoothpick.car

import com.gpetuhov.android.sampletoothpick.engine.Engine
import javax.inject.Inject

// This is Jeep, that implements Car interface.
// Classes, that are injected, must have a constructor annotated with @Inject annotation
class Jeep @Inject constructor() : Car {

    // Engine property is injected by Toothpick
    @Inject lateinit var engine: Engine

    override fun getEngineType() = engine.getType()
}