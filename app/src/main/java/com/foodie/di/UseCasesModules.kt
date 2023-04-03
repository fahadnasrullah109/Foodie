package com.foodie.di

import com.foodie.domain.usecases.EmailValidationUseCase
import com.foodie.domain.usecases.PasswordValidationUseCase
import com.foodie.domain.usecases.UsernameValidationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UseCasesModules {

    @ViewModelScoped
    @Provides
    fun provideEmailValidationUseCase() = EmailValidationUseCase()

    @ViewModelScoped
    @Provides
    fun providePasswordValidationUseCase() = PasswordValidationUseCase()

    @ViewModelScoped
    @Provides
    fun provideUsernameValidationUseCase() = UsernameValidationUseCase()

}