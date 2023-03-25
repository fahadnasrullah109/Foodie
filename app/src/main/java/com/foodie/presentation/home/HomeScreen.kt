package com.foodie.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.foodie.R
import com.foodie.ui.theme.FoodieTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var tabIndex by remember {
        mutableStateOf(0)
    }
    val tabs = listOf(
        TabIcon(R.drawable.ic_home, R.drawable.ic_home_selected),
        TabIcon(R.drawable.ic_favourite, R.drawable.ic_favorite_selected),
        TabIcon(R.drawable.ic_history, R.drawable.ic_history_selected)
    )
    Column(modifier = modifier) {
        when (tabIndex) {
            0 -> HomeTab(modifier = modifier.weight(1f))
            1 -> FavouriteTab(modifier = modifier.weight(1f))
            2 -> HistoryTab(modifier = modifier.weight(1f))
        }
        TabRow(
            modifier = Modifier.padding(horizontal = 25.dp), selectedTabIndex = tabIndex,
            indicator = {}
        ) {
            tabs.forEachIndexed { index, icon ->
                val selected = tabIndex == index
                Tab(selected = selected, onClick = { tabIndex = index }, icon = {
                    Icon(
                        painter = painterResource(id = if (selected) icon.selectedIcon else icon.unselectedIcon),
                        tint = Color.Unspecified,
                        contentDescription = "Tab $index image"
                    )
                })
            }
        }
    }
}

@Composable
fun HomeTab(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.delicious_food_for_you),
            style = TextStyle(color = Color.Black, fontWeight = FontWeight.Black, fontSize = 35.sp)
        )
    }
}

@Composable
fun FavouriteTab(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Favourite",
            style = TextStyle(color = Color.Black, fontWeight = FontWeight.Black, fontSize = 35.sp)
        )
    }
}

@Composable
fun HistoryTab(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "History",
            style = TextStyle(color = Color.Black, fontWeight = FontWeight.Black, fontSize = 35.sp)
        )
    }
}

data class TabIcon(val unselectedIcon: Int, val selectedIcon: Int)

@Preview
@Composable
fun HomeScreenPreview() {
    FoodieTheme {
        HomeScreen(modifier = Modifier.fillMaxSize())
    }
}