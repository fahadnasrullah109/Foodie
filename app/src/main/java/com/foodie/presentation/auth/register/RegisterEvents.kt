package com.foodie.presentation.auth.register

sealed interface RegisterEvents {

    data class UsernameChanged(val username: String) : RegisterEvents

    data class EmailChanged(val email: String) : RegisterEvents

    data class PasswordChanged(val password: String) : RegisterEvents

    object RegisterClicked : RegisterEvents
}