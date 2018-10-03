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

    // This property is injected by Toothpick.
    // Note that it is of type Car.
    @Inject lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Open new scope for the activity.
        // This scope is the child of the application's scope.
        val scope = Toothpick.openScopes(application, this)

        scope.installModules(object : Module() {
            init {
                // Here we tell Toothpick to inject Jeep instance
                // for the injected properties of Car type
                // (this is like Dagger's provide() method).
                bind(Car::class.java).to(Jeep::class.java)
            }
        })

        // Make the injection
        Toothpick.inject(this, scope)

//        textView.text = car.getEngineType()
        textView.text = car.toString()
    }

    override fun onDestroy() {
        // When the object (in our case - activity) dies,
        // we must close its associated scope.
        Toothpick.closeScope(this)

        super.onDestroy()
    }
}
