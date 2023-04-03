package com.foodie.domain.usecases

import com.foodie.R
import com.foodie.domain.entities.ValidationResult

class UsernameValidationUseCase {

    fun validate(username: String): ValidationResult {
        return when {
            username.isBlank() -> ValidationResult.Error(R.string.username_empty_error)
            !isValidUsername(username) -> ValidationResult.Error(R.string.username_validation_error)
            else -> ValidationResult.Success
        }
    }

    private fun isValidUsername(username: String) =
        username.matches("^[A-Za-z][A-Za-z0-9_]{7,29}\$".toRegex())
}