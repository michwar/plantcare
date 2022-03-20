package michal.warcholinski.pl.domain.myplants.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Michał Warcholiński on 2022-03-15.
 */
class AddPlantUseCase @Inject constructor(private val repo: PlantsRepository) {

	suspend operator fun invoke(name: String, place: String, alreadyWatering: Boolean, wateringDate: Long, desc: String): Result<Boolean> {
		return withContext(Dispatchers.IO) {
			repo.addPlant(name, place, if (alreadyWatering) wateringDate else null, desc)
		}
	}
}