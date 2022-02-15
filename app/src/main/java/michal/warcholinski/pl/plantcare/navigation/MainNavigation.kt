package michal.warcholinski.pl.plantcare.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import michal.warcholinski.pl.plantcare.home.HomeScreen
import michal.warcholinski.pl.plantcare.navigation.bottomnavigation.BottomNavDirection
import michal.warcholinski.pl.plantcare.search.SearchScreen

/**
 * Created by Michał Warcholiński on 2022-02-11.
 */

@Composable
fun MainNavigationGraph(navController: NavHostController) {
	NavHost(navController = navController, startDestination = BottomNavDirection.Home.route) {
		composable(BottomNavDirection.Home.route) {
			HomeScreen()
		}
		plantsGraph(navController = navController)
		composable(BottomNavDirection.Search.route) {
			SearchScreen()
		}
	}
}

@Composable
fun AppBottomNavigation(navController: NavController) {
	val bottomNavItems =
		listOf(BottomNavDirection.Home, BottomNavDirection.MyPlants, BottomNavDirection.Search)

	BottomNavigation {
		val navBackStackEntry by navController.currentBackStackEntryAsState()
		val currentRoute = navBackStackEntry?.destination?.route

		bottomNavItems.forEach { bottomItem ->
			BottomNavigationItem(
				icon = { Icon(painter = painterResource(id = bottomItem.icon), contentDescription = bottomItem.name) },
				label = { Text(text = bottomItem.name, fontSize = 10.sp) },
				alwaysShowLabel = true,
				selected = currentRoute == bottomItem.route,
				onClick = {
					navController.navigate(bottomItem.route) {
						navController.graph.startDestinationRoute?.let { route ->
							popUpTo(route) {
								saveState = true
							}
						}
						launchSingleTop = true
						restoreState = true
					}
				}
			)
		}
	}
}