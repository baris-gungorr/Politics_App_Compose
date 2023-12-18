package com.barisgungorr.newsappcompose.data.remote.dto

import com.barisgungorr.newsappcompose.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)