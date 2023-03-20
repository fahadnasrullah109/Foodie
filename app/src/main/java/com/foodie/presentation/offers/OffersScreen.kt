package com.foodie.presentation.offers

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
fun OffersScreen(modifier: Modifier = Modifier, onBack: () -> Unit) {
    Scaffold(modifier = modifier, topBar = {
        FoodieTopAppBar(title = R.string.offers_and_promo_label, onBack = onBack)
    }, content = { innerPadding ->
        OffersContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    })
}

@Composable
fun OffersContent(modifier: Modifier) {

}

@Preview
@Composable
fun OffersScreenPreview() {
    FoodieTheme {
        OffersScreen(modifier = Modifier.fillMaxSize()) {}
    }
}


