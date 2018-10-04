package com.gpetuhov.android.sampletoothpick

import com.gpetuhov.android.sampletoothpick.car.Jeep
import com.gpetuhov.android.sampletoothpick.engine.Engine
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import toothpick.testing.ToothPickRule
import javax.inject.Inject

class JeepTest {
    @get:Rule val mockitoRule: MockitoRule = MockitoJUnit.rule()
    @get:Rule val toothPickRule: ToothPickRule = ToothPickRule(this, "Jeep")

    @Mock lateinit var engine: Engine

    @Inject lateinit var jeep: Jeep

    @Before
    fun setUp() {
        toothPickRule.inject(this)

//        val testScope = Toothpick.openScopes(this)
//
//        testScope.installModules(object : Module() {
//            init {
//                bind(Engine::class.java) to engine
//            }
//        })
//
//        // Make the injection
//        Toothpick.inject(this, testScope)
//
//        jeep = Jeep()
    }

    @Test
    fun checkEngine() {
        Mockito.`when`(engine.getType()).thenReturn("Gas")
        assertEquals("Gas", jeep.getEngineType())
    }
}