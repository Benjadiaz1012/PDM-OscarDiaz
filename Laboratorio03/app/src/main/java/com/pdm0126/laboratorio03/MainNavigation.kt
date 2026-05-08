package com.pdm0126.laboratorio03

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.laboratorio03.Screens.Home
import com.pdm0126.laboratorio03.Screens.Lista
import com.pdm0126.laboratorio03.Screens.Sensores

@Composable
fun Navigation() {
    val backStack = rememberNavBackStack(Routes.Home)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Home> {
                Home(
                    onNext = {
                        backStack.add(Routes.Lista)
                    }
                    ,onAdvance = {
                        backStack.add(Routes.Sensores)
                    }
                )
            }
            entry<Routes.Lista> {
                Lista(onBack = { backStack.removeLastOrNull() })
            }
            entry<Routes.Sensores> {
                Sensores(onBack = {backStack.removeLastOrNull()})
            }
        }
    )
}