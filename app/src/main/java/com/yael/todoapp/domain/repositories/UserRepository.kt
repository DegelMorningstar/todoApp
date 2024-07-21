package com.yael.todoapp.domain.repositories

import com.yael.todoapp.domain.listeners.LoginListener
import com.yael.todoapp.domain.listeners.SessionListener

interface UserRepository {

  fun login(email:String,password:String,listener: LoginListener)
  fun signUp()
  fun validate(listener: SessionListener)
  fun profile()

}