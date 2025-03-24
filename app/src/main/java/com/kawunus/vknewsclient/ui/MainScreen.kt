package com.kawunus.vknewsclient.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kawunus.vknewsclient.ui.NavigationItem.Favorites
import com.kawunus.vknewsclient.ui.NavigationItem.Main
import com.kawunus.vknewsclient.ui.NavigationItem.Profile
import com.kawunus.vknewsclient.ui.theme.VkNewsClientTheme

@Composable
fun MainScreen() {
    Scaffold(
        bottomBar = {
            NavigationBar()
        }
    ) {

    }
}

@Composable
private fun NavigationBar() {
    NavigationBar {
        var selectedItemPosition = remember { mutableIntStateOf(0) }

        val items = listOf(Main, Favorites, Profile)
        items.forEachIndexed { position, item ->
            NavigationBarItem(
                selected = selectedItemPosition.intValue == position,
                onClick = {
                    selectedItemPosition.intValue = position
                },
                icon = {
                    Icon(item.icon, contentDescription = null)
                },
                label = {
                    Text(text = stringResource(item.titleResId))
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                    unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                    indicatorColor = Color.Transparent,
                ),

                )
        }
    }
}

@Composable
@Preview
private fun PreviewLight() {
    VkNewsClientTheme(darkTheme = false) {
        MainScreen()
    }
}

@Composable
@Preview
private fun PreviewDark() {
    VkNewsClientTheme(darkTheme = true) {
        MainScreen()
    }
}