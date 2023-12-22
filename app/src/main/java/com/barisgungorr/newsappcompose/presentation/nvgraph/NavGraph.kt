package com.barisgungorr.newsappcompose.presentation.nvgraph

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.barisgungorr.newsappcompose.presentation.home.HomeScreen
import com.barisgungorr.newsappcompose.presentation.home.HomeViewModel
import com.barisgungorr.newsappcompose.presentation.onboarding.OnBoardingViewModel
import com.barisgungorr.newsappcompose.presentation.onboarding.components.OnBoardingScreen
import com.barisgungorr.newsappcompose.presentation.search.SearchScreen
import com.barisgungorr.newsappcompose.presentation.search.SearchViewModel


@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(
                route = Route.OnBoardingScreen.route
            ) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }
        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.HomeScreen.route
        ) {
            composable(route = Route.HomeScreen.route) {
             val viewModel: SearchViewModel = hiltViewModel()
            SearchScreen(state = viewModel.state.value , event =viewModel::onEvent , navigate ={} )
            }
        }
    }
}