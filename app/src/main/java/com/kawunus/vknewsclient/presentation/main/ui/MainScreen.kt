package com.kawunus.vknewsclient.presentation.main.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kawunus.vknewsclient.domain.dto.FeedPost
import com.kawunus.vknewsclient.presentation.NavigationItem.Favorites
import com.kawunus.vknewsclient.presentation.NavigationItem.Main
import com.kawunus.vknewsclient.presentation.NavigationItem.Profile
import com.kawunus.vknewsclient.presentation.PostCard
import com.kawunus.vknewsclient.presentation.main.viewmodel.MainViewModel
import com.kawunus.vknewsclient.presentation.theme.VkNewsClientTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: MainViewModel) {

    val feedPost = viewModel.feedPost.observeAsState(FeedPost())

    Scaffold(
        bottomBar = {
            NavigationBar()
        },
        modifier = Modifier
            .padding(top = 20.dp)
    ) {
        PostCard(
            modifier = Modifier
                .padding(8.dp),
            feedPost = feedPost.value,
            onLikesClickListener = viewModel::updateCount,
            onSharesClickListener = viewModel::updateCount,
            onViewsClickListener = viewModel::updateCount,
            onCommentsClickListener = viewModel::updateCount,
        )
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
        MainScreen(MainViewModel())
    }
}

@Composable
@Preview
private fun PreviewDark() {
    VkNewsClientTheme(darkTheme = true) {
        MainScreen(MainViewModel())
    }
}