package com.barisgungorr.newsappcompose.presentation.search

import androidx.paging.PagingData
import com.barisgungorr.newsappcompose.domain.model.Article
import java.util.concurrent.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: kotlinx.coroutines.flow.Flow<PagingData<Article>>? = null,
) {
}