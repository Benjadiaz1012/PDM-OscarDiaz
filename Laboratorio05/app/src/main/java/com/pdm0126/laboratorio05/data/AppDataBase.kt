package com.pdm0126.laboratorio05.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pdm0126.laboratorio05.model.Task

@Database(
    entities = [Task::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}