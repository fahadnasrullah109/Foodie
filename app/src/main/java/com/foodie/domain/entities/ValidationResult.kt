package com.foodie.domain.entities

import androidx.annotation.StringRes

sealed class ValidationResult {
    object Success : ValidationResult()
    data class Error(@StringRes val message: Int) : ValidationResult()
}
