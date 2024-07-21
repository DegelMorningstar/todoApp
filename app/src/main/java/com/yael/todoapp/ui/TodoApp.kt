package com.yael.todoapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.yael.todoapp.ui.login.LoginViewModel

@Composable
fun TodoApp(
  modifier: Modifier = Modifier
) {

  val navController = rememberNavController()

  TodoAppNavigation(modifier = modifier,navController = navController)

}