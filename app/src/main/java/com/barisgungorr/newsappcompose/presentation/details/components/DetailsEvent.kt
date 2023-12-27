package com.barisgungorr.newsappcompose.presentation.details.components

import com.barisgungorr.newsappcompose.domain.model.Article

sealed class DetailsEvent {
    data class UpsertDeleteArticle(val article: Article): DetailsEvent()

    // data object RemoveSideEffect : DetailsEvent()

    data object RemoveSideEffect : DetailsEvent()
   // data object UpsertDeleteArticle : DetailsEvent()
}