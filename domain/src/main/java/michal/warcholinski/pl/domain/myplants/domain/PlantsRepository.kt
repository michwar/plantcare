package michal.warcholinski.pl.domain.myplants.domain

import kotlinx.coroutines.flow.Flow
import michal.warcholinski.pl.domain.myplants.model.PlantDataModel

/**
 * Created by Michał Warcholiński on 2022-02-11.
 */
interface PlantsRepository {

	fun getMyPlants(): Flow<List<PlantDataModel>>

	suspend fun addPlant(name: String, place: String, wateringDate: Long?, desc: String): Result<Boolean>
}