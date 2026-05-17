package com.pdm0126.foodspot_00404425.screens.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.foodspot_00404425.data.RestaurantRepository
import com.pdm0126.foodspot_00404425.data.RestaurantRepositoryImpl
import com.pdm0126.foodspot_00404425.model.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RestaurantDetailViewModel: ViewModel() {
    //De dónde traigo los datos
    private val repository: RestaurantRepository = RestaurantRepositoryImpl()

    private val _restaurant = MutableStateFlow<Restaurant?>(null)
    val restaurant = _restaurant.asStateFlow()



    fun loadRestaurant(restaurantId: Int) {
        viewModelScope.launch {
            _restaurant.value = null
            val restaurants = repository.getRestaurants()
            _restaurant.value = restaurants.find { it.id == restaurantId }


        }
    }

}