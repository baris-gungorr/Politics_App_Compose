package com.barisgungorr.newsappcompose.data.manager

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.barisgungorr.newsappcompose.domain.manager.LocalUserManager
import com.barisgungorr.newsappcompose.util.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserImplementation(
    private val context : Context
): LocalUserManager {

        override suspend fun saveAppEntry() {
            context.dataStore.edit { settings ->
                settings[PreferencesKeys.APP_ENTRY] = true
            }
        }

        override fun readAppEntry(): Flow<Boolean> {
            return context.dataStore.data.map { preferences ->
                preferences[PreferencesKeys.APP_ENTRY] ?: false
            }
        }
}
private val Context.dataStore by preferencesDataStore(Constants.USER_SETTINGS)

private object PreferencesKeys {

    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)

}