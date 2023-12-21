package com.barisgungorr.newsappcompose.presentation.onboarding

sealed class OnBoardingEvent {
    data object SaveAppEntry : OnBoardingEvent()
}