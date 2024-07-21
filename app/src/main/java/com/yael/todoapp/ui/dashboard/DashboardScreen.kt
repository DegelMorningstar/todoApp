package com.yael.todoapp.ui.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yael.todoapp.R
import com.yael.todoapp.domain.models.Task
import com.yael.todoapp.ui.theme.TodoAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    taskList: List<Task>
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "INICIO",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_people_24),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
      floatingActionButton = {
        FloatingActionButton(onClick = { /*TODO*/ }) {
          Text(text = "Crear tarea")
        }
      }
    ) {
        Surface(
            modifier = modifier.padding(it),
            color = MaterialTheme.colorScheme.surface
        ) {
            Column {
              Text(
                text = "Bienvenido",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(horizontal = 16.dp, vertical = 24.dp)
              )
              if (taskList.isEmpty()) {
                Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                  Text(text = "Aun no tienes tareas")
                }
              } else {
                LazyColumn(
                  modifier = modifier.fillMaxSize()
                ) {
                  items(taskList) {
                    TaskCard(task = it)
                  }
                }
              }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskCard(
  modifier: Modifier = Modifier,
  task:Task
) {
  Card(
    onClick = { /*TODO*/ },
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp, vertical = 8.dp),
    colors = CardDefaults.cardColors(
      containerColor = Color.White
    ),
    elevation = CardDefaults.elevatedCardElevation(
      defaultElevation = 12.dp
    )
  ) {
    Column(
      modifier = modifier.padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
      Text(text = task.descripcion, fontWeight = FontWeight.Bold)
      Text(text = "Prioridad: ${task.prioridad}")
    }
  }
}

@Preview
@Composable
private fun PreviewDashboardScreen() {
    val navController = rememberNavController()
    val list = listOf(
        Task("tarea uno", "", 0, "ALTA", true),
        Task("tarea dos", "", 0, "ALTA", true),
        Task("tarea tres", "", 0, "ALTA", true),
        Task("tarea cuatro", "", 0, "ALTA", true)
    )
    TodoAppTheme {
        DashboardScreen(
            navController = navController,
            taskList = list
        )
    }
}