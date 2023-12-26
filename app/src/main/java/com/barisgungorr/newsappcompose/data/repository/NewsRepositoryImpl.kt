package com.barisgungorr.newsappcompose.data.repository

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.barisgungorr.newsappcompose.data.local.NewsDao
import com.barisgungorr.newsappcompose.data.remote.NewsApi
import com.barisgungorr.newsappcompose.data.remote.NewsPagingSource
import com.barisgungorr.newsappcompose.data.remote.SearchNewsPagingResource
import com.barisgungorr.newsappcompose.domain.manager.LocalUserManager
import com.barisgungorr.newsappcompose.domain.model.Article
import com.barisgungorr.newsappcompose.domain.repository.NewsRepository
import com.barisgungorr.newsappcompose.util.Constants
import com.barisgungorr.newsappcompose.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class NewsRepositoryImpl(
    private val newsApi: NewsApi,
    private val newsDao: NewsDao
) : NewsRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(newsApi = newsApi, sources = sources.joinToString(separator = ","))
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingResource(
                    api = newsApi,
                    searchQuery = searchQuery,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override suspend fun upsertArticle(article: Article) {
        newsDao.upsert(article)
    }

    override suspend fun deleteArticle(article: Article) {
        newsDao.delete(article)
    }

    override fun getArticles(): Flow<List<Article>> {
        return newsDao.getArticles()
    }

    override suspend fun getArticle(url: String): Article? {
        return newsDao.getArticle(url = url)
    }
}