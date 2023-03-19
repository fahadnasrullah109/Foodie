package com.foodie.presentation.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.foodie.R
import com.foodie.components.FoodieTopAppBar
import com.foodie.ui.theme.FoodieTheme
import com.foodie.ui.theme.login_signup_bg

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(modifier: Modifier = Modifier, onBack: () -> Unit) {
    Scaffold(modifier = modifier.background(color = login_signup_bg), topBar = {
        FoodieTopAppBar(title = R.string.cart_label, onBack = onBack)
    }, content = { innerPadding ->
        EmptyCart(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    })
}

@Composable
fun CartContent(modifier: Modifier = Modifier) {

}

@Composable
fun EmptyCart(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.empty_cart),
            style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 25.sp)
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Text(
            text = stringResource(id = R.string.add_items_to_cart),
            style = TextStyle(color = Color.Black, fontWeight = FontWeight.Light, fontSize = 15.sp)
        )
    }
}

@Preview
@Composable
fun CartScreenPreview() {
    FoodieTheme {
        CartScreen(modifier = Modifier.fillMaxSize()) {

        }
    }
}