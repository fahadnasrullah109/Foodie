package com.foodie.presentation.navigation

sealed class Destinations(val route: String) {
    object Landing : Destinations("landing")
    object Auth : Destinations("auth")
    object Drawer : Destinations("drawer")
    object Cart : Destinations("cart")
    object Profile : Destinations("profile")
    object Orders : Destinations("orders")
    object Privacy : Destinations("privacy")
    object Offers : Destinations("offers")
    object Security : Destinations("security")
}
