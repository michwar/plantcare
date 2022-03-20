package michal.warcholinski.pl.data.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import michal.warcholinski.pl.data.local.dao.PlantDao
import michal.warcholinski.pl.data.local.entity.PlantEntity
import michal.warcholinski.pl.data.local.mapper.PlantMapper
import michal.warcholinski.pl.domain.myplants.domain.PlantsRepository
import michal.warcholinski.pl.domain.myplants.model.PlantDataModel
import java.util.*
import javax.inject.Inject

/**
 * Created by Michał Warcholiński on 2022-02-11.
 */
internal class PlantsRepositoryImpl @Inject constructor(
	private val dao: PlantDao,
	private val plantMapper: PlantMapper
) : PlantsRepository {

	override fun getMyPlants(): Flow<List<PlantDataModel>> {
		return dao.getAll()
			.map { plants ->
				plants.map { plantEntity -> plantMapper.mapToDataModel(plantEntity) }
			}

		/*return flowOf(listOf(
			PlantDataModel(1, "Plant1", "","desc1", 0, 0),
			PlantDataModel(2, "Plant2", "desc1", 0, 0),
			PlantDataModel(3, "Plant3", "desc1", 0, 0),
			PlantDataModel(4, "Plant4", "desc1", 0, 0),
			PlantDataModel(5, "Plant5", "desc1", 0, 0),
			PlantDataModel(6, "Plant6", "desc1", 0, 0),
			PlantDataModel(7, "Plant7", "desc1", 0, 0),
			PlantDataModel(8, "Plant8", "desc1", 0, 0),
			PlantDataModel(9, "Plant9", "desc1", 0, 0),
			PlantDataModel(10, "Plant10", "desc1", 0, 0),
			PlantDataModel(11, "Plant11", "desc1", 0, 0),
			PlantDataModel(12, "Plant12", "desc1", 0, 0),
			PlantDataModel(13, "Plant13", "desc1", 0, 0),
			PlantDataModel(14, "Plant14", "desc1", 0, 0),
			PlantDataModel(15, "Plant15", "desc1", 0, 0),
		))*/
	}

	override suspend fun addPlant(name: String, place: String, wateringDate: Long?, desc: String): Result<Boolean> {
		dao.insert(PlantEntity(null, name, place, desc, wateringDate, Date().time))

		return Result.success(true)
	}
}