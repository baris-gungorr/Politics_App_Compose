package com.barisgungorr.newsappcompose.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.barisgungorr.newsappcompose.domain.model.Article
import com.barisgungorr.newsappcompose.presentation.Dimens.ArticleCardSize

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article:Article,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    Row(modifier = modifier.clickable { onClick() }) {

        AsyncImage(
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context)
                .data(article.urlToImage)
                .build(),
            contentDescription = article.title
        )


    }


}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview() {

}

