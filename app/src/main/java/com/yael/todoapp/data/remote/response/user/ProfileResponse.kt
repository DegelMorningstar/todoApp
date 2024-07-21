package com.yael.todoapp.data.remote.response.user

data class ProfileResponse(
    val salt:String,
    val estatus:Int,
    val resultado: ProfileResultado?,
    val mensaje:String
)


data class ProfileResultado(
    val id:Int,
    val email:String,
    val password:String,
    val nombre:String,
    val apellidos:String,
    val createAt:String,
    val authorities:List<ProfileAuthorities>,
    val username:String,
    val accountNonExpired:Boolean,
    val credentialsNonExpired:Boolean,
    val accountNonLocked:Boolean,
    val enabled:Boolean
)

data class ProfileAuthorities(
  val authority:String
)
