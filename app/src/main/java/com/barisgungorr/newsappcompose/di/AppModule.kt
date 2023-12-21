package com.barisgungorr.newsappcompose.di

import android.app.Application
import com.barisgungorr.newsappcompose.data.manager.LocalUserImplementation
import com.barisgungorr.newsappcompose.data.remote.NewsApi
import com.barisgungorr.newsappcompose.data.repository.NewsRepositoryImpl
import com.barisgungorr.newsappcompose.domain.manager.LocalUserManager
import com.barisgungorr.newsappcompose.domain.repository.NewsRepository
import com.barisgungorr.newsappcompose.domain.usecases.app_entry.AppEntryUseCases
import com.barisgungorr.newsappcompose.domain.usecases.app_entry.ReadAppEntry
import com.barisgungorr.newsappcompose.domain.usecases.app_entry.SaveAppEntry
import com.barisgungorr.newsappcompose.domain.usecases.news.GetNews
import com.barisgungorr.newsappcompose.domain.usecases.news.NewsUseCase
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
        newsRepository: NewsRepository
    ) : NewsUseCase {
        return NewsUseCase(
            getNews = GetNews(newsRepository)
        )
    }
}