package com.pdm0126.foodspot_00404425.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay

import com.pdm0126.foodspot_00404425.screens.detail.RestaurantDetailScreen
import com.pdm0126.foodspot_00404425.screens.home.RestaurantListScreen


@Composable
fun AppNavigation() {

    val backStack = remember { mutableStateListOf<Any>(Routes.Home) }

    NavDisplay(
        backStack = backStack,
        onBack = {
            if (backStack.size > 1) backStack.removeAt(backStack.size - 1)
        },
        entryProvider = entryProvider {

            entry<Routes.Home> {
                RestaurantListScreen(
                    onRestaurantClick = { restaurantId ->
                        backStack.add(Routes.RestaurantDetail(restaurantId))
                    }
                )
            }

            entry<Routes.RestaurantDetail> { route ->
                RestaurantDetailScreen(restaurantId = route.restaurantId)
            }


        }
    )
}
