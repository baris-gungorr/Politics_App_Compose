package com.barisgungorr.newsappcompose.domain.usecases.news

import com.barisgungorr.newsappcompose.data.local.NewsDao
import com.barisgungorr.newsappcompose.domain.model.Article
import javax.inject.Inject

class UpsertArticle @Inject constructor(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article){
        newsDao.upsert(article = article)
    }

}