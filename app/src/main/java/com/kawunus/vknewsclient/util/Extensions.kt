package com.kawunus.vknewsclient.util

import com.kawunus.vknewsclient.domain.dto.StatisticItem
import com.kawunus.vknewsclient.domain.dto.StatisticType

fun List<StatisticItem>.getItemByType(type: StatisticType): StatisticItem {
    return this.find { it.statisticType == type } ?: throw IllegalStateException("Unknown statistics type")
}