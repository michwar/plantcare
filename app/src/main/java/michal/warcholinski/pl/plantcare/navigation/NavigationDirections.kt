package michal.warcholinski.pl.plantcare.navigation.bottomnavigation

import michal.warcholinski.pl.plantcare.R

/**
 * Created by Michał Warcholiński on 2022-02-10.
 */

sealed class NavigationDirection(val route: String) {
	object PlantDetails : NavigationDirection("plant/{plantId}") {
		fun withArgs(plantId: Long) = "plant/$plantId"
	}
}

sealed class BottomNavDirection(val name: String, val icon: Int, route: String) : NavigationDirection(route) {
	object Home : BottomNavDirection("Home", R.drawable.ic_home, "home")
	object MyPlants : BottomNavDirection("My plants", R.drawable.ic_plant, "my_plants")
	object Search : BottomNavDirection("Search", R.drawable.ic_search, "search")
}
