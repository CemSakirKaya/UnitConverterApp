package com.example.unitconverterapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ConversionResult::class], version = 1)
abstract class ConvertersDatabase : RoomDatabase() {
    abstract val converterDao : ConverterDao

  /*  companion object{
        @Volatile
        private var INSTANCE :ConvertersDatabase? = null

        fun getInstance(context: Context): ConvertersDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room
                        .databaseBuilder(context,ConvertersDatabase::class.java,"ConvertersDatabase")
                        .build()
                }
                return instance
            }

        }
    }*/
}