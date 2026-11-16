package com.example.vkpractice

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
//import com.example.vkpractice.appdetails.AppDetailsScreen
import com.example.vkpractice.presentation.AppList
import com.example.vkpractice.presentation.AppScreen
import kotlinx.serialization.Serializable

class Navigation {
}
@Serializable
data object ListDestination//# objext
@Serializable
data class AppDetailsDestination(val id: String)
@Composable
fun RootNavHost(modifier: Modifier) {
    val navContr = rememberNavController()

    NavHost(navContr, ListDestination) {
        composable<ListDestination>() {
            AppList({id: String -> navContr.navigate(AppDetailsDestination(id))}, modifier)////val index: Int index: Int -> navContr.navigate(AppDetailsDestination(index)) is
        }
        composable<AppDetailsDestination> { backStackEntry ->
            val routeInfo = backStackEntry.toRoute<AppDetailsDestination>()
            AppScreen(routeInfo.id, modifier)//м//AppDetailsScreen({navContr.navigate(ListDestination)}, {navContr.popBackStack()}, routeInfo.index) AppDetails() sDs
        }
    }
//    navHost
}