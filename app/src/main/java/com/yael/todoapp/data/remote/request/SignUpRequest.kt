package com.yael.todoapp.data.remote.request

data class SignUpRequest(
  val nombre:String,
  val apellidos:String,
  val email:String,
  val password:String,
  val confirmPassword:String
)
