package com.foodie.presentation.auth.register

import androidx.annotation.StringRes

data class RegisterUIState(
    val username : String = "",
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    @StringRes val usernameError: Int? = null,
    @StringRes val emailError: Int? = null,
    @StringRes val passwordError: Int? = null,
    val registerSuccess: Boolean = false
)