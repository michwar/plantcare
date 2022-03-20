package michal.warcholinski.pl.data.local.mapper

import michal.warcholinski.pl.data.local.entity.PlantEntity
import michal.warcholinski.pl.domain.myplants.model.PlantDataModel
import javax.inject.Inject

/**
 * Created by Michał Warcholiński on 2022-02-13.
 */
internal class PlantMapper @Inject constructor() {

	fun mapToDataModel(entity: PlantEntity) =
		PlantDataModel(entity.id!!, entity.name, entity.place, entity.desc, entity.lastWateringDate, entity.addedDate)

	fun mapToEntity(model: PlantDataModel) =
		PlantEntity(model.id, model.name, model.place, model.desc, model.lastWateringDate, model.addedDate)
}