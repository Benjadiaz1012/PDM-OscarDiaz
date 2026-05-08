package com.pdm0126.laboratorio03

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


sealed class Routes : NavKey {
    @Serializable
    data object Home : Routes()

    @Serializable
    data object Lista : Routes()

    @Serializable
    data object Sensores : Routes()
}

