package com.barisgungorr.newsappcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.barisgungorr.newsappcompose.domain.usecases.AppEntryUseCases
import com.barisgungorr.newsappcompose.onboarding.OnBoardingViewModel
import com.barisgungorr.newsappcompose.onboarding.components.OnBoardingScreen
import com.barisgungorr.newsappcompose.ui.theme.NewsAppComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appEntryUseCases: AppEntryUseCases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        lifecycleScope.launch {
            appEntryUseCases.readAppEntry().collect{
                Log.d("true", "onCreate: $it")

            }
        }

        setContent {
            NewsAppComposeTheme {
                Box(modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.background)
                    .fillMaxSize()) {
                    val viewModel : OnBoardingViewModel = hiltViewModel()
                   OnBoardingScreen(
                       event = viewModel::onEvent
                   )
                }
            }
        }
    }
}