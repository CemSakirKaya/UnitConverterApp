package com.example.unitconverterapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.unitconverterapp.data.ConvertersRepository
import javax.inject.Inject

class ConverterViewModelFactory @Inject constructor (private val convertersRepository: ConvertersRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ConverterViewModel(convertersRepository) as T
    }
}