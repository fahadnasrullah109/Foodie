package com.foodie.presentation.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.foodie.R
import com.foodie.components.FoodieButton
import com.foodie.components.FoodieTopAppBar
import com.foodie.ui.theme.FoodieTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(modifier: Modifier = Modifier, onBack: () -> Unit, startOrdering: () -> Unit) {
    Scaffold(modifier = modifier, topBar = {
        FoodieTopAppBar(title = R.string.history_label, onBack = onBack)
    }, content = { innerPadding ->
        HistoryEmptyContent(
            modifier = modifier
                .fillMaxSize(),
            innerPaddingValues = innerPadding,
            startOrdering = startOrdering
        )
    })
}

@Composable
fun HistoryContent(modifier: Modifier) {

}

@Composable
fun HistoryEmptyContent(modifier: Modifier = Modifier, innerPaddingValues: PaddingValues,startOrdering: () -> Unit) {
    ConstraintLayout(modifier = modifier.padding(innerPaddingValues).padding(all = 20.dp)) {
        val (column, button) = createRefs()
        Column(
            modifier = modifier.constrainAs(column) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(button.top, 20.dp)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(150.dp),
                painter = painterResource(id = R.drawable.ic_empty_history),
                contentDescription = "empty history"
            )
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Text(text = stringResource(id = R.string.no_history_yet_label), fontSize = 20.sp)
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(
                text = stringResource(id = R.string.no_orders_des_label),
                style = TextStyle(color = Color.Gray)
            )
        }

        FoodieButton(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(button) {
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                }, text = stringResource(id = R.string.start_ordering_label),
            onClick = startOrdering
        )
    }
}

@Preview
@Composable
fun HistoryScreenPreview() {
    FoodieTheme {
        HistoryScreen(modifier = Modifier.fillMaxSize(), onBack = {}) {}
    }
}