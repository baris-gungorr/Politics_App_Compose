package com.barisgungorr.newsappcompose.domain.usecases

import com.barisgungorr.newsappcompose.domain.manager.LocalUserManager

class SaveAppEntry(
private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}
