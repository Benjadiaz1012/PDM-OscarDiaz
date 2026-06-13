package com.pdm0126.laboratorio05

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.laboratorio05.screens.homeScreen.Home
import com.pdm0126.laboratorio05.screens.mainScreen.MainScreen

@Composable
fun MainNavigation(){
    val backStack = rememberNavBackStack(Route.Home)
    NavDisplay(
        backStack = backStack,
        onBack = {backStack.removeLastOrNull()},
        entryProvider = entryProvider {
            entry<Route.Home> {
                Home(onNext ={backStack.add(Route.MainScreen)})
            }
            entry<Route.MainScreen> {
                MainScreen(onNext ={backStack.removeLastOrNull()})
            }
        }
    )
}