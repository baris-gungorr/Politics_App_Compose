package com.barisgungorr.newsappcompose.di

import android.app.Application
import androidx.room.Room
import com.barisgungorr.newsappcompose.data.local.NewsDao
import com.barisgungorr.newsappcompose.data.local.NewsDatabase
import com.barisgungorr.newsappcompose.data.local.NewsTypeConvertor
import com.barisgungorr.newsappcompose.data.manager.LocalUserMangerImpl
import com.barisgungorr.newsappcompose.data.remote.NewsApi
import com.barisgungorr.newsappcompose.data.repository.NewsRepositoryImpl
import com.barisgungorr.newsappcompose.domain.manager.LocalUserManager
import com.barisgungorr.newsappcompose.domain.repository.NewsRepository
import com.barisgungorr.newsappcompose.domain.usecases.app_entry.AppEntryUseCases
import com.barisgungorr.newsappcompose.domain.usecases.app_entry.ReadAppEntry
import com.barisgungorr.newsappcompose.domain.usecases.app_entry.SaveAppEntry
import com.barisgungorr.newsappcompose.domain.usecases.news.DeleteArticle
import com.barisgungorr.newsappcompose.domain.usecases.news.GetArticle
import com.barisgungorr.newsappcompose.domain.usecases.news.GetArticles
import com.barisgungorr.newsappcompose.domain.usecases.news.GetNews
import com.barisgungorr.newsappcompose.domain.usecases.news.NewsUseCases
import com.barisgungorr.newsappcompose.domain.usecases.news.SearchNews
import com.barisgungorr.newsappcompose.domain.usecases.news.UpsertArticle
import com.barisgungorr.newsappcompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManager = LocalUserMangerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManager,
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger),
    )

    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi,newsDao)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsDao),
            deleteArticle = DeleteArticle(newsDao),
            getArticles = GetArticles(newsDao),
            getArticle = GetArticle(newsDao)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao
}