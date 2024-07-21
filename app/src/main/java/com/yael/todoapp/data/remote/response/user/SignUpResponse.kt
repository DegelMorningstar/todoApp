package com.yael.todoapp.data.remote.response.user

data class SignUpResponse(
    val salt:String,
    val estatus:Int,
    val resultado: JwtResponse?,
    val mensaje:String
)

data class SignUpResultado(
    val id:Int,
    val email:String,
    val nombre:String,
    val apellidos:String,
    val role:List<SignUpRole>,
    val jwt:String
)

data class SignUpRole(
  val id:String,
  val nombre:String
)