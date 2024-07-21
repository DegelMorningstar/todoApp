package com.yael.todoapp.domain.listeners

interface LoginListener {
  fun onLoginSuccess(token:String?)
  fun onLoginError()
}