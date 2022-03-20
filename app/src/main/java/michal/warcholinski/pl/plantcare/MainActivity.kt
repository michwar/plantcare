package michal.warcholinski.pl.plantcare

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import michal.warcholinski.pl.plantcare.navigation.AppBottomNavigation
import michal.warcholinski.pl.plantcare.navigation.MainNavigationGraph
import michal.warcholinski.pl.plantcare.ui.theme.PlantCareTheme

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContent {
			PlantCareTheme {
				MainScreen()
			}
		}
	}
}

@Composable
fun MainScreen() {
	val navController = rememberNavController()

	Scaffold(bottomBar = { AppBottomNavigation(navController = navController) }) { innerPadding ->
		Box(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, innerPadding.calculateBottomPadding())){
			MainNavigationGraph(navController = navController)
		}
	}
}

@Preview(name = "Light mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark mode")
@Composable
fun DefaultPreview() {
	PlantCareTheme {
		MainScreen()
	}
}