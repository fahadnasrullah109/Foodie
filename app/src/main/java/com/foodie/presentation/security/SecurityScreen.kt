package com.foodie.presentation.security

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.foodie.R
import com.foodie.components.FoodieTopAppBar
import com.foodie.ui.theme.FoodieTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecurityScreen(modifier: Modifier = Modifier, onBack: () -> Unit) {
    Scaffold(modifier = modifier, topBar = {
        FoodieTopAppBar(title = R.string.security_label, onBack = onBack)
    }, content = { innerPadding ->
        SecurityContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    })
}

@Composable
fun SecurityContent(modifier: Modifier) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        Text(
            modifier = modifier.padding(horizontal = 20.dp),
            text = stringResource(id = R.string.ipsum_text)
        )
    }
}

@Preview
@Composable
fun SecurityScreenPreview() {
    FoodieTheme {
        SecurityScreen(modifier = Modifier.fillMaxSize()) {}
    }
}


