package com.barisgungorr.newsappcompose.di

import android.app.Application
import androidx.room.Room
import com.barisgungorr.newsappcompose.data.local.NewsDao
import com.barisgungorr.newsappcompose.data.local.NewsDataBase
import com.barisgungorr.newsappcompose.data.local.NewsTypeConvertor
import com.barisgungorr.newsappcompose.data.manager.LocalUserImplementation
import com.barisgungorr.newsappcompose.data.remote.NewsApi
import com.barisgungorr.newsappcompose.data.repository.NewsRepositoryImpl
import com.barisgungorr.newsappcompose.domain.manager.LocalUserManager
import com.barisgungorr.newsappcompose.domain.repository.NewsRepository
import com.barisgungorr.newsappcompose.domain.usecases.app_entry.AppEntryUseCases
import com.barisgungorr.newsappcompose.domain.usecases.app_entry.ReadAppEntry
import com.barisgungorr.newsappcompose.domain.usecases.app_entry.SaveAppEntry
import com.barisgungorr.newsappcompose.domain.usecases.news.DeleteArticle
import com.barisgungorr.newsappcompose.domain.usecases.news.GetNews
import com.barisgungorr.newsappcompose.domain.usecases.news.NewsUseCase
import com.barisgungorr.newsappcompose.domain.usecases.news.SearchNews
import com.barisgungorr.newsappcompose.domain.usecases.news.SelectArticle
import com.barisgungorr.newsappcompose.domain.usecases.news.UpsertArticle
import com.barisgungorr.newsappcompose.util.Constants.DATABASE_NAME
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
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserImplementation(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    )= AppEntryUseCases(
        saveAppEntry = SaveAppEntry(localUserManager),
        readAppEntry = ReadAppEntry(localUserManager)
    )
    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NewsApi::class.java)
    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCase(
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ) : NewsUseCase {
        return NewsUseCase(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsDao),
            deleteArticle = DeleteArticle(newsDao),
            selectArticle = SelectArticle(newsDao)
        )
    }
    @Provides
    @Singleton
    fun provideNewsDatabase(
        application:Application
    ): NewsDataBase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDataBase::class.java,
            name = DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase:NewsDataBase
    ): NewsDao = newsDatabase.newsDao




}