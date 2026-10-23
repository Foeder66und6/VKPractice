package com.example.vkpractice

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.vkpractice.apps
import com.example.vkpractice.appdetails.AppDetailsScreen
import kotlinx.serialization.Serializable

class Navigation {
}
@Serializable
data object ListDestination//# objext
@Serializable
data class AppDetailsDestination(val index: Int)
@Composable
fun RootNavHost(modifier: Modifier) {
    val navContr = rememberNavController()

    NavHost(navContr, ListDestination) {
        composable<ListDestination>() {
            AppList(apps, {index: Int -> navContr.navigate(AppDetailsDestination(index))}, modifier)
        }
        composable<AppDetailsDestination> { backStackEntry ->
            val routeInfo = backStackEntry.toRoute<AppDetailsDestination>()
            AppDetailsScreen({navContr.navigate(ListDestination)}, {navContr.popBackStack()}, routeInfo.index)
        }
    }
//    navHost
}