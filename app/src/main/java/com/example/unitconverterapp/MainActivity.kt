package com.example.unitconverterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.unitconverterapp.compose.BaseScreen
import com.example.unitconverterapp.data.ConvertersDatabase
import com.example.unitconverterapp.data.ConvertersRepository
import com.example.unitconverterapp.data.ConvertersRepositoryImpl
import com.example.unitconverterapp.ui.theme.UnitConverterAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var factory : ConverterViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     //   val dao = ConvertersDatabase.getInstance(application).converterDao
     //   val repository : ConvertersRepository = ConvertersRepositoryImpl(dao)



        setContent {
            UnitConverterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
               BaseScreen(factory)
                }
            }
        }
    }
}

