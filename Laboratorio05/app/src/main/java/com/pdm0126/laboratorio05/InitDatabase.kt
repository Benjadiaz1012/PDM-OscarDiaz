package com.pdm0126.laboratorio05

import android.app.Application
import androidx.room.Room
import com.pdm0126.laboratorio05.data.AppDatabase

class InitDatabase : Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "tasks_database"
        ).build()
    }
}