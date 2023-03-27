package com.foodie.presentation.auth.login

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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.foodie.R
import com.foodie.components.FoodieButton
import com.foodie.ui.theme.FoodieTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel,
    onForgotPassword: () -> Unit,
    onLoginSuccess: () -> Unit
) {
    ConstraintLayout(
        modifier = modifier
    ) {
        val (email, password, forgotPassword, loginBtn) = createRefs()

        val emailText by viewModel.emailText.collectAsState()
        val passwordText by viewModel.passwordText.collectAsState()
        val isFormValid by viewModel.isFormValid.collectAsState()

        TextField(value = emailText,
            onValueChange = { viewModel.setEmail(it) },
            label = { Text(text = stringResource(id = R.string.email_address_label)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
            ),
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(email) {
                    top.linkTo(parent.top, 16.dp)
                }
                .padding(20.dp),
            isError = emailText.isNotEmpty() && !emailText.isValidEmail())

        TextField(value = passwordText,
            onValueChange = { viewModel.setPassword(it) },
            label = { Text(text = stringResource(id = R.string.password_label)) },
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(password) {
                    top.linkTo(email.bottom, 10.dp)
                }
                .padding(20.dp),
            isError = passwordText.isNotEmpty() && !passwordText.isValidPassword())

        TextButton(onClick = onForgotPassword, modifier = Modifier.constrainAs(forgotPassword) {
            top.linkTo(password.bottom, 5.dp)
            start.linkTo(parent.start, 10.dp)
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
                start.linkTo(parent.start, 20.dp)
                end.linkTo(parent.end, 20.dp)
                width = Dimension.fillToConstraints
            }
            .height(60.dp),
            isEnabled = isFormValid,
            text = stringResource(id = R.string.action_login),
            onClick = onLoginSuccess)
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    FoodieTheme {
        LoginScreen(
            modifier = Modifier.fillMaxSize(),
            viewModel = LoginViewModel(),
            onForgotPassword = {}) {}
    }
}