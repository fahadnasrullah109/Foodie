package com.foodie.presentation.drawer

import com.foodie.R

sealed class DrawerItem(val title: Int, val icon: Int) {
    object Profile : DrawerItem(title = R.string.profile_label, icon = R.drawable.ic_drawer_profile)
    object Orders : DrawerItem(title = R.string.orders_label, icon = R.drawable.ic_drawer_order)
    object Offers :
        DrawerItem(title = R.string.offers_and_promo_label, icon = R.drawable.ic_drawer_offers)

    object Privacy : DrawerItem(title = R.string.privacy_label, icon = R.drawable.ic_drawer_privacy)
    object Security :
        DrawerItem(title = R.string.security_label, icon = R.drawable.ic_drawer_security)

    object SignOut : DrawerItem(title = R.string.signout_label, icon = R.drawable.ic_logout)
}
