package com.barisgungorr.newsappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.barisgungorr.newsappcompose.presentation.nvgraph.NavGraph
import com.barisgungorr.newsappcompose.ui.theme.NewsAppComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition
            }
        }

        setContent {
            NewsAppComposeTheme {

                Box(modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.background)
                    .fillMaxSize()) {
                    val startDestination = viewModel._startDestination
                    NavGraph(startDestination =startDestination)


                }
            }
        }
    }
}