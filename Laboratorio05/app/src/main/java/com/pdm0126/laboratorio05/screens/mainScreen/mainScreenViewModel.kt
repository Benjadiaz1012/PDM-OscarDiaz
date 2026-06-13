package com.pdm0126.laboratorio05.screens.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.laboratorio05.InitDatabase
import com.pdm0126.laboratorio05.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class mainScreenViewModel : ViewModel() {

    private val taskDao = InitDatabase.database.taskDao()

    val tasks = taskDao.getAllTasks()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addTask(title: String, description: String) {
        viewModelScope.launch {
            val newTask = Task(
                title = title,
                description = description
            )

            taskDao.insertTask(newTask)
        }
    }
}