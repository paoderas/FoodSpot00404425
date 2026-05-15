package com.pdm0126.foodspot_00404425

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.pdm0126.foodspot_00404425.data.RestaurantRepository
import com.pdm0126.foodspot_00404425.data.RestaurantRepositoryImpl
import com.pdm0126.foodspot_00404425.navigation.AppNavigation
import com.pdm0126.foodspot_00404425.screens.home.HomeViewModel
import com.pdm0126.foodspot_00404425.screens.home.RestaurantListScreen
import com.pdm0126.foodspot_00404425.ui.theme.FoodSpot_00404425Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            FoodSpot_00404425Theme {
                AppNavigation()
            }
        }
    }
}

