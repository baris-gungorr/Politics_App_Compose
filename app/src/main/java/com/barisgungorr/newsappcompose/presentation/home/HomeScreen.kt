package com.barisgungorr.newsappcompose.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.barisgungorr.newsappcompose.R
import com.barisgungorr.newsappcompose.domain.model.Article
import com.barisgungorr.newsappcompose.presentation.Dimens.MediumPadding1
import com.barisgungorr.newsappcompose.presentation.common.ArticlesList
import com.barisgungorr.newsappcompose.presentation.nvgraph.Route

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    navigateToSearch: () -> Unit,
    navigateToDetails: (Article) -> Unit
) {
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83D\uDFE5 ") { it.title }
            } else {
                ""
            }
        }
    }

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
                }
            },

            )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = MediumPadding1)
        ) {

            Spacer(modifier = Modifier.height(MediumPadding1))

            com.barisgungorr.newsappcompose.presentation.common.SearchBar(
                modifier = Modifier
                    .padding(horizontal = MediumPadding1)
                    .fillMaxWidth(),
                text = "",
                readOnly = true,
                onValueChange = {},
                onSearch = {},
                onClick = {
                    navigateToSearch()
                }
            )
            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = titles, modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = MediumPadding1)
                    .basicMarquee(), fontSize = 12.sp,
                color = colorResource(id = R.color.placeholder)
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            ArticlesList(
                modifier = Modifier.padding(horizontal = MediumPadding1),
                articles = articles,
                onClick = navigateToDetails
            )
        }
    }
}
