package com.foodie.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.foodie.R
import com.foodie.ui.theme.FoodieTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodieTopAppBar(title: Int, onBack: () -> Unit) {
    CenterAlignedTopAppBar(title = {
        Text(text = stringResource(id = title))
    }, navigationIcon = {
        IconButton(onClick = onBack) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back), contentDescription = "back icon"
            )
        }
    })
}

@Preview
@Composable
fun FoodieTopAppBarPreview() {
    FoodieTheme {
        FoodieTopAppBar(title = R.string.action_login) {}
    }
}