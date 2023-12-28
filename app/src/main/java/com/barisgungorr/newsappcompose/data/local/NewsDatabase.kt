package com.barisgungorr.newsappcompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.barisgungorr.newsappcompose.domain.model.Article

@Database(entities = [Article::class],version = 2)
@TypeConverters(NewsTypeConvertor::class)
abstract class NewsDatabase: RoomDatabase() {
    abstract val newsDao:NewsDao
 }