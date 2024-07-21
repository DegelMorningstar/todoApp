package com.yael.todoapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yael.todoapp.ui.dashboard.DashboardRoute
import com.yael.todoapp.ui.dashboard.DashboardScreen
import com.yael.todoapp.ui.login.LoginRoute
import com.yael.todoapp.ui.login.LoginScreen
import com.yael.todoapp.ui.login.LoginViewModel
import com.yael.todoapp.ui.singup.SignUpScreen

@Composable
fun TodoAppNavigation(
  modifier: Modifier = Modifier,
  navController: NavHostController,
  startDestination: String = TodoAppRoutes.Login.route
) {

  NavHost(
    modifier = modifier,
    navController = navController,
    startDestination = startDestination
  ){

    composable(route = TodoAppRoutes.Login.route){
      LoginRoute(navController = navController)
    }

    composable(route = TodoAppRoutes.SignUp.route){
      SignUpScreen(navController = navController)
    }

    composable(route = TodoAppRoutes.Dashboard.route){
      DashboardRoute(navController = navController)
    }

  }
}