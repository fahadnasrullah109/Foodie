package com.foodie.presentation.navigation

import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.net.toUri
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.foodie.presentation.auth.AuthScreen
import com.foodie.presentation.cart.CartScreen
import com.foodie.presentation.drawer.DrawerScreen
import com.foodie.presentation.history.HistoryScreen
import com.foodie.presentation.landing.LandingScreen
import com.foodie.presentation.offers.OffersScreen
import com.foodie.presentation.order.OrdersScreen
import com.foodie.presentation.privacy.PrivacyScreen
import com.foodie.presentation.profile.ProfileScreen
import com.foodie.presentation.security.SecurityScreen

@Composable
fun FoodieAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.Landing.route
) {
    NavHost(
        modifier = modifier, navController = navController, startDestination = startDestination
    ) {
        landingGraph(navController)
        authGraph(navController)
        authDrawer(navController)
        cartGraph(navController)
        profileGraph(navController)
        ordersGraph(navController)
        offersGraph(navController)
        privacyGraph(navController)
        securityGraph(navController)
        historyGraph(navController)
    }
}

fun NavGraphBuilder.landingGraph(navController: NavController) {
    composable(Destinations.Landing.route) {
        LandingScreen(modifier = Modifier.fillMaxSize()) {
            navController.navigate(route = Destinations.Auth.route, navOptions = navOptions {
                popUpTo(Destinations.Landing.route) { inclusive = true }
            })
        }
    }
}

fun NavGraphBuilder.authGraph(navController: NavController) {
    composable(Destinations.Auth.route) {
        AuthScreen(modifier = Modifier.fillMaxSize(), onForgotPassword = {}, onLoginSuccess = {
            navController.navigate(route = Destinations.Drawer.route) {
                popUpTo(Destinations.Auth.route) { inclusive = true }
            }
        }, onRegisterSuccess = {
            navController.navigate(route = Destinations.Drawer.route) {
                popUpTo(Destinations.Auth.route) { inclusive = true }
            }
        })
    }
}

fun NavGraphBuilder.authDrawer(navController: NavController) {
    composable(Destinations.Drawer.route) {
        DrawerScreen(modifier = Modifier.fillMaxSize(), navController = navController)
    }
}

fun NavGraphBuilder.cartGraph(navController: NavController) {
    composable(Destinations.Cart.route) {
        CartScreen(modifier = Modifier.fillMaxSize()) {
            navController.navigateUp()
        }
    }
}

fun NavGraphBuilder.profileGraph(navController: NavController) {
    composable(Destinations.Profile.route) {
        ProfileScreen(modifier = Modifier.fillMaxSize(), onBack = {
            navController.navigateUp()
        }) {

        }
    }
}

fun NavGraphBuilder.ordersGraph(navController: NavController) {
    composable(Destinations.Orders.route) {
        OrdersScreen(modifier = Modifier.fillMaxSize(), onBack = {
            navController.navigateUp()
        }) {

        }
    }
}

fun NavGraphBuilder.offersGraph(navController: NavController) {
    composable(Destinations.Offers.route) {
        OffersScreen(modifier = Modifier.fillMaxSize()) {
            navController.navigateUp()
        }
    }
}

fun NavGraphBuilder.privacyGraph(navController: NavController) {
    composable(Destinations.Privacy.route) {
        PrivacyScreen(modifier = Modifier.fillMaxSize()) {
            navController.navigateUp()
        }
    }
}

fun NavGraphBuilder.securityGraph(navController: NavController) {
    composable(Destinations.Security.route) {
        SecurityScreen(modifier = Modifier.fillMaxSize()) {
            navController.navigateUp()
        }
    }
}

fun NavGraphBuilder.historyGraph(navController: NavController) {
    composable(Destinations.History.route) {
        HistoryScreen(modifier = Modifier.fillMaxSize(), onBack = {
            navController.navigateUp()
        }) {

        }
    }
}


fun NavController.navigate(
    route: String,
    args: Bundle,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null
) {
    val routeLink =
        NavDeepLinkRequest.Builder.fromUri(NavDestination.createRoute(route).toUri()).build()
    val deepLinkMatch = graph.matchDeepLink(routeLink)
    if (deepLinkMatch != null) {
        val destination = deepLinkMatch.destination
        val id = destination.id
        navigate(id, args, navOptions, navigatorExtras)
    } else {
        navigate(route, navOptions, navigatorExtras)
    }
}

fun <T> NavBackStackEntry.parcelableData(key: String): T? {
    return arguments?.getParcelable(key) as? T
}