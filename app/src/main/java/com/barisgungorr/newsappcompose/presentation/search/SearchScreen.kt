package com.barisgungorr.newsappcompose.presentation.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.paging.compose.collectAsLazyPagingItems
import com.barisgungorr.newsappcompose.R
import com.barisgungorr.newsappcompose.domain.model.Article
import com.barisgungorr.newsappcompose.presentation.Dimens.MediumPadding1
import com.barisgungorr.newsappcompose.presentation.common.ArticlesList
import com.barisgungorr.newsappcompose.presentation.nvgraph.Route

@OptIn(ExperimentalMaterial3Api::class)
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

                title = { Text(text = "BNews") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.body),
                    titleContentColor = colorResource(id = R.color.input_background)
                ),

                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu"
                        )
                        Spacer(modifier = Modifier.height(40.dp))
                    }
                },
            )

            Spacer(modifier = Modifier.height(40.dp))

            com.barisgungorr.newsappcompose.presentation.common.SearchBar(
                text = state.searchQuery,
                readOnly = false,
                onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
                onSearch = {
                    event(SearchEvent.SearchNews)
                }
            )



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
