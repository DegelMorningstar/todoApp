package com.yael.todoapp.domain.useCase

import com.yael.todoapp.domain.listeners.LoginListener
import com.yael.todoapp.domain.repositories.UserRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
  private val userRepository: UserRepository
) {

  fun invokeLogin(email:String,password:String,listener: LoginListener){
    userRepository.login(
      email = email,
      password = password,
      listener = listener
    )
  }
}