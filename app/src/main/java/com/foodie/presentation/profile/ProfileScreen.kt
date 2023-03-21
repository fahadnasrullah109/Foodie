package com.foodie.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
fun ProfileScreen(modifier: Modifier = Modifier, onBack: () -> Unit, onProfileUpdate: () -> Unit) {
    Scaffold(modifier = modifier, topBar = {
        FoodieTopAppBar(title = R.string.profile_label, onBack = onBack)
    }, content = { innerPadding ->
        ProfileContent(
            modifier = Modifier.fillMaxSize(),
            innerPaddingValues = innerPadding,
            onProfileUpdate = onProfileUpdate
        )
    })
}

@Composable
fun ProfileContent(
    modifier: Modifier,
    innerPaddingValues: PaddingValues,
    onProfileUpdate: () -> Unit
) {
    ConstraintLayout(
        modifier = modifier
            .padding(innerPaddingValues)
            .padding(all = 20.dp)
    ) {
        val (profileColumn, updateButton) = createRefs()
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .constrainAs(profileColumn) {
                    top.linkTo(parent.top)
                    bottom.linkTo(updateButton.top, 20.dp)
                    height = Dimension.fillToConstraints
                }) {
            Text(
                text = stringResource(id = R.string.information_label),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
            )
            Spacer(modifier = Modifier.padding(top = 5.dp))
            InformationItem()
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Text(
                text = stringResource(id = R.string.payment_method_label),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
            )
            Spacer(modifier = Modifier.padding(top = 5.dp))
            PaymentItem()
        }
        FoodieButton(
            text = stringResource(id = R.string.action_update),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(updateButton) {
                    bottom.linkTo(parent.bottom)
                }, onClick = onProfileUpdate
        )
    }
}

@Composable
fun InformationItem() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 20.dp)
        ) {
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = "person icon",
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(50.dp)
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(id = R.string.profile_title), style = TextStyle(
                        fontSize = 18.sp, color = Color.Black, fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.padding(top = 5.dp))
                Text(
                    text = stringResource(id = R.string.email_placeholder),
                    style = TextStyle(color = Color.Gray)
                )
                Spacer(modifier = Modifier.padding(top = 5.dp))
                Text(
                    text = stringResource(id = R.string.profile_address_placeholder),
                    style = TextStyle(color = Color.Gray)
                )
            }
        }
    }
}

@Composable
fun PaymentItem() {
    Card(modifier = Modifier.fillMaxWidth()) {
        val paymentOptions = listOf(PaymentItem.Card, PaymentItem.Bank, PaymentItem.Paypal)
        val (selectedOption, onOptionSelected) = remember { mutableStateOf(paymentOptions[0]) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 20.dp)
        ) {
            paymentOptions.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(selected = item == selectedOption, onClick = {
                            onOptionSelected(item)
                        }), verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = (item == selectedOption),
                        modifier = Modifier.padding(all = 10.dp),
                        onClick = {
                            onOptionSelected(item)
                        })
                    Image(
                        painter = painterResource(id = item.icon),
                        contentDescription = "${item.title} icon"
                    )
                    Text(
                        text = stringResource(id = item.title),
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    FoodieTheme {
        ProfileScreen(modifier = Modifier.fillMaxSize(), onBack = {}) {}
    }
}


