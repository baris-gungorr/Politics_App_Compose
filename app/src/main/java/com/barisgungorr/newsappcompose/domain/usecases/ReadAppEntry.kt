package com.barisgungorr.newsappcompose.domain.usecases

import com.barisgungorr.newsappcompose.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend fun invoke() : Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}