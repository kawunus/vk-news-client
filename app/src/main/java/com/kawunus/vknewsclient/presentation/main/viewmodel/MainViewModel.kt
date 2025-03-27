package com.kawunus.vknewsclient.presentation.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kawunus.vknewsclient.domain.dto.FeedPost
import com.kawunus.vknewsclient.domain.dto.StatisticItem

class MainViewModel : ViewModel() {

    private val sourceList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(FeedPost(id = it))
        }
    }

    private val _feedPosts = MutableLiveData<List<FeedPost>>(sourceList)
    val feedPosts: LiveData<List<FeedPost>> = _feedPosts

    fun updateCount(item: StatisticItem, model: FeedPost) {
        val oldPosts = feedPosts.value?.toMutableList() ?: mutableListOf()
        val oldStatistics = model.statistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.statisticType == item.statisticType) {
                    oldItem.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        val newModel = model.copy(statistics = newStatistics)
        _feedPosts.value = oldPosts.apply {
            replaceAll {
                if (it.id == newModel.id) {
                    newModel
                } else {
                    it
                }
            }
        }
    }

    fun removePost(model: FeedPost) {
        val oldPosts = feedPosts.value?.toMutableList() ?: mutableListOf()
        val modelForDelete = oldPosts.find { it.id == model.id }
        oldPosts.remove(modelForDelete)
        _feedPosts.value = oldPosts
    }
}