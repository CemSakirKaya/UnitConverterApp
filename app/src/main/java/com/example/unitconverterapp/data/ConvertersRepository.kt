package com.example.unitconverterapp.data

import kotlinx.coroutines.flow.Flow

interface ConvertersRepository {

    suspend fun insertResult(conversionResult: ConversionResult)

    suspend fun deleteResult(conversionResult: ConversionResult)

    suspend fun deleteAllResult()

     fun getSavedResults(): Flow<List<ConversionResult>>



}