@file:OptIn(ExperimentalMaterial3Api::class)

package com.foodie.presentation.drawer

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.foodie.R
import com.foodie.presentation.home.HomeScreen
import com.foodie.ui.theme.FoodieTheme
import com.foodie.ui.theme.login_signup_bg
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DrawerScreen(modifier: Modifier = Modifier, navController: NavController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val drawerItems = listOf(
        DrawerItem.Profile,
        DrawerItem.Orders,
        DrawerItem.Offers,
        DrawerItem.Privacy,
        DrawerItem.Security,
        DrawerItem.SignOut
    )
    var selectedItem by remember { mutableStateOf(drawerItems[0]) }
    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        ModalDrawerSheet(drawerContainerColor = MaterialTheme.colorScheme.primary) {
            Spacer(Modifier.height(30.dp))
            drawerItems.forEach { item ->
                NavigationDrawerItem(
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        unselectedContainerColor = MaterialTheme.colorScheme.primary,
                        selectedIconColor = Color.White,
                        unselectedIconColor = Color.White,
                        selectedTextColor = Color.White,
                        unselectedTextColor = Color.White
                    ),
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon), contentDescription = null
                        )
                    },
                    label = { Text(stringResource(id = item.title)) },
                    selected = false,
                    onClick = {
                        scope.launch { drawerState.close() }
                        selectedItem = item
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
            }
        }
    }, content = {
        Scaffold(modifier = modifier.background(color = login_signup_bg), topBar = {
            TopAppBar(title = {}, navigationIcon = {
                IconButton(onClick = {
                    scope.launch { drawerState.open() }
                }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_menu),
                        contentDescription = "menu icon"
                    )
                }
            }, actions = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_navigation_shopping_cart),
                        contentDescription = "cart icon"
                    )
                }
            })
        }, content = { innerPadding ->
            HomeScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(start = 20.dp, end = 20.dp)
            )
        })
    })
}

@Preview
@Composable
fun DrawerScreenPreview() {
    FoodieTheme {
        DrawerScreen(modifier = Modifier.fillMaxSize(), navController = rememberNavController())
    }
}