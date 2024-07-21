package com.yael.todoapp.data.remote.response

data class GeneralResponse(
  val salt:String,
  val estatus:Int,
  val resultado:Any?,
  val mensaje:String
)
