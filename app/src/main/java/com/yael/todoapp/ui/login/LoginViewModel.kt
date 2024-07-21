package com.yael.todoapp.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.yael.todoapp.data.local.PreferencesManager
import com.yael.todoapp.data.remote.AuthorizationInterceptor
import com.yael.todoapp.domain.listeners.LoginListener
import com.yael.todoapp.domain.useCase.LoginUseCase
import com.yael.todoapp.ui.TodoAppRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
  private val loginUseCase: LoginUseCase,
  private val preferencesManager: PreferencesManager
) :ViewModel() {

  private val _isLoading = MutableLiveData<Boolean>(false)
  val isLoading:LiveData<Boolean> = _isLoading

  private val _showError = MutableLiveData<Boolean>(false)
  val showError:LiveData<Boolean> = _showError

  private val tag = LoginViewModel::class.java.simpleName

  private fun showLoading(){
    _isLoading.value = true
  }

  private fun hideLoading(){
    _isLoading.value = false
  }

  private fun showError(){
    _showError.value = true
  }

  fun hideError(){
    _showError.value = false
  }

  fun login(email: String, password: String, navController: NavHostController){
    showLoading()

    loginUseCase.invokeLogin(
      email = email,
      password = password,
      object : LoginListener {
        override fun onLoginSuccess(token: String?) {
          if(!token.isNullOrEmpty()){
            hideLoading()
            Log.d(tag,"Login exitoso: $token")
            //1.- Almanecar el jwt en el preferences Manager
            preferencesManager.saveData(key = PreferencesManager.keySession,token)
            //2.- Redireccionar a dashboard
            navController.navigate(TodoAppRoutes.Dashboard.route){
              popUpTo(TodoAppRoutes.Dashboard.route){
                inclusive = true
              }
            }
          }else{
            Log.d(tag,"El login fallo")
            hideLoading()
            showError()
          }
        }

        override fun onLoginError() {
          hideLoading()
          showError()
          Log.d(tag,"El login fallo")
        }

      }
    )
  }

}