package com.yael.todoapp.data.remote.response.task

import com.yael.todoapp.domain.models.Task

data class TaskResponse(
    val estatus: Int,
    val mensaje: String,
    val resultado: List<Task>,
    val salt: String
)