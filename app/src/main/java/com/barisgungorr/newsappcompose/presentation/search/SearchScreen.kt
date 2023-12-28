package com.barisgungorr.newsappcompose.presentation.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.barisgungorr.newsappcompose.R
import com.barisgungorr.newsappcompose.domain.model.Article
import com.barisgungorr.newsappcompose.presentation.Dimens.MediumPadding1
import com.barisgungorr.newsappcompose.presentation.common.ArticlesList
import com.barisgungorr.newsappcompose.presentation.common.SearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    state: SearchState,
    event:(SearchEvent) -> Unit,
    navigateToDetails: (Article) -> Unit
) {
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            verticalArrangement = Arrangement.Top
        ) {
            TopAppBar(
                title = { Text(text = "SEARCH") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.body),
                    titleContentColor = colorResource(id = R.color.input_background)
                ),
            )

            Spacer(modifier = Modifier.height(20.dp))

            SearchBar(
                modifier = Modifier
                    .padding(horizontal = MediumPadding1)
                    .fillMaxWidth(),

                text = state.searchQuery,
                readOnly = false,
                onValueChange = {
                    event(SearchEvent.UpdateSearchQuery(it)) },


                ) {
                event(SearchEvent.SearchNews)

            }

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
}
