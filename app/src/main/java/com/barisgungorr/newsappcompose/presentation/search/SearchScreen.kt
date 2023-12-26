package com.barisgungorr.newsappcompose.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.paging.compose.collectAsLazyPagingItems
import com.barisgungorr.newsappcompose.domain.model.Article
import com.barisgungorr.newsappcompose.presentation.Dimens.MediumPadding1
import com.barisgungorr.newsappcompose.presentation.common.ArticlesList
import com.barisgungorr.newsappcompose.presentation.nvgraph.Route

@Composable
fun SearchScreen(
    state: SearchState,
    event:(SearchEvent) -> Unit,
    navigateToDetails: (Article) -> Unit
) {

    Column(
        modifier = Modifier
            .padding(top = MediumPadding1, start = MediumPadding1, end = MediumPadding1)
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        com.barisgungorr.newsappcompose.presentation.common.SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = {
                event(SearchEvent.SearchNews)
            }
        )

        Spacer(modifier = Modifier.height(MediumPadding1))
        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticlesList(
                articles = articles,
                onClick = { article ->
                    navigateToDetails(article)
                }
            )
        }
    }
}