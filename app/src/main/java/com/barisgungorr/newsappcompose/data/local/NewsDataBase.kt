package com.barisgungorr.newsappcompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.barisgungorr.newsappcompose.domain.model.Article

@Database(entities = [Article::class],version = 1)
@TypeConverters(NewsTypeConvertor::class)
abstract class NewsDataBase: RoomDatabase() {
    abstract val newsDao:NewsDao

 }