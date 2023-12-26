package com.barisgungorr.newsappcompose.domain.usecases.news

import com.barisgungorr.newsappcompose.data.local.NewsDao
import com.barisgungorr.newsappcompose.domain.model.Article

class GetArticle (
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String): Article?{
        return newsDao.getArticle(url = url)
    }

}