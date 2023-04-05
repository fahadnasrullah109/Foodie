package com.foodie.presentation.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.foodie.domain.entities.ValidationResult
import com.foodie.domain.usecases.EmailValidationUseCase
import com.foodie.domain.usecases.PasswordValidationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val emailValidator: EmailValidationUseCase,
    private val passwordValidator: PasswordValidationUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUIState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: LoginEvents) {
        when (event) {
            is LoginEvents.EmailChanged -> _uiState.value = _uiState.value.copy(
                email = event.email
            )
            is LoginEvents.PasswordChanged -> _uiState.value = _uiState.value.copy(
                password = event.password
            )
            LoginEvents.LoginClicked -> login()
        }
    }

    private fun showLoading() {
        _uiState.value = uiState.value.copy(
            isLoading = true, emailError = null, passwordError = null
        )
    }

    private fun login() {
        val emailResult = emailValidator.validate(_uiState.value.email)
        val passwordResult = passwordValidator.validate(_uiState.value.password)
        val hasError = listOf(emailResult, passwordResult).any {
            it is ValidationResult.Error
        }
        if (hasError) {
            _uiState.value = _uiState.value.copy(
                emailError = if (emailResult is ValidationResult.Error) {
                    emailResult.message
                } else null, passwordError = if (passwordResult is ValidationResult.Error) {
                    passwordResult.message
                } else null
            )
        } else {
            showLoading()
            viewModelScope.launch(Dispatchers.IO) {
                delay(3000L)

                withContext(Dispatchers.Main) {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false, loginSuccess = true
                    )
                }
            }
        }
    }
}