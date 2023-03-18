package com.foodie.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.foodie.R
import com.foodie.presentation.auth.login.LoginScreen
import com.foodie.presentation.auth.register.RegisterScreen
import com.foodie.ui.theme.FoodieTheme
import com.foodie.ui.theme.login_signup_bg

@Composable
fun AuthScreen(
    modifier: Modifier = Modifier,
    onForgotPassword: () -> Unit,
    onLoginSuccess: () -> Unit,
    onRegisterSuccess: () -> Unit
) {
    var tabIndex by remember {
        mutableStateOf(0)
    }

    val tabTitles = listOf("Login", "Register")
    Surface(modifier = modifier, color = login_signup_bg) {
        Column(modifier = Modifier.fillMaxSize()) {
            ConstraintLayout(
                modifier = modifier
                    .background(
                        color = Color.White, shape = RoundedCornerShape(
                            topStart = 0.dp, topEnd = 0.dp, bottomEnd = 25.dp, bottomStart = 25.dp
                        )
                    )
                    .weight(0.4f)
            ) {
                val (icon, tabs) = createRefs()
                Image(
                    modifier = Modifier.constrainAs(icon) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                    painter = painterResource(id = R.drawable.ic_chef_hat),
                    contentDescription = "chef hat"
                )

                TabRow(modifier = Modifier
                    .constrainAs(tabs) {
                        bottom.linkTo(parent.bottom)
                    }
                    .padding(horizontal = 25.dp), selectedTabIndex = tabIndex) {
                    tabTitles.forEachIndexed { index, title ->
                        Tab(selected = tabIndex == index, onClick = { tabIndex = index }, text = {
                            Text(
                                text = title,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                style = TextStyle(
                                    color = Color.Black, fontWeight = FontWeight.Black
                                )
                            )
                        })
                    }
                }
            }
            when (tabIndex) {
                0 -> LoginScreen(
                    modifier = modifier.weight(1f),
                    onForgotPassword = onForgotPassword,
                    onLoginSuccess = onLoginSuccess
                )
                else -> RegisterScreen(
                    modifier = modifier.weight(1f), onRegisterSuccess = onRegisterSuccess
                )
            }
        }
    }
}

@Preview
@Composable
fun AuthScreenPreview() {
    FoodieTheme {
        AuthScreen(modifier = Modifier.fillMaxWidth(),
            onForgotPassword = {},
            onLoginSuccess = {},
            onRegisterSuccess = {})
    }
}