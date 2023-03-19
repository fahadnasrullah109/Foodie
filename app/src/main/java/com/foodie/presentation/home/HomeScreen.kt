package com.foodie.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.foodie.R
import com.foodie.ui.theme.FoodieTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.delicious_food_for_you),
            style = TextStyle(color = Color.Black, fontWeight = FontWeight.Black, fontSize = 35.sp)
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    FoodieTheme {
        HomeScreen(modifier = Modifier.fillMaxSize())
    }
}