package com.foodie.presentation.login

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.foodie.R
import com.foodie.components.FoodieButton
import com.foodie.ui.theme.FoodieTheme
import com.foodie.ui.theme.login_signup_bg

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier, onForgotPassword: () -> Unit, onLoginSuccess: () -> Unit
) {
    Surface(modifier = modifier, color = login_signup_bg) {
        ConstraintLayout(
            modifier = modifier.padding(all = 20.dp)
        ) {
            val (email, password, forgotPassword, loginBtn) = createRefs()
            var emailText by remember {
                mutableStateOf("")
            }
            var passwordText by remember {
                mutableStateOf("")
            }

            TextField(value = emailText,
                onValueChange = { emailText = it },
                label = { Text(text = stringResource(id = R.string.email_address_label)) },
                maxLines = 1,
                textStyle = TextStyle(color = Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(email) {
                        top.linkTo(parent.top, 16.dp)
                    }
                    .padding(20.dp))

            TextField(value = passwordText,
                onValueChange = { passwordText = it },
                label = { Text(text = stringResource(id = R.string.email_address_label)) },
                maxLines = 1,
                textStyle = TextStyle(color = Color.Black),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(password) {
                        top.linkTo(email.bottom, 10.dp)
                    }
                    .padding(20.dp))

            TextButton(onClick = onForgotPassword, modifier = Modifier.constrainAs(forgotPassword) {
                top.linkTo(password.bottom, 10.dp)
            }) {
                Text(
                    text = stringResource(id = R.string.forgot_password_label),
                    color = MaterialTheme.colorScheme.primary
                )
            }

            FoodieButton(modifier = Modifier
                .fillMaxWidth()
                .constrainAs(loginBtn) {
                    bottom.linkTo(parent.bottom, 20.dp)
                }
                .height(60.dp),
                text = stringResource(id = R.string.action_login),
                onClick = onLoginSuccess)

        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    FoodieTheme {
        LoginScreen(modifier = Modifier.fillMaxSize(), onForgotPassword = {}) {

        }
    }
}