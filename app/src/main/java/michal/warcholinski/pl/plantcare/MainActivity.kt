package michal.warcholinski.pl.plantcare

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import michal.warcholinski.pl.plantcare.navigation.AppBottomNavigation
import michal.warcholinski.pl.plantcare.navigation.MainNavigationGraph
import michal.warcholinski.pl.plantcare.ui.theme.PlantCareTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

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

	Scaffold(bottomBar = { AppBottomNavigation(navController = navController) }) {
		MainNavigationGraph(navController = navController)
	}
}


@Composable
fun BoardCard(name: String, iconId: Int) {
	Card(
		modifier = Modifier
			.padding(24.dp)
			.shadow(elevation = 8.dp),
	) {

		Row(modifier = Modifier
			.fillMaxWidth()
			.padding(24.dp),
			verticalAlignment = Alignment.CenterVertically) {

			Image(painter = painterResource(id = R.drawable.ic_plant), contentDescription = name,
				modifier = Modifier
					.width(100.dp)
					.height(100.dp))

			Spacer(modifier = Modifier.width(10.dp))

			Column {
				Surface(shape = MaterialTheme.shapes.medium, elevation = 4.dp,
					modifier = Modifier.padding(16.dp)) {
					Text(text = name, style = MaterialTheme.typography.subtitle1, fontSize = 21.sp)
				}
			}
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