package com.yael.todoapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.yael.todoapp.data.local.PreferencesManager
import com.yael.todoapp.data.local.PreferencesManager.Companion.keyFirstTime
import com.yael.todoapp.ui.TodoApp
import com.yael.todoapp.ui.components.OnBoardingComponent
import com.yael.todoapp.ui.theme.TodoAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  @Inject lateinit var preferences:PreferencesManager

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    preferences.saveData(PreferencesManager.keySession,"")
    installSplashScreen()
    setContent {
      TodoAppTheme {
        /** Lienzo de la app */
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          /** Validacion para mostrar el onboarding */
          var firstTime by remember {
            mutableStateOf(preferences.getData(keyFirstTime,true))
          }
          /** Navegacion */
          TodoApp()

          /** componente de onboarding */
          OnBoardingComponent(visible = firstTime) {
            preferences.saveData(keyFirstTime,false)
            firstTime = false
          }

        }
      }
    }
  }

  override fun onResume() {
    super.onResume()
    Log.d("Main Activity","On resume")
  }

  override fun onPause() {
    super.onPause()
    Log.d("Main Activity","On pause")
  }

  override fun onStop() {
    super.onStop()
    Log.d("Main Activity","On stop")
  }

  override fun onDestroy() {
    super.onDestroy()
    Log.d("Main Activity","Saliendo de la App y limpiando la sesion")
  }



}