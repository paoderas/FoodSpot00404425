package com.pdm0126.foodspot_00404425.data

import com.pdm0126.foodspot_00404425.model.Dish
import com.pdm0126.foodspot_00404425.model.Restaurant
import kotlinx.coroutines.delay

class RestaurantRepositoryImpl : RestaurantRepository {
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
            imageUrl = "https://www.seriouseats.com/thmb/zMLKHp1RrT78yQVpNMJE_roIujQ=/1500x1125/filters:no_upscale():max_bytes(150000):strip_icc()/__opt__aboutcom__coeus__resources__content_migration__serious_eats__seriouseats.com__2018__10__20181015-state-of-slice-lombardis-clay-williams-2e181b7a153d424abddd9e12efe95693.jpg",
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
            ),


        ),

        Restaurant(
            id = 13,
            name = "Sweetgreen",
            description = "Ensaladas frescas y bowls saludables.",
            imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?q=80&w=1200",
            categories = listOf("Saludable"),
            menu = listOf(
                Dish(id = 38, name = "Harvest Bowl", description = "Bowl con pollo, camote y arroz salvaje", imageUrl = "https://images.unsplash.com/photo-1540420773420-3366772f4999?q=80&w=1200"),
                Dish(id = 39, name = "Garden Salad", description = "Ensalada fresca de temporada", imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?q=80&w=1200")
            )
        ),
        Restaurant(
            id = 14,
            name = "Blue Bottle Coffee",
            description = "Cafetería de especialidad conocida por su café de origen.",
            imageUrl = "https://images.unsplash.com/photo-1495474472287-4d71bcdd2085?q=80&w=1200",
            categories = listOf("Bebidas", "Café"),
            menu = listOf(
                Dish(id = 40, name = "Single Origin Espresso", description = "Espresso de origen único", imageUrl = "https://images.unsplash.com/photo-1510591509098-f4fdc6d0ff04?q=80&w=1200"),
                Dish(id = 41, name = "Cold Brew", description = "Café frío preparado por 24 horas", imageUrl = "https://images.unsplash.com/photo-1461023058943-07fcbe16d735?q=80&w=1200")
            )
        ),
        Restaurant(
            id = 15,
            name = "Tacombi",
            description = "Tacos mexicanos auténticos en el corazón de NYC.",
            imageUrl = "https://images.unsplash.com/photo-1565299585323-38d6b0865b47?q=80&w=1200",
            categories = listOf("Mexicana", "Fast Food"),
            menu = listOf(
                Dish(id = 42, name = "Taco de Carnitas", description = "Taco con carnitas y salsa verde", imageUrl = "https://images.unsplash.com/photo-1551504734-5ee1c4a1479b?q=80&w=1200"),
                Dish(id = 43, name = "Quesadilla", description = "Quesadilla con queso Oaxaca", imageUrl = "https://images.unsplash.com/photo-1618040996337-56904b7850b9?q=80&w=1200")
            )
        ),
        Restaurant(
            id = 16,
            name = "Nobu",
            description = "Restaurante japonés de lujo fundado por Nobu Matsuhisa.",
            imageUrl = "https://images.unsplash.com/photo-1579871494447-9811cf80d66c?q=80&w=1200",
            categories = listOf("Japonesa", "Asiática"),
            menu = listOf(
                Dish(id = 44, name = "Black Cod Miso", description = "Bacalao negro marinado en miso", imageUrl = "https://images.unsplash.com/photo-1580822184713-fc5400e7fe10?q=80&w=1200"),
                Dish(id = 45, name = "Yellowtail Sashimi", description = "Sashimi de cola amarilla con jalapeño", imageUrl = "https://images.unsplash.com/photo-1617196034183-421b4040ed20?q=80&w=1200")
            )
        ),
        Restaurant(
            id = 17,
            name = "Dos Toros",
            description = "Burritos y bowls estilo californiano en NYC.",
            imageUrl = "https://images.unsplash.com/photo-1626700051175-6818013e1d4f?q=80&w=1200",
            categories = listOf("Mexicana"),
            menu = listOf(
                Dish(id = 46, name = "Burrito de Pollo", description = "Burrito con pollo, arroz y frijoles", imageUrl = "https://images.unsplash.com/photo-1626700051175-6818013e1d4f?q=80&w=1200"),
                Dish(id = 47, name = "Veggie Bowl", description = "Bowl vegetariano con guacamole", imageUrl = "https://images.unsplash.com/photo-1540420773420-3366772f4999?q=80&w=1200")
            )
        ),
        Restaurant(
            id = 18,
            name = "Juice Press",
            description = "Jugos prensados en frío y comida saludable.",
            imageUrl = "https://images.unsplash.com/photo-1622597467836-f3285f2131b8?q=80&w=1200",
            categories = listOf("Saludable", "Bebidas"),
            menu = listOf(
                Dish(id = 48, name = "Green Detox Juice", description = "Jugo de pepino, apio y manzana verde", imageUrl = "https://images.unsplash.com/photo-1622597467836-f3285f2131b8?q=80&w=1200"),
                Dish(id = 49, name = "Acai Bowl", description = "Bowl de acai con granola y frutas", imageUrl = "https://images.unsplash.com/photo-1590301157890-4810ed352733?q=80&w=1200")
            )
        ),
        Restaurant(
            id = 19,
            name = "Patsy's Pizzeria",
            description = "Pizzería italiana clásica de East Harlem desde 1933.",
            imageUrl = "https://images.unsplash.com/photo-1574071318508-1cdbab80d002?q=80&w=1200",
            categories = listOf("Pizzas"),
            menu = listOf(
                Dish(id = 50, name = "Fresh Tomato Pizza", description = "Pizza con tomate fresco y albahaca", imageUrl = "https://images.unsplash.com/photo-1593560708920-61dd98c46a4e?q=80&w=1200"),
                Dish(id = 51, name = "Sicilian Pizza", description = "Pizza gruesa estilo siciliano", imageUrl = "https://images.unsplash.com/photo-1571407970349-bc81e7e96d47?q=80&w=1200")
            )
        ),
        Restaurant(
            id = 20,
            name = "Di Fara Pizza",
            description = "Legendaria pizzería de Brooklyn con receta desde 1965.",
            imageUrl = "https://images.unsplash.com/photo-1513104890138-7c749659a591?q=80&w=1200",
            categories = listOf("Pizzas"),
            menu = listOf(
                Dish(id = 52, name = "Square Pizza", description = "Pizza cuadrada con queso importado", imageUrl = "https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?q=80&w=1200"),
                Dish(id = 53, name = "Classic Round Pizza", description = "Pizza redonda con salsa casera", imageUrl = "https://images.unsplash.com/photo-1604382355076-af4b0eb60143?q=80&w=1200")
            )
        ),
        Restaurant(
            id = 21,
            name = "Carbone",
            description = "Restaurante italiano de lujo con ambiente retro en Greenwich Village.",
            imageUrl = "https://images.unsplash.com/photo-1555396273-367ea4eb4db5?q=80&w=1200",
            categories = listOf("Italiana"),
            menu = listOf(
                Dish(id = 54, name = "Rigatoni Vodka", description = "Pasta rigatoni con salsa vodka cremosa", imageUrl = "https://images.unsplash.com/photo-1621996346565-e3dbc646d9a9?q=80&w=1200"),
                Dish(id = 55, name = "Veal Parmesan", description = "Ternera empanizada con salsa de tomate", imageUrl = "https://images.unsplash.com/photo-1574894709920-11b28e7367e3?q=80&w=1200")
            )
        ),
        Restaurant(
            id = 22,
            name = "L'Artusi",
            description = "Cocina italiana moderna con pasta hecha a mano.",
            imageUrl = "https://images.unsplash.com/photo-1414235077428-338989a2e8c0?q=80&w=1200",
            categories = listOf("Italiana"),
            menu = listOf(
                Dish(id = 56, name = "Tagliatelle al Ragù", description = "Pasta fresca con ragù de res", imageUrl = "https://images.unsplash.com/photo-1588013273468-315fd88ea34c?q=80&w=1200"),
                Dish(id = 57, name = "Branzino", description = "Lubina mediterránea a la parrilla", imageUrl = "https://images.unsplash.com/photo-1519708227418-c8fd9a32b7a2?q=80&w=1200")
            )
        ),
        Restaurant(
            id = 23,
            name = "Burger Joint",
            description = "Hamburguesería escondida dentro del Parker Hotel en Midtown.",
            imageUrl = "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?q=80&w=1200",
            categories = listOf("Hamburguesas"),
            menu = listOf(
                Dish(id = 58, name = "Classic Burger", description = "Hamburguesa clásica con lechuga y tomate", imageUrl = "https://images.unsplash.com/photo-1550547660-d9450f859349?q=80&w=1200"),
                Dish(id = 59, name = "Cheeseburger", description = "Hamburguesa doble con queso americano", imageUrl = "https://images.unsplash.com/photo-1586190848861-99aa4a171e90?q=80&w=1200")
            )
        ),
        Restaurant(
            id = 24,
            name = "J.G. Melon",
            description = "Clásico bar americano conocido por sus hamburguesas desde 1972.",
            imageUrl = "https://images.unsplash.com/photo-1466978913421-dad2ebd01d17?q=80&w=1200",
            categories = listOf("Hamburguesas", "Fast Food"),
            menu = listOf(
                Dish(id = 60, name = "Melon Burger", description = "Hamburguesa jugosa con cebolla caramelizada", imageUrl = "https://images.unsplash.com/photo-1553979459-d2229ba7433b?q=80&w=1200"),
                Dish(id = 61, name = "Cottage Fries", description = "Papas fritas gruesas estilo cottage", imageUrl = "https://images.unsplash.com/photo-1573080496219-bb080dd4f877?q=80&w=1200")
            )
        ),
        Restaurant(
            id = 25,
            name = "Ivan Ramen",
            description = "Ramen artesanal inspirado en Japón hecho en Nueva York.",
            imageUrl = "https://images.unsplash.com/photo-1557872943-16a5ac26437e?q=80&w=1200",
            categories = listOf("Ramen", "Asiática"),
            menu = listOf(
                Dish(id = 62, name = "Shio Ramen", description = "Ramen de sal con caldo de pollo claro", imageUrl = "https://images.unsplash.com/photo-1617093727343-374698b1b08d?q=80&w=1200"),
                Dish(id = 63, name = "Veggie Ramen", description = "Ramen vegetariano con tofu y verduras", imageUrl = "https://images.unsplash.com/photo-1569718212165-3a8278d5f624?q=80&w=1200")
            )
        ),
        Restaurant(
            id = 26,
            name = "Spot Dessert Bar",
            description = "Postres asiáticos creativos en el East Village.",
            imageUrl = "https://images.unsplash.com/photo-1488477181946-6428a0291777?q=80&w=1200",
            categories = listOf("Postres", "Asiática"),
            menu = listOf(
                Dish(id = 64, name = "Matcha Lava Cake", description = "Pastel de matcha con centro líquido", imageUrl = "https://images.unsplash.com/photo-1563805042-7684c019e1cb?q=80&w=1200"),
                Dish(id = 65, name = "Mango Mochi", description = "Mochi de mango con helado", imageUrl = "https://images.unsplash.com/photo-1548365328-8c6db3220e4c?q=80&w=1200")
            )
        ),
        Restaurant(
            id = 27,
            name = "Milk Bar",
            description = "Panadería creativa famosa por su birthday cake y cereal milk.",
            imageUrl = "https://images.unsplash.com/photo-1558961363-fa8fdf82db35?q=80&w=1200",
            categories = listOf("Postres", "Bakery"),
            menu = listOf(
                Dish(id = 66, name = "Birthday Cake Slice", description = "Pastel de cumpleaños con leche de cereal", imageUrl = "https://images.unsplash.com/photo-1558636508-e0db3814bd1d?q=80&w=1200"),
                Dish(id = 67, name = "Compost Cookie", description = "Cookie con pretzel, chips y avena", imageUrl = "https://images.unsplash.com/photo-1499636136210-6f4ee915583e?q=80&w=1200")
            )
        ),
        Restaurant(
            id = 28,
            name = "Stumptown Coffee",
            description = "Café de especialidad del Pacífico Noroeste con presencia en NYC.",
            imageUrl = "https://images.unsplash.com/photo-1461023058943-07fcbe16d735?q=80&w=1200",
            categories = listOf("Bebidas", "Café"),
            menu = listOf(
                Dish(id = 68, name = "Nitro Cold Brew", description = "Cold brew con nitrógeno, cremoso y suave", imageUrl = "https://images.unsplash.com/photo-1461023058943-07fcbe16d735?q=80&w=1200"),
                Dish(id = 69, name = "Cortado", description = "Espresso con leche al vapor en partes iguales", imageUrl = "https://images.unsplash.com/photo-1510591509098-f4fdc6d0ff04?q=80&w=1200")
            )
        )

        )

    override suspend fun getRestaurants(): List<Restaurant> {
        delay(200)
        return sampleRestaurants
    }
}