package com.example.bmi2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ResultActivity : AppCompatActivity() {
    companion object {
        private val TAG = ResultActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val bmi = intent.getFloatExtra("BMI_EXTRA", 0f)
        Log.d(TAG, "BMI: $bmi")
    }
}