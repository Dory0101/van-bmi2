package com.example.bmi2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
// VM
class BmiViewModel : ViewModel() {
    val bmi = MutableLiveData<Float>()

    fun set(weight: Float, height: Float) { //no need to set return, it in live data
        val _bmi = weight/(height*height)
        bmi.value = _bmi
    }
}