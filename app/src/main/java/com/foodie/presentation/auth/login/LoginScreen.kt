package com.foodie.presentation.auth.login

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.foodie.R
import com.foodie.components.FoodieButton
import com.foodie.domain.usecases.EmailValidationUseCase
import com.foodie.domain.usecases.PasswordValidationUseCase
import com.foodie.ui.theme.FoodieTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    onForgotPassword: () -> Unit,
    onLoginSuccess: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    if (uiState.loginSuccess) {
        LaunchedEffect(Unit) {
            onLoginSuccess.invoke()
        }
    }

    ConstraintLayout(
        modifier = modifier
    ) {
        val (email, emailError, password, passwordError, forgotPassword, loginBtn, progress) = createRefs()

        TextField(value = uiState.email,
            onValueChange = { viewModel.onEvent(LoginEvents.EmailChanged(it)) },
            label = { Text(text = stringResource(id = R.string.email_address_label)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(email) {
                    top.linkTo(parent.top, 16.dp)
                }
                .padding(20.dp),
            isError = uiState.emailError != null)

        uiState.emailError?.let { error ->
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(emailError) {
                        top.linkTo(email.bottom)
                        start.linkTo(email.start, 20.dp)
                    },
                text = stringResource(id = error),
                style = TextStyle(color = MaterialTheme.colorScheme.error, fontSize = 10.sp)
            )
        }

        TextField(value = uiState.password,
            onValueChange = { viewModel.onEvent(LoginEvents.PasswordChanged(it)) },
            label = { Text(text = stringResource(id = R.string.password_label)) },
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password, imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(password) {
                    top.linkTo(email.bottom, 10.dp)
                }
                .padding(20.dp),
            isError = uiState.passwordError != null)

        uiState.passwordError?.let { error ->
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(passwordError) {
                        top.linkTo(password.bottom)
                        start.linkTo(password.start, 20.dp)
                    },
                text = stringResource(id = error),
                style = TextStyle(color = MaterialTheme.colorScheme.error, fontSize = 10.sp)
            )
        }

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
            text = stringResource(id = R.string.action_login),
            onClick = { viewModel.onEvent(LoginEvents.LoginClicked) })

        if (uiState.isLoading) {
            CircularProgressIndicator(
                color = Color.White,
                modifier = Modifier.constrainAs(progress) {
                    bottom.linkTo(loginBtn.bottom)
                    start.linkTo(loginBtn.start)
                    end.linkTo(loginBtn.end)
                    top.linkTo(loginBtn.top)
                })
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    FoodieTheme {
        LoginScreen(modifier = Modifier.fillMaxSize(),
            viewModel = LoginViewModel(EmailValidationUseCase(), PasswordValidationUseCase()),
            onForgotPassword = {}) {}
    }
}