package com.pdm0126.foodspot_00404425.screens.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RestaurantListScreen(viewModel: HomeViewModel = viewModel()){
    val restaurants by viewModel.restaurants.collectAsState()
    val loading by viewModel.loading.collectAsState()
/*
    if(loading) {
        CircularProgressIndicator()
        return
    }

 */
    LaunchedEffect(Unit) {
        viewModel.loadRestaurants()
    }
    LazyColumn() {
        items(restaurants) { restaurant ->
            Text("${restaurant.name}")

        }
    }

}