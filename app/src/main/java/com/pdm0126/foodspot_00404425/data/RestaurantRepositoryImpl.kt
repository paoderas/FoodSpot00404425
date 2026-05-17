package com.pdm0126.foodspot_00404425.data

import com.pdm0126.foodspot_00404425.model.Dish
import com.pdm0126.foodspot_00404425.model.Restaurant
import kotlinx.coroutines.delay

class RestaurantRepositoryImpl: RestaurantRepository {
    private val sampleRestaurants = listOf(

        Restaurant(
            id = 1,
            name = "Joe's Pizza",
            description = "Famosa pizzería neoyorquina conocida por sus slices clásicas.",
            imageUrl = "https://images.unsplash.com/photo-1513104890138-7c749659a591?q=80&w=1200",
            categories = listOf("Italiana", "Pizzas"),
            menu = listOf(
                Dish(
                    id = 1,
                    name = "Classic Cheese Slice",
                    description = "Pizza clásica de queso estilo Nueva York",
                    imageUrl = "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?q=80&w=781"
                ),
                Dish(
                    id = 2,
                    name = "Pepperoni Pizza",
                    description = "Pepperoni y mozzarella derretida",
                    imageUrl = "https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?q=80&w=1176"
                ),
                Dish(
                    id = 3,
                    name = "Garlic Knots",
                    description = "Finos knots con mantequilla de ajo",
                    imageUrl = "https://images.unsplash.com/photo-1573821663912-569905455b1c?q=80&w=1200"
                )
            )
        ),

        Restaurant(
            id = 2,
            name = "Katz's Delicatessen",
            description = "Icónico deli de Nueva York famoso por sus sandwiches.",
            imageUrl = "https://images.unsplash.com/photo-1552566626-52f8b828add9?q=80&w=1200",
            categories = listOf("Deli", "Sandwiches"),
            menu = listOf(
                Dish(
                    id = 4,
                    name = "Pastrami Sandwich",
                    description = "Sandwich clásico de pastrami",
                    imageUrl = "https://images.unsplash.com/photo-1528735602780-2552fd46c7af?q=80&w=1200"
                ),
                Dish(
                    id = 5,
                    name = "Reuben Sandwich",
                    description = "Corned beef, queso suizo y sauerkraut",
                    imageUrl = "https://images.unsplash.com/photo-1539252554453-80ab65ce3586?q=80&w=1200"
                ),
                Dish(
                    id = 6,
                    name = "Matzo Ball Soup",
                    description = "Soup de Matza receta del chef Akin Akinozu",
                    imageUrl = "https://images.unsplash.com/photo-1547592166-23ac45744acd?q=80&w=1200"
                ),
                Dish(
                    id = 7,
                    name = "Cheesecake",
                    description = "Cheesecake estilo Nueva York con salsa de frutos rojos",
                    imageUrl = "https://images.unsplash.com/photo-1533134242443-d4fd215305ad?q=80&w=1200"
                )
            )
        ),

        Restaurant(
            id = 3,
            name = "Shake Shack",
            description = "Cadena popular de hamburguesas nacida en NYC.",
            imageUrl = "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?q=80&w=1200",
            categories = listOf("Hamburguesas", "Fast Food"),
            menu = listOf(
                Dish(
                    id = 8,
                    name = "ShackBurger",
                    description = "Hamburguesa con queso y salsa especial",
                    imageUrl = "https://images.unsplash.com/photo-1550547660-d9450f859349?q=80&w=1200"
                ),
                Dish(
                    id = 9,
                    name = "Crinkle Cut Fries",
                    description = "Papas fritas onduladas",
                    imageUrl = "https://images.unsplash.com/photo-1573080496219-bb080dd4f877?q=80&w=1200"
                ),
                Dish(
                    id = 10,
                    name = "Cookies & Cream Shake",
                    description = "Malteada cremosa con galletas y crema",
                    imageUrl = "https://images.unsplash.com/photo-1579954115563-e72bf1381629?q=80&w=1200"
                )
            )
        ),

        Restaurant(
            id = 4,
            name = "Lombardi's",
            description = "Considerada la primera pizzería de Estados Unidos.",
            imageUrl = "https://images.unsplash.com/photo-1513104890138-7c749659a591?q=80&w=1200",
            categories = listOf("Italiana", "Pizzas"),
            menu = listOf(
                Dish(
                    id = 11,
                    name = "Coal Oven Pizza",
                    description = "Pizza cocinada en horno de carbón",
                    imageUrl = "https://images.unsplash.com/photo-1594007654729-407eedc4be65?q=80&w=1200"
                ),
                Dish(
                    id = 12,
                    name = "White Pizza",
                    description = "Pizza blanca con ricotta y mozzarella",
                    imageUrl = "https://images.unsplash.com/photo-1571407970349-bc81e7e96d47?q=80&w=1200"
                ),
                Dish(
                    id = 13,
                    name = "Margherita Pizza",
                    description = "Pizza clásica con tomate, mozzarella y albahaca fresca",
                    imageUrl = "https://images.unsplash.com/photo-1604382355076-af4b0eb60143?q=80&w=1200"
                )
            )
        ),

        Restaurant(
            id = 5,
            name = "Peter Luger Steak House",
            description = "Legendario steakhouse de Brooklyn.",
            imageUrl = "https://images.unsplash.com/photo-1544025162-d76694265947?q=80&w=1200",
            categories = listOf("Steakhouse", "Carnes"),
            menu = listOf(
                Dish(
                    id = 14,
                    name = "Porterhouse Steak",
                    description = "Corte premium para compartir",
                    imageUrl = "https://images.unsplash.com/photo-1600891964092-4316c288032e?q=80&w=1200"
                ),
                Dish(
                    id = 15,
                    name = "German Fried Potatoes",
                    description = "Papas fritas estilo alemán",
                    imageUrl = "https://images.unsplash.com/photo-1518013431117-eb1465fa5752?q=80&w=1200"
                ),
                Dish(
                    id = 16,
                    name = "Creamed Spinach",
                    description = "Espinaca cremosa clásica como acompañamiento",
                    imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?q=80&w=1200"
                )
            )
        ),

        Restaurant(
            id = 6,
            name = "Levain Bakery",
            description = "Panadería famosa por sus gigantes cookies.",
            imageUrl = "https://images.unsplash.com/photo-1509440159596-0249088772ff?q=80&w=1200",
            categories = listOf("Bakery", "Postres"),
            menu = listOf(
                Dish(
                    id = 17,
                    name = "Chocolate Chip Walnut Cookie",
                    description = "Cookie gruesa con chocolate y nueces",
                    imageUrl = "https://images.unsplash.com/photo-1499636136210-6f4ee915583e?q=80&w=1200"
                ),
                Dish(
                    id = 18,
                    name = "Dark Chocolate Cookie",
                    description = "Cookie de chocolate oscuro",
                    imageUrl = "https://images.unsplash.com/photo-1558961363-fa8fdf82db35?q=80&w=1200"
                ),
                Dish(
                    id = 19,
                    name = "Blueberry Muffin",
                    description = "Muffin esponjoso con arándanos frescos",
                    imageUrl = "https://images.unsplash.com/photo-1607958996333-41aef7caefaa?q=80&w=1200"
                )
            )
        ),

        Restaurant(
            id = 7,
            name = "The Halal Guys",
            description = "Famoso food cart de comida halal en Manhattan.",
            imageUrl = "https://images.unsplash.com/photo-1544025162-d76694265947?q=80&w=1200",
            categories = listOf("Halal", "Middle Eastern"),
            menu = listOf(
                Dish(
                    id = 20,
                    name = "Chicken Over Rice",
                    description = "Pollo con arroz y salsa blanca",
                    imageUrl = "https://images.unsplash.com/photo-1512058564366-18510be2db19?q=80&w=1200"
                ),
                Dish(
                    id = 21,
                    name = "Gyro Platter",
                    description = "Gyro servido con arroz y vegetales",
                    imageUrl = "https://images.unsplash.com/photo-1529006557810-274b9b2fc783?q=80&w=1200"
                ),
                Dish(
                    id = 22,
                    name = "Falafel Sandwich",
                    description = "Falafel crujiente con vegetales frescos y salsa tahini",
                    imageUrl = "https://images.unsplash.com/photo-1562967914-608f82629710?q=80&w=1200"
                )
            )
        ),

        Restaurant(
            id = 8,
            name = "Momofuku Noodle Bar",
            description = "Popular restaurante asiático fundado por David Chang.",
            imageUrl = "https://images.unsplash.com/photo-1517248135467-4c7edcad34c4?q=80&w=1200",
            categories = listOf("Asiática", "Ramen"),
            menu = listOf(
                Dish(
                    id = 23,
                    name = "Pork Ramen",
                    description = "Ramen con cerdo y huevo marinado",
                    imageUrl = "https://images.unsplash.com/photo-1617093727343-374698b1b08d?q=80&w=1200"
                ),
                Dish(
                    id = 24,
                    name = "Spicy Noodles",
                    description = "Fideos picantes estilo coreano",
                    imageUrl = "https://images.unsplash.com/photo-1569718212165-3a8278d5f624?q=80&w=1200"
                ),
                Dish(
                    id = 25,
                    name = "Bao Buns",
                    description = "Panes al vapor rellenos de cerdo y vegetales",
                    imageUrl = "https://images.unsplash.com/photo-1563245372-f21724e3856d?q=80&w=1200"
                )
            )
        ),

        Restaurant(
            id = 9,
            name = "Magnolia Bakery",
            description = "Panadería famosa por cupcakes y banana pudding.",
            imageUrl = "https://images.unsplash.com/photo-1486427944299-d1955d23e34d?q=80&w=1200",
            categories = listOf("Bakery", "Postres"),
            menu = listOf(
                Dish(
                    id = 26,
                    name = "Vanilla Cupcake",
                    description = "Cupcake clásico con buttercream",
                    imageUrl = "https://images.unsplash.com/photo-1576618148400-f54bed99fcfd?q=80&w=1200"
                ),
                Dish(
                    id = 27,
                    name = "Banana Pudding",
                    description = "Postre icónico de la casa",
                    imageUrl = "https://images.unsplash.com/photo-1488477181946-6428a0291777?q=80&w=1200"
                ),
                Dish(
                    id = 28,
                    name = "Red Velvet Cupcake",
                    description = "Cupcake red velvet con frosting de queso crema",
                    imageUrl = "https://images.unsplash.com/photo-1614707267537-b85aaf00c4b7?q=80&w=1200"
                )
            )
        ),

        Restaurant(
            id = 10,
            name = "Russ & Daughters",
            description = "Clásico restaurante especializado en bagels y salmón.",
            imageUrl = "https://images.unsplash.com/photo-1525351484163-7529414344d8?q=80&w=1200",
            categories = listOf("Breakfast", "Bagels"),
            menu = listOf(
                Dish(
                    id = 29,
                    name = "Bagel with Lox",
                    description = "Bagel con salmón ahumado y queso crema",
                    imageUrl = "https://images.unsplash.com/photo-1559058789-672da06263d8?q=80&w=1200"
                ),
                Dish(
                    id = 30,
                    name = "Smoked Salmon Plate",
                    description = "Salmón ahumado servido con acompañamientos",
                    imageUrl = "https://images.unsplash.com/photo-1515003197210-e0cd71810b5f?q=80&w=1200"
                ),
                Dish(
                    id = 31,
                    name = "Everything Bagel",
                    description = "Bagel clásico con semillas y queso crema artesanal",
                    imageUrl = "https://images.unsplash.com/photo-1608198093002-ad4e005484ec?q=80&w=1200"
                )
            )
        ),
        Restaurant(
            id = 11,
            name = "Turkish Kitchen",
            description = "Restaurante turco reconocido por sus platos tradicionales y ambiente elegante.",
            imageUrl = "https://images.unsplash.com/photo-1544025162-d76694265947?q=80&w=1200",
            categories = listOf("Turca", "Mediterránea"),
            menu = listOf(
                Dish(
                    id = 32,
                    name = "Adana Kebab",
                    description = "Kebab picante servido con arroz y vegetales",
                    imageUrl = "https://images.unsplash.com/photo-1529006557810-274b9b2fc783?q=80&w=1200"
                ),
                Dish(
                    id = 33,
                    name = "Baklava",
                    description = "Postre tradicional turco con pistachos",
                    imageUrl = "https://images.unsplash.com/photo-1519676867240-f03562e64548?q=80&w=1200"
                ),
                Dish(
                    id = 34,
                    name = "Lentil Soup",
                    description = "Sopa turca de lentejas con especias tradicionales",
                    imageUrl = "https://images.unsplash.com/photo-1547592180-85f173990554?q=80&w=1200"
                )
            )
        ),
        Restaurant(
            id = 12,
            name = "Sip Sak",
            description = "Popular restaurante turco ubicado en Manhattan.",
            imageUrl = "https://images.unsplash.com/photo-1559339352-11d035aa65de?q=80&w=1200",
            categories = listOf("Turca", "Kebabs"),
            menu = listOf(
                Dish(
                    id = 35,
                    name = "Lamb Shish Kebab",
                    description = "Brochetas de cordero marinadas",
                    imageUrl = "https://images.unsplash.com/photo-1544025162-d76694265947?q=80&w=1200"
                ),
                Dish(
                    id = 36,
                    name = "Turkish Tea",
                    description = "Té negro tradicional turco",
                    imageUrl = "https://images.unsplash.com/photo-1495474472287-4d71bcdd2085?q=80&w=1200"
                ),
                Dish(
                    id = 37,
                    name = "Chicken Doner",
                    description = "Pollo sazonado servido con pan pita y salsa de yogur",
                    imageUrl = "https://images.unsplash.com/photo-1529006557810-274b9b2fc783?q=80&w=1200"
                )
            )
        ),

    )

    override suspend fun getRestaurants(): List<Restaurant> {
        delay(2000)
        return sampleRestaurants
    }
}