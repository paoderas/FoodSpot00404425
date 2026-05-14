package com.pdm0126.foodspot_00404425.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.foodspot_00404425.data.RestaurantRepository
import com.pdm0126.foodspot_00404425.data.RestaurantRepositoryImpl
import com.pdm0126.foodspot_00404425.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.collections.emptyList

class HomeViewModel: ViewModel() {
    val  restaurantRepository: RestaurantRepository = RestaurantRepositoryImpl()

    private val _restaurants = MutableStateFlow<List<Restaurant>>(emptyList())
    val restaurants = _restaurants.asStateFlow()


    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    fun loadRestaurants() {
        viewModelScope.launch {
            _loading.value = true
            _restaurants.value = restaurantRepository.getRestaurants()
            _loading.value = false
        }
    }
}