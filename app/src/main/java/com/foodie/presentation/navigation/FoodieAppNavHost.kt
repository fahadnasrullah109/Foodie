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
import com.foodie.presentation.landing.LandingScreen
import com.foodie.presentation.login.LoginScreen

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
    }
}

fun NavGraphBuilder.landingGraph(navController: NavController) {
    composable(Destinations.Landing.route) {
        LandingScreen(modifier = Modifier.fillMaxSize()) {
            navController.navigate(route = Destinations.Auth.route)
        }
    }
}

fun NavGraphBuilder.authGraph(navController: NavController) {
    composable(Destinations.Auth.route) {
        LoginScreen(modifier = Modifier.fillMaxSize(), onForgotPassword = {

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