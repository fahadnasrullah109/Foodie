package com.foodie.presentation.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.foodie.domain.entities.ValidationResult
import com.foodie.domain.usecases.EmailValidationUseCase
import com.foodie.domain.usecases.PasswordValidationUseCase
import com.foodie.domain.usecases.UsernameValidationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val usernameValidator: UsernameValidationUseCase,
    private val emailValidator: EmailValidationUseCase,
    private val passwordValidator: PasswordValidationUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUIState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(events: RegisterEvents) {
        when (events) {
            is RegisterEvents.UsernameChanged -> _uiState.value =
                _uiState.value.copy(username = events.username)
            is RegisterEvents.EmailChanged -> _uiState.value =
                _uiState.value.copy(email = events.email)
            is RegisterEvents.PasswordChanged -> _uiState.value =
                _uiState.value.copy(password = events.password)
            RegisterEvents.RegisterClicked -> register()
        }
    }

    private fun showLoading() {
        _uiState.value = _uiState.value.copy(
            isLoading = true, usernameError = null, emailError = null, passwordError = null
        )
    }

    private fun register() {
        val usernameResult = usernameValidator.validate(_uiState.value.username)
        val emailResult = emailValidator.validate(_uiState.value.email)
        val passwordResult = passwordValidator.validate(_uiState.value.password)
        val hasError = listOf(usernameResult, emailResult, passwordResult).any {
            it is ValidationResult.Error
        }
        if (hasError) {
            if (usernameResult is ValidationResult.Error) _uiState.value = _uiState.value.copy(
                usernameError = usernameResult.message
            ) else _uiState.value = _uiState.value.copy(
                usernameError = null
            )
            if (emailResult is ValidationResult.Error) _uiState.value = _uiState.value.copy(
                emailError = emailResult.message
            )
            else _uiState.value = _uiState.value.copy(
                emailError = null
            )
            if (passwordResult is ValidationResult.Error) _uiState.value = _uiState.value.copy(
                passwordError = passwordResult.message
            ) else _uiState.value = _uiState.value.copy(
                passwordError = null
            )
        } else {
            showLoading()
            viewModelScope.launch(Dispatchers.IO) {
                delay(3000)

                _uiState.value = _uiState.value.copy(
                    isLoading = false, registerSuccess = true
                )
            }
        }
    }
}