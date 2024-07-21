package com.yael.todoapp.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yael.todoapp.ui.theme.TodoAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralAlert(
  modifier: Modifier = Modifier,
  onDismissRequest: () -> Unit,
  onConfirmation: () -> Unit,
  dialogTitle: String,
  dialogText: String,
) {
  AlertDialog(
    title = {
      Text(text = dialogTitle)
    },
    text = {
      Text(text = dialogText)
    },
    onDismissRequest = { onDismissRequest() },
    confirmButton = {
      TextButton(
        onClick = {
          onConfirmation()
        }
      ) {
        Text("Aceptar")
      }
    }
  )
}

@Preview
@Composable
private fun PreviewGeneralAlert() {
  TodoAppTheme {
    Surface(
      modifier = Modifier.fillMaxSize()
    ) {
      GeneralAlert(
        dialogTitle = "Alerta",
        dialogText = "Inicio de sesion",
        onConfirmation = {},
        onDismissRequest = {}
      )
    }
  }
}