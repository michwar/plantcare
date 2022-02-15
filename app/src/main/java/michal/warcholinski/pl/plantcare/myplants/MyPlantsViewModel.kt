package michal.warcholinski.pl.plantcare.myplants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import michal.warcholinski.pl.domain.myplants.domain.GetAllMyPlantsUseCase
import michal.warcholinski.pl.domain.myplants.model.PlantDataModel
import javax.inject.Inject

/**
 * Created by Michał Warcholiński on 2022-02-11.
 */
@HiltViewModel
class MyPlantsViewModel @Inject constructor(private val getAllMyPlantsUseCase: GetAllMyPlantsUseCase) : ViewModel() {

	private val _plants = MutableLiveData<List<PlantDataModel>>()
	val plants: LiveData<List<PlantDataModel>>
		get() = _plants

	init {
		getAllMyPlants()
	}

	private fun getAllMyPlants() {
		viewModelScope.launch {
			getAllMyPlantsUseCase.invoke().collect { plants ->
				_plants.value = plants
			}
		}
	}
}