package com.gpetuhov.android.sampletoothpick

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gpetuhov.android.sampletoothpick.model.Car
import com.gpetuhov.android.sampletoothpick.model.Jeep
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        car = Jeep()

        textView.text = car.getEngineType()
    }
}
