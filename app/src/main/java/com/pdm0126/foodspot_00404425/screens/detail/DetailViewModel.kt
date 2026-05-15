package com.pdm0126.foodspot_00404425.screens.detail

import android.view.View
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.pdm0126.foodspot_00404425.data.RestaurantRepositoryImpl
import com.pdm0126.foodspot_00404425.model.Restaurant
import kotlinx.coroutines.launch
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RestaurantDetailViewModel: ViewModel() {
    //De dónde traigo los datos
    private val repository = RestaurantRepositoryImpl()

    private val _restaurant = mutableStateOf<Restaurant?>(null)
    val restaurant: State<Restaurant?> = _restaurant

    fun loadRestaurant(restaurantId: Int) {
        viewModelScope.launch {
            val restaurants = repository.getRestaurants()
            _restaurant.value = restaurants.find ({ it.id == restaurantId })

        }
    }

}