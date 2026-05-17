package com.pdm0126.foodspot_00404425.screens.search

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

class SearchViewModel : ViewModel() {
    private val repository: RestaurantRepository = RestaurantRepositoryImpl()

    //Trayendo los restaurantes
    private var allRestaurants: List<Restaurant> = emptyList()

    private val _results = MutableStateFlow<List<Restaurant>>(emptyList())
    val results = _results.asStateFlow()
    private val _query = MutableStateFlow("")
    val query = _query.asStateFlow()

    fun loadRestaurants() {
        viewModelScope.launch {
            allRestaurants = repository.getRestaurants()
        }
    }

    fun onQueryChange(newQuery: String) {
        _query.value = newQuery
        filterRestaurants(newQuery)
    }

    private fun filterRestaurants(query: String) {
        if (query.isBlank()) {
            _results.value = emptyList()
            return

        }
        val lowerQuery = query.lowercase()
        _results.value = allRestaurants.filter { restaurant ->
            restaurant.name.lowercase().contains(lowerQuery) ||
                    restaurant.menu.any { dish ->
                        dish.name.lowercase().contains(lowerQuery)
                    }
        }
    }


}