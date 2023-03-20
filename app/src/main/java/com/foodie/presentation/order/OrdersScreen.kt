package com.foodie.presentation.order

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
fun OrdersScreen(modifier: Modifier = Modifier, onBack: () -> Unit) {
    Scaffold(modifier = modifier, topBar = {
        FoodieTopAppBar(title = R.string.orders_label, onBack = onBack)
    }, content = { innerPadding ->
        OrdersEmptyContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )
    })
}

@Composable
fun OrdersContent(modifier: Modifier) {

}

@Composable
fun OrdersEmptyContent(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.padding(all = 20.dp)) {
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
                painter = painterResource(id = R.drawable.ic_empty_orders),
                contentDescription = "empty orders"
            )
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Text(text = stringResource(id = R.string.no_orders_yet_label), fontSize = 20.sp)
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(text = stringResource(id = R.string.no_orders_des_label), style = TextStyle(color = Color.Gray))
        }

        FoodieButton(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(button) {
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                }, text = stringResource(id = R.string.start_ordering_label)
        )
    }
}

@Preview
@Composable
fun OrdersScreenPreview() {
    FoodieTheme {
        OrdersScreen(modifier = Modifier.fillMaxSize()) {}
    }
}


