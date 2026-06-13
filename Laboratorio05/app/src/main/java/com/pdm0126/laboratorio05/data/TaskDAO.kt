package com.pdm0126.laboratorio05.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pdm0126.laboratorio05.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks ORDER BY id DESC")
    fun getAllTasks(): Flow<List<Task>>

    @Insert
    suspend fun insertTask(task: Task)
}