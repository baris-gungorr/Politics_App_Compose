package com.barisgungorr.newsappcompose.domain.usecases.news

import com.barisgungorr.newsappcompose.data.local.NewsDao
import com.barisgungorr.newsappcompose.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetArticles(
    private val newsDao: NewsDao
) {

    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }

}