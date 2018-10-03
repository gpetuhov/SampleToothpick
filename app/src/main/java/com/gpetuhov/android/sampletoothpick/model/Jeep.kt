package com.gpetuhov.android.sampletoothpick.model

import javax.inject.Inject

// Classes, that are injected, must have a constructor annotated with @Inject annotation
class Jeep @Inject constructor() : Car {

//    @Inject
//    lateinit var engine: Engine

//    override fun getEngineType() = engine.getType()
    override fun getEngineType() = "sdfdsf"
}