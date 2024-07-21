package com.yael.todoapp.domain.useCase

import com.yael.todoapp.domain.listeners.GetAllTaskListener
import com.yael.todoapp.domain.listeners.SessionListener
import com.yael.todoapp.domain.repositories.TaskRepository
import com.yael.todoapp.domain.repositories.UserRepository
import javax.inject.Inject

class DashboardUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val taskRepository: TaskRepository
) {

    fun invokeValidateSession(listener: SessionListener){
        userRepository.validate(listener)
    }

    fun invokeGetAllTasks(listener: GetAllTaskListener){
        taskRepository.getAllTasks(listener)
    }
}