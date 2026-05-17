package com.pdm0126.foodspot_00404425.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay

import com.pdm0126.foodspot_00404425.screens.detail.RestaurantDetailScreen
import com.pdm0126.foodspot_00404425.screens.home.RestaurantListScreen
import com.pdm0126.foodspot_00404425.screens.search.SearchBarScreen


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
                    },
                    onSearchClick = {
                        backStack.add(Routes.Searchbar)
                    }
                )
            }
            entry<Routes.RestaurantDetail> { route ->
                RestaurantDetailScreen(
                    restaurantId = route.restaurantId,
                    onBack = { backStack.removeAt(backStack.size - 1) }
                )
            }
            entry<Routes.Searchbar> {
                SearchBarScreen(
                    onRestaurantClick = { restaurantId ->
                        backStack.add(Routes.RestaurantDetail(restaurantId))},
                        onBack = { backStack.removeAt(backStack.size - 1) }

                )


            }




        }
    )
}
