package com.foodie.domain.usecases

import com.foodie.R
import com.foodie.domain.entities.ValidationResult

class PasswordValidationUseCase {

    fun validate(password: String): ValidationResult {
        return when {
            password.isBlank() -> ValidationResult.Error(R.string.password_empty_error)
            !isValidPassword(password) -> ValidationResult.Error(R.string.password_validation_error)
            else -> ValidationResult.Success
        }
    }

    private fun isValidPassword(password: String) = password.length >= 6
}