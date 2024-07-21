package com.yael.todoapp.ui.singup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yael.todoapp.R
import com.yael.todoapp.ui.TodoAppRoutes
import com.yael.todoapp.ui.theme.TodoAppTheme

@Composable
fun SignUpScreen(
  modifier: Modifier = Modifier,
  navController: NavHostController
) {
  val scroll = rememberScrollState()
  Column(
    modifier = modifier
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.surface)
      .verticalScroll(scroll),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      text = "Registrate",
      fontSize = 26.sp,
      fontWeight = FontWeight.Normal,
      color = MaterialTheme.colorScheme.primary,
      modifier = modifier.padding(vertical = 24.dp)
    )
    Column(modifier = modifier.padding(horizontal = 36.dp)) {
      SignUpForm(navController = navController)
    }
  }
}

@Composable
private fun SignUpForm(
  modifier: Modifier = Modifier,
  navController: NavHostController
) {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier
      .clip(RoundedCornerShape(12.dp))
      .background(MaterialTheme.colorScheme.background)
      .padding(vertical = 12.dp, horizontal = 16.dp)
  ) {
    Text(text = "Con tu cuenta puedes acceder a tus tareas desde cualquier dispositivo.", textAlign = TextAlign.Center, fontSize = 14.sp, modifier = modifier.padding(vertical = 24.dp))
    OutlinedTextField(
      value = "",
      onValueChange = {},
      placeholder = {
        Text(text = "Ingresa tu nombre")
      },
      modifier = modifier
        .padding(bottom = 24.dp)
        .fillMaxWidth()
    )
    OutlinedTextField(
      value = "",
      onValueChange = {},
      placeholder = {
        Text(text = "Ingresa tus apellidos")
      },
      modifier = modifier
        .padding(bottom = 24.dp)
        .fillMaxWidth()
    )
    OutlinedTextField(
      value = "",
      onValueChange = {},
      placeholder = {
        Text(text = "Ingresa tu correo electronico")
      },
      modifier = modifier
        .padding(bottom = 24.dp)
        .fillMaxWidth()
    )
    OutlinedTextField(
      value = "",
      onValueChange = {},
      placeholder = {
        Text(text = "Ingresa tu contraseña")
      },
      modifier = modifier
        .padding(bottom = 24.dp)
        .fillMaxWidth()
    )
    OutlinedTextField(
      value = "",
      onValueChange = {},
      placeholder = {
        Text(text = "Confirma tu contraseña")
      },
      modifier = modifier
        .padding(bottom = 24.dp)
        .fillMaxWidth()
    )
    Button(onClick = { /*TODO*/ }, modifier = modifier
      .fillMaxWidth()
      .padding(bottom = 24.dp)) {
      Text(text = "Registrarse")
    }
    Text(
      text = "¿Ya tienes una cuenta? Inicia sesión",
      fontSize = 12.sp,
      color = MaterialTheme.colorScheme.secondary,
      modifier = modifier.padding(bottom = 12.dp).clickable {
        navController.navigate(TodoAppRoutes.Login.route){
          popUpTo(TodoAppRoutes.Login.route){
            inclusive = true
          }
        }
      },
    )
  }
}

@Preview
@Composable
private fun PreviewSignUpScreen() {
  val navController = rememberNavController()
  TodoAppTheme {
    SignUpScreen(navController = navController)
  }
}