package com.foodie.presentation.auth.register

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
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.foodie.R
import com.foodie.components.FoodieButton
import com.foodie.ui.theme.FoodieTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel = hiltViewModel(),
    onRegisterSuccess: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    if (uiState.registerSuccess) {
        LaunchedEffect(Unit) {
            onRegisterSuccess.invoke()
        }
    }
    ConstraintLayout(
        modifier = modifier
    ) {
        val (username, usernameError, email, emailError, password, passwordError, registerBtn, progress) = createRefs()

        TextField(value = uiState.username,
            onValueChange = { viewModel.onEvent(RegisterEvents.UsernameChanged(it)) },
            label = { Text(text = stringResource(id = R.string.username_label)) },
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(username) {
                    top.linkTo(parent.top, 16.dp)
                }
                .padding(20.dp),
            isError = uiState.usernameError != null)

        uiState.usernameError?.let { error ->
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(usernameError) {
                        top.linkTo(username.bottom)
                        start.linkTo(username.start, 20.dp)
                    },
                text = stringResource(id = error),
                style = TextStyle(color = MaterialTheme.colorScheme.error, fontSize = 10.sp)
            )
        }

        TextField(value = uiState.email,
            onValueChange = { viewModel.onEvent(RegisterEvents.EmailChanged(it)) },
            label = { Text(text = stringResource(id = R.string.email_address_label)) },
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(email) {
                    top.linkTo(username.bottom, 5.dp)
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
            onValueChange = { viewModel.onEvent(RegisterEvents.PasswordChanged(it)) },
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
                    top.linkTo(email.bottom, 5.dp)
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


        FoodieButton(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(registerBtn) {
                bottom.linkTo(parent.bottom, 20.dp)
                start.linkTo(parent.start, 20.dp)
                end.linkTo(parent.end, 20.dp)
                width = Dimension.fillToConstraints
            }
            .height(60.dp),
            text = stringResource(id = R.string.action_register),
            onClick = { viewModel.onEvent(RegisterEvents.RegisterClicked) })

        if (uiState.isLoading) {
            CircularProgressIndicator(
                color = Color.White,
                modifier = Modifier.constrainAs(progress) {
                    bottom.linkTo(registerBtn.bottom)
                    start.linkTo(registerBtn.start)
                    end.linkTo(registerBtn.end)
                    top.linkTo(registerBtn.top)
                })
        }

    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {
    FoodieTheme {
        RegisterScreen(modifier = Modifier.fillMaxSize(), viewModel = hiltViewModel()) {}
    }
}