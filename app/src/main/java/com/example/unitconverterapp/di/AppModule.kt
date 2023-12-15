package com.example.unitconverterapp.di

import android.app.Application
import androidx.room.Room
import com.example.unitconverterapp.data.ConvertersDatabase
import com.example.unitconverterapp.data.ConvertersRepository
import com.example.unitconverterapp.data.ConvertersRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideConvertersDatabase(app:Application):ConvertersDatabase =
        Room.databaseBuilder(app,ConvertersDatabase::class.java,"converters_data_database")
            .build()


    @Provides
    @Singleton
    fun provideConvertersResository(db:ConvertersDatabase):ConvertersRepository =
        ConvertersRepositoryImpl(db.converterDao)








}