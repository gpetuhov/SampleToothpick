package com.gpetuhov.android.sampletoothpick

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gpetuhov.android.sampletoothpick.model.Car
import com.gpetuhov.android.sampletoothpick.model.Jeep
import kotlinx.android.synthetic.main.activity_main.*
import toothpick.Toothpick
import toothpick.config.Module
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scope = Toothpick.openScopes(application, this)
        scope.installModules(object : Module() {
            init {
                bind(Car::class.java).to(Jeep::class.java)
            }
        })
        Toothpick.inject(this, scope)

//        textView.text = car.getEngineType()
        textView.text = car.toString()
    }
}
