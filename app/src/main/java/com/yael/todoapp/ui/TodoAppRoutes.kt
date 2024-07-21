package com.yael.todoapp.ui

sealed class TodoAppRoutes(
  val route:String,
  val title:String
){

  data object Login:TodoAppRoutes(
    route = "app/auth/login",
    title = "Login"
  )

  data object SignUp:TodoAppRoutes(
    route = "app/auth/registro",
    title = "Registro"
  )

  data object Dashboard:TodoAppRoutes(
    route = "app/dashboard",
    title = "Dashboard"
  )

}