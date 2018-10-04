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

// In this test we are testing Jeep.
// But its dependency, Engine, is mocked by Mockito.
// ToothPickRule creates Jeep instance, injects mocked engine into it
// and then injects Jeep into JeepTest.

// For this to work, don't forget to include
// kaptTest "com.github.stephanenicolas.toothpick:toothpick-compiler:$toothpickVersion"
// into build.gradle!

class JeepTest {
    // We need 2 rules: for Mockito and for Toothpick
    // In Kotlin we must annotate getter (annotating the property itself doesn't work)
    @get:Rule val mockitoRule: MockitoRule = MockitoJUnit.rule()
    @get:Rule val toothPickRule: ToothPickRule = ToothPickRule(this, "Jeep")

    // We tell Mockito to create mock for Engine
    @Mock lateinit var engine: Engine

    // We tell Toothpick to inject Jeep
    @Inject lateinit var jeep: Jeep

    @Before
    fun setUp() {
        // This is where all the things get injected
        toothPickRule.inject(this)
    }

    @Test
    fun checkEngine() {
        val mockedEngineType = "Gas"

        // Tell Mockito, what to do, when engine.getType() is called
        Mockito.`when`(engine.getType()).thenReturn(mockedEngineType)

        // Check that now Jeep uses mocked Engine
        assertEquals(mockedEngineType, jeep.getEngineType())
    }
}