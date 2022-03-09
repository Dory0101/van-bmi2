package com.example.bmi2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bmi2.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    companion object {
        private val TAG = ResultActivity::class.java.simpleName
    }
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showBmi()
        binding.bDone.setOnClickListener{
            val name = binding.edName.text.toString()
            val data = Intent()
            //Java usage
            data.putExtra(Extras.NAME, name)
            setResult(RESULT_OK, data)       //"result ok" means it have data
            finish()
        }
    }

    private fun showBmi() {
        val bmi = intent.getFloatExtra(Extras.BMI, 0f)
        Log.d(TAG, "BMI: $bmi")
        binding.bmiDisplay.text = bmi.toString()
    }
}