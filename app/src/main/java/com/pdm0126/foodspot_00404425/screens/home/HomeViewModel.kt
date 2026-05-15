package com.pdm0126.foodspot_00404425.screens.home

import androidx.lifecycle.ViewModel
import com.pdm0126.foodspot_00404425.data.RestaurantRepository
import com.pdm0126.foodspot_00404425.data.RestaurantRepositoryImpl
import com.pdm0126.foodspot_00404425.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel: ViewModel() {
    val restaurantRepository: RestaurantRepository = RestaurantRepositoryImpl()

    private val _restaurants = MutableStateFlow<List<Restaurant>>(emptyList())
    private val _groupedRestaurants = MutableStateFlow<Map<String, List<Restaurant>>>(emptyMap())
    val groupedRestaurants = _groupedRestaurants.asStateFlow()
    val restaurants = _restaurants.asStateFlow()


    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    suspend fun loadRestaurants() {
        _restaurants.value = restaurantRepository.getRestaurants()
        _groupedRestaurants.value = _restaurants.value
            .flatMap { restaurant ->
                restaurant.categories.map { category -> category to restaurant }
            }
            .groupBy(
                keySelector = { it.first },
                valueTransform = { it.second }
            )
    }
}
