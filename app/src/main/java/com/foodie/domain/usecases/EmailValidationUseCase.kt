package com.foodie.domain.usecases

import com.foodie.R
import com.foodie.domain.entities.ValidationResult

class EmailValidationUseCase {

    fun validate(email: String): ValidationResult {
        return when {
            email.isBlank() -> ValidationResult.Error(R.string.email_empty_error)
            !isValidEmail(email) -> ValidationResult.Error(R.string.email_validation_error)
            else -> ValidationResult.Success
        }
    }

    private fun isValidEmail(email: String) =
        android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}