package com.yael.todoapp.ui.dashboard

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.yael.todoapp.domain.listeners.GetAllTaskListener
import com.yael.todoapp.domain.listeners.SessionListener
import com.yael.todoapp.domain.models.Task
import com.yael.todoapp.domain.useCase.DashboardUseCase
import com.yael.todoapp.ui.TodoAppRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val dashboardUseCase: DashboardUseCase
): ViewModel() {

    private val tag = DashboardViewModel::class.java.simpleName

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _taskList = MutableLiveData<List<Task>>(emptyList())
    val taskList:LiveData<List<Task>> = _taskList

    private fun showLoading(){
        _isLoading.value = true
    }

    private fun hideLoading(){
        _isLoading.value = false
    }

    fun validateSession(navController: NavHostController){
        dashboardUseCase.invokeValidateSession(
            object : SessionListener {
                override fun onValidSession() {
                    Log.d(tag,"sesion valida")
                    getAllTasks()
                }

                override fun onSessionExpired() {
                    Log.d(tag,"sesion no valida")
                    Toast.makeText(context,"Su sesion ha expirado",Toast.LENGTH_LONG).show()
                    navController.navigate(TodoAppRoutes.Login.route){
                        popUpTo(TodoAppRoutes.Login.route){
                            inclusive = true
                        }
                    }
                }

            }
        )
    }

    private fun getAllTasks(){
        showLoading()
        dashboardUseCase.invokeGetAllTasks(
            object : GetAllTaskListener {
                override fun onGetAllTaskSuccess(taskList: List<Task>) {
                    hideLoading()
                    _taskList.value = taskList
                }

                override fun onError(msgE: String) {
                    hideLoading()
                    Toast.makeText(context,msgE,Toast.LENGTH_LONG).show()
                }

            }
        )
    }

}