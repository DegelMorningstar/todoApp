package com.yael.todoapp.data.remote.response.user

data class LoginResponse(
    val salt:String,
    val estatus:Int,
    val resultado: JwtResponse?,
    val mensaje:String
)

data class JwtResponse(
  val jwt:String
)
