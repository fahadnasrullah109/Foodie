package com.foodie.presentation.auth.login

sealed interface LoginEvents {

    data class EmailChanged(val email: String) : LoginEvents

    data class PasswordChanged(val password: String) : LoginEvents

    object LoginClicked : LoginEvents
}