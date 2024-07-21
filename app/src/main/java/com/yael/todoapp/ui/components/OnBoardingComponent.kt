package com.yael.todoapp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yael.todoapp.R
import com.yael.todoapp.ui.theme.TodoAppTheme
import com.yael.todoapp.ui.theme.primaryColor

@Composable
fun OnBoardingComponent(
  modifier: Modifier = Modifier,
  visible:Boolean,
  onClick: () -> Unit
) {
  AnimatedVisibility(
    visible = visible,
    enter = slideInHorizontally(),
    exit = slideOutHorizontally()
  ) {
    Column(
      modifier = modifier
        .fillMaxSize()
        .background(Color.White),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.SpaceAround
    ) {
      Text(text = stringResource(R.string.title_onboarding), fontSize = 26.sp, color = primaryColor, fontWeight = FontWeight.Medium)
      Image(painter = painterResource(id = R.drawable.onboarding), contentDescription = null, modifier = modifier.width(150.dp))
      Text(text = stringResource(R.string.description_onboarding), fontSize = 14.sp)
      Button(onClick = onClick, modifier = modifier.width(270.dp)) {
        Text(text = stringResource(R.string.btn_comenzar))
      }
    }
  }
}

@Preview
@Composable
fun OnBoardingComponentPreview() {
  TodoAppTheme {
    OnBoardingComponent(visible = true, onClick = {})
  }
}