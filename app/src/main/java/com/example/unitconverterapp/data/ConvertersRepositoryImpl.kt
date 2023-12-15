package com.example.unitconverterapp.data

import kotlinx.coroutines.flow.Flow

class ConvertersRepositoryImpl(private val dao: ConverterDao) : ConvertersRepository {
    override suspend fun insertResult(conversionResult: ConversionResult) {
        dao.insertResult(conversionResult)
    }

    override suspend fun deleteResult(conversionResult: ConversionResult) {
        dao.deleteResult(conversionResult)
    }

    override suspend fun deleteAllResult() {
       dao.deleteAll()
    }

    override  fun getSavedResults(): Flow<List<ConversionResult>> {
        return dao.getResults()
    }

}