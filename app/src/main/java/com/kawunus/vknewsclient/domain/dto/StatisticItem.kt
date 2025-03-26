package com.kawunus.vknewsclient.domain.dto

data class StatisticItem(
    val statisticType: StatisticType,
    val count: Int = 0
)

enum class StatisticType {
    VIEWS, COMMENTS, SHARES, LIKES
}