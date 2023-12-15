package com.example.unitconverterapp.compose.converter

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable


import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.unitconverterapp.data.Conversion

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversionMenu(isLandScaped:Boolean,list:List<Conversion>, modifier:Modifier=Modifier, convert:(Conversion) -> Unit){

    var displayingText  by rememberSaveable{ mutableStateOf("Select the conversion type") }
    var textFieldSize  by remember{ mutableStateOf(Size.Zero) }
    var expanded  by remember{ mutableStateOf(false) }

    val icon = if
            (expanded)
    { Icons.Filled.KeyboardArrowUp}
            else
    {Icons.Filled.KeyboardArrowDown}



Column {

    if (isLandScaped){

        OutlinedTextField(value = displayingText , onValueChange = {
            displayingText = it
        }, textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = modifier
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                }
            , label = {
                Text(text = "Conversion Type")
            } ,
            trailingIcon = {
                Icon(icon , contentDescription = "icon",modifier.clickable {
                    expanded = !expanded
                })

            },
            readOnly = true

        )
    }else{
        OutlinedTextField(value = displayingText , onValueChange = {
            displayingText = it
        }, textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            modifier = modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    textFieldSize = coordinates.size.toSize()
                }
            , label = {
                Text(text = "Conversion Type")
            } ,
            trailingIcon = {
                Icon(icon , contentDescription = "icon",modifier.clickable {
                    expanded = !expanded
                })

            },
            readOnly = true

        )

    }

    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false },
        modifier = Modifier
            .width(with(LocalDensity.current,{textFieldSize.width.toDp()}))) {

        list.forEach{conversion->
            DropdownMenuItem(text = {
                Text(text = conversion.description, fontSize = 24.sp,
                fontWeight = FontWeight.Bold) }, onClick = {
                expanded=false
                displayingText= conversion.description
                convert(conversion)
                 })

            DropdownMenuItem(text = { /*TODO*/ }, onClick = { /*TODO*/ })


        }

    }




}


}