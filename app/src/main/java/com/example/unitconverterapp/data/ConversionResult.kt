package com.example.unitconverterapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_table")
data class ConversionResult (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("result_id")
    val id:Int,
    @ColumnInfo("result_massage1")
    val messagePart1:String,
    @ColumnInfo("result_massage2")
    val messagePart2:String
        )