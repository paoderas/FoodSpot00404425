package com.pdm0126.foodspot_00404425.data

import com.pdm0126.foodspot_00404425.model.Restaurant

interface RestaurantRepository {
    suspend fun getRestaurants(): List<Restaurant>
}