package com.yael.todoapp.domain.models

data class Task(
    val descripcion: String,
    val fecha: String,
    val id: Int,
    val prioridad: String,
    val status: Boolean
)
