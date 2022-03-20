package michal.warcholinski.pl.plantcare.myplants.addplant

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import michal.warcholinski.pl.domain.myplants.domain.AddPlantUseCase
import java.util.*
import javax.inject.Inject

/**
 * Created by Michał Warcholiński on 2022-02-22.
 */
@HiltViewModel
class AddPlantViewModel @Inject constructor(
	private val addPlantUseCase: AddPlantUseCase
) : ViewModel() {

	@Immutable
	data class AddPlantUiState(val name: String = "",
	                           val place: String = "",
	                           val desc: String = "",
	                           val watering: Boolean = false,
	                           val wateringDate: Long = Date().time,
	                           val isLoading: Boolean = false,
	                           val finish: Boolean = false)

	private val _uiState = MutableStateFlow(AddPlantUiState())
	val uiState: StateFlow<AddPlantUiState> = _uiState.asStateFlow()

	fun onNameChange(newName: String) {
		_uiState.update { it.copy(name = newName) }
	}

	fun onPlaceChange(newPlace: String) {
		_uiState.update { it.copy(place = newPlace) }
	}

	fun onDescChange(newDesc: String) {
		_uiState.update { it.copy(desc = newDesc) }
	}

	fun onWateringChange(newWatering: Boolean) {
		_uiState.update { it.copy(watering = newWatering) }
	}

	fun onWateringDateChanged(newDateTime: Long) {
		_uiState.update { it.copy(wateringDate = newDateTime) }
	}

	fun addPlant() {
		viewModelScope.launch {
			val loading = _uiState.value.isLoading
			_uiState.update { it.copy(isLoading = !loading) }
			val uiState = _uiState.value
			addPlantUseCase.invoke(uiState.name, uiState.place, uiState.watering, uiState.wateringDate, uiState.desc)
			_uiState.update { it.copy(finish = true) }
		}
	}
}
