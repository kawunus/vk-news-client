package com.kawunus.vknewsclient.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.kawunus.vknewsclient.R

sealed class NavigationItem(
    val titleResId: Int,
    val icon: ImageVector
) {

    object Main : NavigationItem(
        icon = Icons.Outlined.Home,
        titleResId = R.string.navigation_item_main
    )

    object Favorites : NavigationItem(
        icon = Icons.Outlined.Favorite,
        titleResId = R.string.navigation_item_favorites
    )

    object Profile : NavigationItem(
        icon = Icons.Outlined.Person,
        titleResId = R.string.navigation_item_profile
    )
}