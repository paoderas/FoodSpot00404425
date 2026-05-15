package com.pdm0126.foodspot_00404425.screens.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.pdm0126.foodspot_00404425.model.Restaurant

@Composable
fun RestaurantDetailScreen(restaurantId: Int) {
    // Por ahora solo para que no truene
    Text(text = "Restaurante $restaurantId")
}