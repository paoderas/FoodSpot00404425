package com.pdm0126.foodspot_00404425

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pdm0126.foodspot_00404425.navigation.AppNavigation
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

