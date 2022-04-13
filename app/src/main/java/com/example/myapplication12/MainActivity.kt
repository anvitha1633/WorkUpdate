package com.example.myapplication12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.myapplication12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val tv : TextView = findViewById(R.id.sample_text)
        val b : Button = findViewById(R.id.button)
        // Example of a call to a native method
        b.setOnClickListener(View.OnClickListener {
            tv.text = stringFromJNI()
        })

    }

    /**
     * A native method that is implemented by the 'myapplication12' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'myapplication12' library on application startup.
        init {
            System.loadLibrary("myapplication12")
        }
    }
}