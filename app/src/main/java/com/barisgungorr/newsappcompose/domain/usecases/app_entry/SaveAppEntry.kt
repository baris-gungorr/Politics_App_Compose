package com.barisgungorr.newsappcompose.domain.usecases.app_entry

import com.barisgungorr.newsappcompose.domain.manager.LocalUserManager

class SaveAppEntry(
private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}
