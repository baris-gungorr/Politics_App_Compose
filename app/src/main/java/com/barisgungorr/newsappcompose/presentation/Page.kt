package com.barisgungorr.newsappcompose.presentation

import androidx.annotation.DrawableRes
import com.barisgungorr.newsappcompose.R

data class Page (
    val title: String,
    val description: String,
    @DrawableRes val image: Int)

val pages = listOf(
    Page(
        title = "Shape Your News Feed",
        description ="Are you ready for an adventure full of knowledge, not a simple text?",
        image = R.drawable.ob1
    ),
    Page(
        title = "Stay in the Spotlight in Every Aspect",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        image = R.drawable.ob2
    ),
    Page(
        title = "News Instantly in Your Pocket",
        description = "It offers you the most comprehensive information by covering all aspects of the agenda.",
        image = R.drawable.ob3
    )
)
