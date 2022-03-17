package com.example.bmi2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bmi2.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    val REQUSET_DISPLAY_BMI = 16
    lateinit var binding: ActivityMainBinding
//    lateinit var viewModel: BmiViewModel
    val viewModel by viewModels<BmiViewModel>()
    var launcher = registerForActivityResult(NameContract()){ name ->
        Log.d(TAG, "$name")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        viewModel = ViewModelProvider(this).get(BmiViewModel::class.java)
        viewModel.bmi.observe(this) { bmi ->
            binding.tvBmi.setText(bmi.toString())
        }
        binding.bHelp.setOnClickListener {
            Log.d("MainActivity", "help clicked")
        }
    }

    fun bmi(view: View) {
//        Log.v() //verbose
        Log.d("MainActivity", "clicked") //debug after online delete
//        Log.i() //information after online sometimes delete
//        Log.w() //warining
//        Log.e() //error
        var weight = binding.edWeight.text.toString().toFloat()
        var height = binding.edHeight.text.toString().toFloat()
        viewModel.set(weight, height)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        Log.d(TAG, "onActivityResult")
//        if (requestCode == REQUSET_DISPLAY_BMI && resultCode == RESULT_OK) {
//            Log.d(TAG, "back from ResultActivity")
//        }
//    }

    class NameContract : ActivityResultContract<Float, String>() { //<傳入值,傳出值>
        override fun parseResult(resultCode: Int, intent: Intent?): String {
            if (resultCode == RESULT_OK) {
                val name = intent?.getStringExtra(Extras.NAME)
                return name!!
            } else {
                return "no Name"
            }
        }
//        override fun createIntent(context: Context, input: Float?): Intent {
//            val intent = Intent(context, ResultActivity::class.java)
//                .putExtra(Extras.BMI, input)
//            return intent
//        }

        override fun createIntent(context: Context, input: Float): Intent {
            val intent = Intent(context, ResultActivity::class.java)
                .putExtra(Extras.BMI, input)
            return intent
        }
    }

    //Callback function
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestory: ")
    }
}