package michal.warcholinski.pl.plantcare.myplants.addplant

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import michal.warcholinski.pl.plantcare.R
import michal.warcholinski.pl.plantcare.ui.datetime.DateViewWithPicker

/**
 * Created by Michał Warcholiński on 2022-02-15.
 */

@Composable
fun AddPlantScreen(popBack: () -> Unit) {
	val viewModel: AddPlantViewModel = hiltViewModel()

	val uiState = viewModel.uiState.collectAsState()

	if (uiState.value.finish)
		popBack()

	if (uiState.value.isLoading)
		Box(modifier = Modifier.fillMaxSize()) {
			CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
		}

	Column(modifier = Modifier
		.fillMaxWidth()
		.padding(8.dp)) {
		OutlinedTextField(
			value = uiState.value.name,
			onValueChange = { newValue -> viewModel.onNameChange(newValue) },
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = stringResource(id = R.string.plant_name)) },
			enabled = !uiState.value.isLoading
		)

		OutlinedTextField(
			value = uiState.value.place,
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = stringResource(id = R.string.plant_place)) },
			onValueChange = { newValue -> viewModel.onPlaceChange(newValue) },
			enabled = !uiState.value.isLoading
		)

		Spacer(modifier = Modifier.height(8.dp))

		Row(modifier = Modifier
			.fillMaxWidth()
			.padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
			Text(text = stringResource(id = R.string.plant_watering))
			Switch(
				checked = uiState.value.watering,
				onCheckedChange = { newValue -> viewModel.onWateringChange(newValue) },
				enabled = !uiState.value.isLoading
			)
		}

		if (uiState.value.watering) {
			DateViewWithPicker(
				currentSelection = uiState.value.wateringDate,
				onDateChanged = { newDateTime -> viewModel.onWateringDateChanged(newDateTime) }
			)
		}

		Spacer(modifier = Modifier.height(8.dp))

		OutlinedTextField(
			modifier = Modifier.fillMaxWidth(),
			value = uiState.value.desc,
			onValueChange = { newValue -> viewModel.onDescChange(newValue) },
			label = { Text(text = stringResource(id = R.string.plant_desc)) },
			maxLines = 5,
			enabled = !uiState.value.isLoading
		)

		Spacer(modifier = Modifier.height(16.dp))

		OutlinedButton(modifier = Modifier.fillMaxWidth(), onClick = { viewModel.addPlant() }) {
			Text(text = stringResource(id = R.string.add_plant))
		}
	}
}




