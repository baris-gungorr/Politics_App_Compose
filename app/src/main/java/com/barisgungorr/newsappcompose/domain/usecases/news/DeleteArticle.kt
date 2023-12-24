package com.barisgungorr.newsappcompose.domain.usecases.news

import com.barisgungorr.newsappcompose.data.local.NewsDao
import com.barisgungorr.newsappcompose.domain.model.Article

class DeleteArticle(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article) = newsDao.delete(article)
    }
