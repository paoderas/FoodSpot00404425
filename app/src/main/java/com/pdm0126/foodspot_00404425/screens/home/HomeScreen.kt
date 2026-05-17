package com.pdm0126.foodspot_00404425.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantListScreen(
    viewModel: HomeViewModel = viewModel(),
    onSearchClick: () -> Unit,
    onRestaurantClick: (Int) -> Unit
) {
    val groupedRestaurants by viewModel.groupedRestaurants.collectAsState()
    val loading by viewModel.loading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadRestaurants()
    }


    Scaffold(
        containerColor = Color(0xFFF5F5F5), topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFFFF6B00)
            ), title = {
                Column {
                    Text(
                        text = "Hola! 👋",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White
                    )
                    Text(
                        text = "FoodSpot",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White
                    )
                }
            }, actions = {
                IconButton(onClick = onSearchClick) {
                    Icon(
                        Icons.Default.Search, contentDescription = "Buscar", tint = Color.White
                    )
                }
            })
        }) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            groupedRestaurants.forEach { (category, restaurantsInCategory) ->

                // Título de categoría
                item {
                    Text(
                        text = category,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(0xFFFF6B00),
                        modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 4.dp)
                    )
                }

                // Fila de restaurantes
                item {
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(restaurantsInCategory) { restaurant ->
                            Card(
                                onClick = { onRestaurantClick(restaurant.id) },
                                modifier = Modifier.width(160.dp),
                                shape = RoundedCornerShape(16.dp),
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White)
                            ) {
                                Column {
                                    Box {
                                        AsyncImage(
                                            model = restaurant.imageUrl,
                                            contentDescription = restaurant.name,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(110.dp),
                                            contentScale = ContentScale.Crop
                                        )
                                        // Badge de categoría
                                        Box(
                                            modifier = Modifier
                                                .padding(6.dp)
                                                .background(
                                                    Color(0xFFFF6B00), RoundedCornerShape(8.dp)
                                                )
                                                .padding(horizontal = 6.dp, vertical = 2.dp)
                                        ) {
                                            Text(
                                                text = category,
                                                color = Color.White,
                                                style = MaterialTheme.typography.labelSmall
                                            )
                                        }
                                    }
                                    Column(modifier = Modifier.padding(10.dp)) {
                                        Text(
                                            text = restaurant.name,
                                            style = MaterialTheme.typography.bodyMedium,
                                            maxLines = 1
                                        )
                                        Text(
                                            text = restaurant.description,
                                            style = MaterialTheme.typography.bodySmall,
                                            color = Color.Gray,
                                            maxLines = 2
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

