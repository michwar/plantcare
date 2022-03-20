package michal.warcholinski.pl.plantcare.myplants

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import michal.warcholinski.pl.domain.myplants.model.PlantDataModel
import michal.warcholinski.pl.plantcare.R
import michal.warcholinski.pl.plantcare.navigation.bottomnavigation.NavigationDirection

/**
 * Created by Michał Warcholiński on 2022-02-11.
 */

@Composable
fun MyPlantsScreen(navController: NavController) {
	val viewModel: MyPlantsViewModel = hiltViewModel()
	val plants by viewModel.plants.observeAsState(initial = emptyList())

	Scaffold(floatingActionButton = {
		FloatingActionButton(
			onClick = { navController.navigate(NavigationDirection.AddPlant.route) },
			modifier = Modifier.size(48.dp)) {
			Icon(Icons.Default.Add, "Add plant", modifier = Modifier.size(24.dp))
		}
	}) {
		Column(modifier = Modifier.fillMaxSize()) {
			LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp), modifier = Modifier.fillMaxWidth()) {
				items(items = plants, key = { plant -> plant.id }) { plant ->
					PlantListRow(plant = plant) { plantId -> navController.navigate(NavigationDirection.PlantDetails.withArgs(plantId = plantId)) }
				}
			}

		}
	}
}

@Composable
fun PlantListRow(plant: PlantDataModel, showPlantDetailsScreen: (id: Long) -> Unit) {
	Card(shape = RoundedCornerShape(4.dp), modifier = Modifier.clickable { showPlantDetailsScreen(plant.id) }) {
		Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
			.fillMaxWidth()
			.padding(8.dp)) {
			Image(painter = painterResource(id = R.drawable.ic_plant), contentDescription = plant.name, modifier = Modifier
				.padding(16.dp, 0.dp)
				.size(48.dp))
			Spacer(modifier = Modifier.width(16.dp))
			Column {
				Text(text = plant.name, fontSize = 21.sp)
				Spacer(modifier = Modifier.height(4.dp))
				Text(text = plant.desc, fontSize = 16.sp)
				Spacer(modifier = Modifier.height(4.dp))
				Text(text = plant.lastWateringDate.toString())
			}
		}
	}
}

@Preview(name = "Light", showBackground = true)
@Preview(name = "Dark", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MyPlantsPreview() {
	val navController = rememberNavController()
	MyPlantsScreen(navController)
}
