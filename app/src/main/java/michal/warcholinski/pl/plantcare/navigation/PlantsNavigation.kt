package michal.warcholinski.pl.plantcare.navigation

import androidx.navigation.*
import androidx.navigation.compose.composable
import michal.warcholinski.pl.plantcare.myplants.MyPlantsScreen
import michal.warcholinski.pl.plantcare.myplants.PlantDetails
import michal.warcholinski.pl.plantcare.myplants.addplant.AddPlantScreen
import michal.warcholinski.pl.plantcare.navigation.bottomnavigation.BottomNavDirection
import michal.warcholinski.pl.plantcare.navigation.bottomnavigation.NavigationDirection

/**
 * Created by Michał Warcholiński on 2022-02-15.
 */
fun NavGraphBuilder.plantsGraph(navController: NavController) {
	navigation(startDestination = BottomNavDirection.MyPlants.route, route = "plants") {
		composable(BottomNavDirection.MyPlants.route) {
			MyPlantsScreen(navController = navController)
		}
		composable(NavigationDirection.PlantDetails.route,
			arguments = listOf(navArgument("plantId") {
				type = NavType.LongType
			})) { navBackStackEntry ->
			val plantId = navBackStackEntry.arguments?.getLong("plantId") ?: 0
			PlantDetails(id = plantId)
		}

		composable(NavigationDirection.AddPlant.route) {
			AddPlantScreen { navController.popBackStack() }
		}
	}
}
