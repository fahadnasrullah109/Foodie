package com.foodie.presentation.auth.login

import androidx.annotation.StringRes

data class LoginUIState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    @StringRes val emailError: Int? = null,
    @StringRes val passwordError: Int? = null,
    val loginSuccess: Boolean = false
)