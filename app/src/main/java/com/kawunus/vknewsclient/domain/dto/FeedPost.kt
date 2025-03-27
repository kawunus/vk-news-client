package com.kawunus.vknewsclient.domain.dto

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.kawunus.vknewsclient.R

data class FeedPost(
    val id: Int = 0,
    val communityName: String = "/dev/null",
    val publicationTime: String = "14:00",
    val avatarResId: Int = R.drawable.placeholder_avatar,
    val contentText: String = LoremIpsum(words = 8)
        .values
        .toList()
        .first()
        .toString(),
    val contentImageResId: Int = R.drawable.placeholder_content,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(
            statisticType = StatisticType.VIEWS,
            count = 955
        ),
        StatisticItem(
            statisticType = StatisticType.SHARES,
            count = 23
        ),
        StatisticItem(
            statisticType = StatisticType.COMMENTS,
            count = 28
        ),
        StatisticItem(
            statisticType = StatisticType.LIKES,
            count = 120
        ),
    )
)
