package com.yael.todoapp.ui.login

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.yael.todoapp.ui.components.GeneralAlert
import com.yael.todoapp.ui.components.LoadingComponent

@Composable
fun LoginRoute(
  loginViewModel: LoginViewModel = hiltViewModel(),
  navController: NavHostController
) {

  val isLoading by loginViewModel.isLoading.observeAsState(initial = false)
  val showError by loginViewModel.showError.observeAsState(initial = false)

  Box {
    LoginScreen(
      navController = navController,
      onClickLogin = { email,password ->
        loginViewModel.login(email,password,navController)
      }
    )

    if(showError){
      GeneralAlert(
        onDismissRequest = { loginViewModel.hideError() },
        onConfirmation = { loginViewModel.hideError() },
        dialogTitle = "Algo no salio bien...",
        dialogText = "Usuario y/o contraseña incorrectos"
      )
    }

    if(isLoading) LoadingComponent()
  }

}