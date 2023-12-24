package com.barisgungorr.newsappcompose.presentation.bookmark

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barisgungorr.newsappcompose.domain.repository.NewsRepository
import com.barisgungorr.newsappcompose.domain.usecases.news.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookMarkViewModel @Inject constructor(
    private val newsUseCases: NewsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(BookMarkState())
    val state : State<BookMarkState> = _state
    init {
        getArticles()
    }

    private fun getArticles() {
        newsUseCases.selectArticle().onEach{
            _state.value = _state.value.copy(articles = it)

        }.launchIn(viewModelScope)
    }
}