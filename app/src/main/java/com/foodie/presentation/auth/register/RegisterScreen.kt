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
fun RegisterScreen(
    modifier: Modifier = Modifier, viewModel: RegisterViewModel, onRegisterSuccess: () -> Unit
) {
    ConstraintLayout(
        modifier = modifier
    ) {
        val (username, email, password, registerBtn) = createRefs()
        TextField(value = viewModel.usernameText,
            onValueChange = { viewModel.usernameText = it },
            label = { Text(text = stringResource(id = R.string.username_label)) },
            maxLines = 1,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(username) {
                    top.linkTo(parent.top, 16.dp)
                }
                .padding(20.dp))

        TextField(value = viewModel.emailText,
            onValueChange = { viewModel.emailText = it },
            label = { Text(text = stringResource(id = R.string.email_address_label)) },
            maxLines = 1,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(email) {
                    top.linkTo(username.bottom, 5.dp)
                }
                .padding(20.dp))

        TextField(value = viewModel.passwordText,
            onValueChange = { viewModel.passwordText = it },
            label = { Text(text = stringResource(id = R.string.password_label)) },
            maxLines = 1,
            textStyle = TextStyle(color = Color.Black),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(password) {
                    top.linkTo(email.bottom, 5.dp)
                }
                .padding(20.dp))


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
            onClick = onRegisterSuccess)

    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    FoodieTheme {
        RegisterScreen(modifier = Modifier.fillMaxSize(), viewModel = RegisterViewModel()) {}
    }
}