package com.barisgungorr.newsappcompose.domain.usecases.news

data class NewsUseCase(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val upsertArticle: UpsertArticle,
    val deleteArticle: DeleteArticle,
    val selectArticle: SelectArticle
)
