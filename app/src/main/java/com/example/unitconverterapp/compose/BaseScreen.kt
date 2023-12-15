package com.example.unitconverterapp.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unitconverterapp.ConverterViewModel
import com.example.unitconverterapp.ConverterViewModelFactory
import com.example.unitconverterapp.compose.converter.TopScreen
import com.example.unitconverterapp.compose.history.HistoryScreen

@Composable
fun BaseScreen(
    factory: ConverterViewModelFactory,
     modifier: Modifier = Modifier,
    viewModel: ConverterViewModel = viewModel(factory = factory)
){
    val listofConversions = viewModel.getConversions()
    val historyList = viewModel.resultList.collectAsState(initial = emptyList())

    val configuration = LocalConfiguration.current

    var isLandScaped by remember {
        mutableStateOf(false)
    }

    when(configuration.orientation){
        Configuration.ORIENTATION_LANDSCAPE->{
            isLandScaped = true
            Row(modifier = modifier
                .padding(30.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround) {
                TopScreen(listofConversions,{message1,message2->
                    viewModel.addResults(message1,message2)
                },viewModel.selectedConversion,viewModel.typedValue,viewModel.inputText,isLandScaped )
                Spacer(modifier = modifier.width(10.dp))
                HistoryScreen(List = historyList, onCloseTask = {
                    viewModel.DeleteResults(it)
                } ) {
                    viewModel.DeleteAllResults()
                }
            }



        }
        else ->{
            isLandScaped = false
            Column(modifier = modifier.padding(30.dp)) {
                TopScreen(listofConversions,{message1,message2->
                    viewModel.addResults(message1,message2)
                },viewModel.selectedConversion,viewModel.typedValue,viewModel.inputText,isLandScaped )
                Spacer(modifier = modifier.height(20.dp))
                HistoryScreen(List = historyList, onCloseTask = {
                    viewModel.DeleteResults(it)
                } ) {
                    viewModel.DeleteAllResults()
                }
            }

        }
    }


    


}