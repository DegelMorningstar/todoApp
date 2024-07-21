package com.yael.todoapp.ui.dashboard

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.yael.todoapp.ui.components.LoadingComponent

@Composable
fun DashboardRoute(
    navController: NavHostController,
    dashboardViewModel: DashboardViewModel = hiltViewModel()
) {

    val isLoading by dashboardViewModel.isLoading.observeAsState(initial = false)
    val taskList by dashboardViewModel.taskList.observeAsState(initial = emptyList())

    LaunchedEffect(key1 = true) {
        dashboardViewModel.validateSession(navController)
    }

    DashboardScreen(navController = navController, taskList = taskList)

    if(isLoading) LoadingComponent()
}