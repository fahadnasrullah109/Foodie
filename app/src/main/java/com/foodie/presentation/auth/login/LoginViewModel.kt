package com.foodie.presentation.auth.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _emailText = MutableStateFlow("")
    private val _passwordText = MutableStateFlow("")
    private val _isFormValid = MutableStateFlow(false)

    val emailText = _emailText.asStateFlow()
    val passwordText = _passwordText.asStateFlow()
    val isFormValid = _isFormValid.asStateFlow()

    fun setEmail(email: String) {
        _emailText.value = email
        validateForm()
    }

    fun setPassword(password: String) {
        _passwordText.value = password
        validateForm()
    }

    private fun validateForm() {
        _isFormValid.value = _emailText.value.isValidEmail() && _emailText.value.isValidPassword()
    }
}

fun String.isValidEmail(): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidPassword(): Boolean {
    return length >= 6
}