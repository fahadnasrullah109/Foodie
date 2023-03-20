package com.foodie.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.foodie.R
import com.foodie.ui.theme.FoodieTheme
import com.foodie.ui.theme.login_signup_bg

@Composable
fun FoodieNoInternet(modifier: Modifier = Modifier, onTryAgain: () -> Unit) {
    Surface(modifier = modifier, color = login_signup_bg) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_no_internet),
                contentDescription = "No internet"
            )
            Spacer(modifier = Modifier.padding(vertical = 20.dp))
            Text(text = stringResource(id = R.string.no_internet_label), fontSize = 25.sp)
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            Text(
                text = stringResource(id = R.string.no_internet_desc_label),
                style = TextStyle(color = Color.Gray)
            )
            Spacer(modifier = Modifier.padding(vertical = 20.dp))
            FoodieButton(text = stringResource(id = R.string.try_again), onClick = onTryAgain)
        }
    }
}

@Preview
@Composable
fun FoodieNoInternetPreview() {
    FoodieTheme {
        FoodieNoInternet(modifier = Modifier.fillMaxSize()) {}
    }
}