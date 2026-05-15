package com.pdm0126.foodspot_00404425.screens.home

import androidx.compose.ui.graphics.Color
import android.provider.CalendarContract.Instances.query
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.mutableStateOf



@OptIn(ExperimentalMaterial3Api::class)
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


        var presses by remember { mutableIntStateOf(0) }

        Scaffold(
            topBar = {
                val textFieldState = rememberTextFieldState()
                var query by remember { mutableStateOf("") }

                val filteredRestaurants = restaurants.filter {
                    it.name.contains(query, ignoreCase = true)
                }
                    .take(5)
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),

                    title = {
                        Text("")

                    }



                )
                CustomizableSearchBar(
                    query = query,

                    onQueryChange = {
                        query = it
                    },

                    onSearch = {

                    },

                    searchResults = filteredRestaurants.map { it.name },

                    onResultClick = { selectedRestaurant ->
                        query = selectedRestaurant
                    }
                )


            },

            bottomBar = {

                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary,
                ) {


                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { presses++ }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {


                LazyColumn {

                    val groupedRestaurants =
                        restaurants.flatMap { restaurant ->
                            restaurant.categories.map { category ->
                                category to restaurant
                            }
                        }.groupBy(
                            keySelector = { it.first },
                            valueTransform = { it.second }
                        )

                    groupedRestaurants.forEach { (category, restaurantsInCategory) ->

                        item {

                            FilledButtonExample(
                                category = category,
                                onClick = {

                                }
                            )

                        }

                        items(restaurantsInCategory) { restaurant ->

                            Text(
                                text = restaurant.name,
                                modifier = Modifier.padding(horizontal = 16.dp)
                            )

                        }
                    }
                }


                }

            }
        }



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomizableSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    searchResults: List<String>,
    onResultClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    // Customization options
    placeholder: @Composable () -> Unit = { Text("Search") },
    leadingIcon: @Composable (() -> Unit)? = { Icon(Icons.Default.Search, contentDescription = "Search") },
    trailingIcon: @Composable (() -> Unit)? = null,
    supportingContent: (@Composable (String) -> Unit)? = null,
    leadingContent: (@Composable () -> Unit)? = null,
) {
    // Track expanded state of search bar
    var expanded by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier
            .fillMaxWidth()
            .semantics { isTraversalGroup = true }
    ) {
        SearchBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .semantics { traversalIndex = 0f },
            inputField = {
                // Customizable input field implementation
                SearchBarDefaults.InputField(
                    query = query,
                    onQueryChange = onQueryChange,
                    onSearch = {
                        onSearch(query)
                        expanded = false
                    },
                    expanded = expanded,
                    onExpandedChange = { expanded = it },
                    placeholder = placeholder,
                    leadingIcon = leadingIcon,
                    trailingIcon = trailingIcon
                )
            },
            expanded = expanded,
            onExpandedChange = { expanded = it },
        ) {
            // Show search results in a lazy column for better performance
            LazyColumn {
                items(count = searchResults.size) { index ->
                    val resultText = searchResults[index]
                    ListItem(
                        headlineContent = { Text(resultText) },
                        supportingContent = supportingContent?.let { { it(resultText) } },
                        leadingContent = leadingContent,
                        colors = ListItemDefaults.colors(containerColor = Color.Transparent),
                        modifier = Modifier
                            .clickable {
                                onResultClick(resultText)
                                expanded = false
                            }
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 4.dp)
                    )
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