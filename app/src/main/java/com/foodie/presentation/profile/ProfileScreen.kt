package com.foodie.presentation.profile

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.foodie.R
import com.foodie.components.FoodieTopAppBar
import com.foodie.ui.theme.FoodieTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(modifier: Modifier = Modifier, onBack: () -> Unit) {
    Scaffold(modifier = modifier, topBar = {
        FoodieTopAppBar(title = R.string.profile_label, onBack = onBack)
    }, content = { innerPadding ->
        ProfileContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    })
}

@Composable
fun ProfileContent(modifier: Modifier) {

}

@Preview
@Composable
fun ProfileScreenPreview() {
    FoodieTheme {
        ProfileScreen(modifier = Modifier.fillMaxSize()) {}
    }
}


