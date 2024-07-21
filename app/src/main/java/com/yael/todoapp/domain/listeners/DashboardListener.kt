package com.yael.todoapp.domain.listeners

import com.yael.todoapp.domain.models.Task

interface GetAllTaskListener {
    fun onGetAllTaskSuccess(taskList:List<Task>)
    fun onError(msgE:String)
}

interface SessionListener {
    fun onValidSession()
    fun onSessionExpired()
}