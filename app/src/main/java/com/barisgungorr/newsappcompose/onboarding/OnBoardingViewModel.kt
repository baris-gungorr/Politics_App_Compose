package com.barisgungorr.newsappcompose.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.barisgungorr.newsappcompose.domain.usecases.AppEntryUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
): ViewModel() {

    fun onEvent(event: OnBoardingEvent) {
        when(event) {
            is OnBoardingEvent.SaveAppEntry -> {
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCases.saveAppEntry()
        }
    }
}

// bu sınıfın amacı, kullanıcı uygulamaya ilk girdiğinde onboarding ekranını göstermek ve kullanıcı onboarding ekranını geçtiğinde kullanıcıyı ana ekrana yönlendirmek.