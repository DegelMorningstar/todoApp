package com.yael.todoapp.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yael.todoapp.R
import com.yael.todoapp.ui.TodoAppRoutes
import com.yael.todoapp.ui.theme.TodoAppTheme
import com.yael.todoapp.util.clearFormat
import com.yael.todoapp.util.isValidEmail
import com.yael.todoapp.util.isValidPassword

@Composable
fun LoginScreen(
  modifier: Modifier = Modifier,
  navController: NavHostController,
  onClickLogin: (email:String,password:String) -> Unit
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
      text = "¡Hola de nuevo!",
      fontSize = 26.sp,
      fontWeight = FontWeight.Normal,
      color = MaterialTheme.colorScheme.primary,
      modifier = modifier.padding(vertical = 24.dp)
    )
    Column(modifier = modifier.padding(horizontal = 36.dp)) {
      LoginForm(navController = navController, onClickLogin = onClickLogin)
    }
  }
}

@Composable
private fun LoginForm(
  modifier: Modifier = Modifier,
  navController: NavHostController,
  onClickLogin: (email:String,password:String) -> Unit
) {

  var email by remember { mutableStateOf("") }
  var emailError by remember { mutableStateOf("") }
  var password by remember { mutableStateOf("") }
  var passwordError by remember { mutableStateOf("") }

  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier
      .clip(RoundedCornerShape(12.dp))
      .background(MaterialTheme.colorScheme.background)
      .padding(vertical = 12.dp, horizontal = 16.dp)
  ) {
    Image(
      painter = painterResource(id = R.drawable.login_resource),
      contentDescription = null,
      modifier = modifier.size(130.dp)
    )
    Text(text = "Ingresa para acceder a tus tareas", fontSize = 14.sp, modifier = modifier.padding(vertical = 24.dp))
    OutlinedTextField(
      value = email,
      onValueChange = {
        email = it
        emailError = if(email.isEmpty()) "Ingresa un correo" else ""
      },
      isError = emailError.isNotEmpty(),
      placeholder = {
        Text(text = "Ingresa tu correo electronico")
      },
      supportingText = {
       if(emailError.isNotEmpty()){
         Text(text = emailError)
       }else{
         null
       }
      },
      modifier = modifier
        .padding(bottom = 24.dp)
        .fillMaxWidth()
    )
    OutlinedTextField(
      value = password,
      onValueChange = {
        password = it
        passwordError = if(password.isEmpty()) "Ingresa una contraseña" else ""
      },
      isError = passwordError.isNotEmpty(),
      placeholder = {
        Text(text = "Ingresa tu contraseña")
      },
      supportingText = {
        if(passwordError.isNotEmpty()){
          Text(text = passwordError)
        }else{
          null
        }
      },
      modifier = modifier
        .padding(bottom = 24.dp)
        .fillMaxWidth(),
      visualTransformation = PasswordVisualTransformation()
    )
    Button(onClick = {
      email.clearFormat()
      password.clearFormat()
      when {
        email.isEmpty() && password.isEmpty() -> {
          passwordError = "No dejes los campos vacios"
          emailError = "No dejes los campos vacios"
        }
        !email.isValidEmail() -> {
          emailError = "Formato incorrecto"
        }
        !password.isValidPassword() -> {
          passwordError = "Contraseña muy corta"
        }
        else -> {
          onClickLogin(email,password)
        }
      }
    }, modifier = modifier
      .fillMaxWidth()
      .padding(bottom = 24.dp)) {
      Text(text = "Iniciar sesion")
    }
    Text(
      text = "¿No tienes una cuenta? Registrate",
      fontSize = 12.sp,
      color = MaterialTheme.colorScheme.secondary,
      modifier = modifier
        .padding(bottom = 12.dp)
        .clickable {
          navController.navigate(TodoAppRoutes.SignUp.route)
        },
    )
  }
}


@Preview
@Composable
private fun PreviewLoginScreen() {
  val navController = rememberNavController()
  TodoAppTheme {
    LoginScreen(navController = navController, onClickLogin = { _,_ -> })
  }
}