package com.barisgungorr.newsappcompose.presentation.bookmark

import com.barisgungorr.newsappcompose.domain.model.Article

data class BookMarkState(
    val articles: List<Article> = emptyList()
)
