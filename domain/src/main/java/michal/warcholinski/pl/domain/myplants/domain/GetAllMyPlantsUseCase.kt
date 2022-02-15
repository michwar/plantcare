package michal.warcholinski.pl.domain.myplants.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import michal.warcholinski.pl.domain.myplants.model.PlantDataModel
import javax.inject.Inject

/**
 * Created by Michał Warcholiński on 2022-02-11.
 */
class GetAllMyPlantsUseCase @Inject constructor(private val repo: PlantsRepository) {

	suspend operator fun invoke(): Flow<List<PlantDataModel>> {
		return withContext(Dispatchers.IO) {
			repo.getMyPlants()
		}
	}
}