package com.yael.todoapp.domain.repositories

import com.yael.todoapp.domain.listeners.GetAllTaskListener

interface TaskRepository {

    fun getAllTasks(listener:GetAllTaskListener)
}