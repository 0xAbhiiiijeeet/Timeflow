package com.abhijeet.timeflow.Viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhijeet.timeflow.Data.Model.BodyFont
import com.abhijeet.timeflow.Data.Model.ColorSpecVersion
import com.abhijeet.timeflow.Data.Model.ContrastLevel
import com.abhijeet.timeflow.Data.Model.ThemePreferences
import com.abhijeet.timeflow.Data.Model.ThemeType
import com.abhijeet.timeflow.Data.Repo.DataStoreRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val dataStoreRepo: DataStoreRepo,
) : ViewModel() {

    val themePreferences: StateFlow<ThemePreferences> = dataStoreRepo.readThemePreferences()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = ThemePreferences(),
        )

    fun setThemeType(value: ThemeType) {
        viewModelScope.launch { dataStoreRepo.saveThemeType(value) }
    }


    fun setDynamicTheme(enabled: Boolean) {
        viewModelScope.launch {
            dataStoreRepo.saveDynamicTheme(enabled)
            if (enabled) dataStoreRepo.saveSeedColor(null)
        }
    }

    fun setAmoledMode(value: Boolean){
        viewModelScope.launch {
            dataStoreRepo.saveAmoled(value)
        }
    }

    fun setSeedColor(value: Long?) {
        viewModelScope.launch { dataStoreRepo.saveSeedColor(value) }
    }

    fun setPaletteStyle(value: String) {
        viewModelScope.launch { dataStoreRepo.savePaletteStyle(value) }
    }

    fun setColorSpecVersion(value: ColorSpecVersion) {
        viewModelScope.launch { dataStoreRepo.saveColorSpecVersion(value) }
    }

    fun setContrastLevel(value: ContrastLevel) {
        viewModelScope.launch { dataStoreRepo.saveContrastLevel(value) }
    }

    fun setBodyFont(value: BodyFont) {
        viewModelScope.launch { dataStoreRepo.saveBodyFont(value) }
    }
}

