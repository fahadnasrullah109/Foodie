package com.foodie.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.foodie.ui.theme.FoodieTheme

@Composable
fun FoodieButton(text : String, modifier : Modifier = Modifier, isEnabled : Boolean = true, onClick : () -> Unit = {}) {
    Button(modifier = modifier,  enabled = isEnabled, onClick = onClick) {
        Text(text = text, color = Color.White)
    }
}


@Composable
fun FoodieWhiteButton(text : String, modifier : Modifier = Modifier, onClick : () -> Unit = {}) {
    Button(
        modifier = modifier, onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = MaterialTheme.colorScheme.primary)
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun FoodieWhiteButtonPreview() {
    FoodieTheme {
        FoodieWhiteButton(text = "Get Started", modifier = Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
fun FoodieButtonPreview() {
    FoodieTheme {
        FoodieButton(text = "Get Started", modifier = Modifier.fillMaxWidth())
    }
}