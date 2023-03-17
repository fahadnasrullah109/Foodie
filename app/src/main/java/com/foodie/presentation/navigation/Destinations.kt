package com.foodie.presentation.navigation

sealed class Destinations(val route: String) {
    object Landing : Destinations("landing")
    object Auth : Destinations("auth")
}
