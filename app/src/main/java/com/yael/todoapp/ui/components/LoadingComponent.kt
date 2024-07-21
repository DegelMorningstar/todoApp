package com.yael.todoapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.yael.todoapp.ui.theme.TodoAppTheme

@Composable
fun LoadingComponent(
  modifier: Modifier = Modifier
) {
  Dialog(
    onDismissRequest = { },
    properties = DialogProperties(
      dismissOnBackPress = false,
      dismissOnClickOutside = false,
      usePlatformDefaultWidth = false
    )
  ) {

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center){
      Column {
        //CircularProgressIndicator()
        Text(text = "Cargando . . .", color = Color.White)
      }
    }

  }
}

@Preview
@Composable
private fun PreviewLoadingComponent() {
  TodoAppTheme {
    Surface(
      modifier = Modifier.fillMaxSize()
    ) {
      LoadingComponent()
    }
  }
}