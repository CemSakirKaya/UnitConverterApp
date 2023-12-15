package com.example.unitconverterapp.compose.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.unitconverterapp.data.ConversionResult

@Composable
fun HistoryScreen(List: State<List<ConversionResult>>,
                  modifier: Modifier= Modifier,onCloseTask:(ConversionResult) -> Unit,onClearAllTask: ()-> Unit) {

    Column() {
        if (List.value.isNotEmpty()){
            Row(modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "History", color = Color.Gray)
                OutlinedButton(onClick = { onClearAllTask() }) {
                    Text(text = "Clear All", color = Color.Gray)
                }
            }
        }


        HistoryList(list = List,{
            onCloseTask(it)
        })
        
    }
    
    


}