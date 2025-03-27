package com.kawunus.vknewsclient.presentation.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kawunus.vknewsclient.domain.dto.FeedPost
import com.kawunus.vknewsclient.domain.dto.StatisticItem
import java.lang.IllegalStateException

class MainViewModel : ViewModel() {

    private val _feedPost = MutableLiveData(FeedPost())
    val feedPost: LiveData<FeedPost> = _feedPost

    fun updateCount(item: StatisticItem) {
        val oldStatistics = _feedPost.value?.statistics ?: throw IllegalStateException()
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.statisticType == item.statisticType) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }

        _feedPost.value = feedPost.value?.copy(statistics = newStatistics)
    }
}