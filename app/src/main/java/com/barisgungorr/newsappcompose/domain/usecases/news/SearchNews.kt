package com.barisgungorr.newsappcompose.domain.usecases.news

import androidx.paging.PagingData
import com.barisgungorr.newsappcompose.domain.model.Article
import com.barisgungorr.newsappcompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(
        searchQuery: String,
        sources: List<String>
    ) : Flow<PagingData<Article>> {
        return newsRepository.searchNews(searchQuery, sources)
    }


}