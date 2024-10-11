package com.example.viikko7_viewmodel
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class BmiViewModel : ViewModel() {
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")
    var bmi by mutableStateOf(0.0f)

    private fun calculateBmi() {
        val height = heightInput.toFloatOrNull() ?: 0.0f
        val weight = weightInput.toFloatOrNull() ?: 0f
        bmi = if (weight > 0 && height > 0) weight / (height * height) else 0.0f
    }

    fun updateHeight(input: String) {
        heightInput = input.replace(',', '.')
        calculateBmi()
    }

    fun updateWeight(input: String) {
        weightInput = input.replace(',', '.')
        calculateBmi()
    }
}