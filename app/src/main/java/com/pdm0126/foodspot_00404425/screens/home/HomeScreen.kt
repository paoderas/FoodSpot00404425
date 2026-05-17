package com.pdm0126.foodspot_00404425.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantListScreen(viewModel: HomeViewModel = viewModel(),
                         onSearchClick: () -> Unit,
                         onRestaurantClick: (Int)-> Unit){
    val groupedRestaurants by viewModel.groupedRestaurants.collectAsState()
    val loading by viewModel.loading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadRestaurants()
    }


        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("FoodSpot") },
                    actions = {
                        IconButton(onClick = onSearchClick) {
                            Icon(Icons.Default.Search, contentDescription = "Buscar")
                        }
                    }
                )
            },


        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                LazyColumn {
                    groupedRestaurants.forEach { (category, restaurantsInCategory) ->
                        item {
                            AssistChip(
                                onClick = { },
                                label = { Text(category) }
                            )
                        }
                        item {
                            LazyRow {
                                items(restaurantsInCategory) { restaurant ->
                                    Card(
                                        onClick = { onRestaurantClick(restaurant.id) },
                                        modifier = Modifier
                                            .padding(8.dp)
                                            .width(150.dp)

                                    ) {
                                        Column {
                                            AsyncImage(
                                                model = restaurant.imageUrl,
                                                contentDescription = restaurant.name,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(120.dp),
                                                contentScale = ContentScale.Crop
                                            )
                                            Text(restaurant.name)
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

@Composable
fun FilledButtonExample(
    category: String,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        modifier = Modifier.padding(16.dp)
    ) {

        Text(
            text = category,
            style = MaterialTheme.typography.titleLarge
        )

    }
}