package com.pdm0126.foodspot_00404425.navigation

sealed class Routes {
    object Home: Routes()

    data class RestaurantDetail(val restaurantId: Int): Routes()
}