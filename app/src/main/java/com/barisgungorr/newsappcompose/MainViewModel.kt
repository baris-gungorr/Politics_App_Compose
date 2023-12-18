package com.barisgungorr.newsappcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barisgungorr.newsappcompose.domain.usecases.app_entry.AppEntryUseCases
import com.barisgungorr.newsappcompose.presentation.nvgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
): ViewModel() {

 //   private val _splashCondition = mutableStateOf(true)
 var splashCondition by mutableStateOf(true)
         private set

    var _startDestination by mutableStateOf(Route.AppStartNavigation.route)
     private set

    init {
        appEntryUseCases.readAppEntry().onEach { shouldStartFromHomeScreen ->
            _startDestination = if(shouldStartFromHomeScreen){
                Route.NewsNavigation.route
            }else{
                Route.AppStartNavigation.route
            }
            delay(200) //Without this delay, the onBoarding screen will show for a momentum.
            splashCondition = false
        }.launchIn(viewModelScope)
    }
}
