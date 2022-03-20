package michal.warcholinski.pl.domain.myplants.model

/**
 * Created by Michał Warcholiński on 2022-02-11.
 */
data class PlantDataModel(val id: Long,
                          val name: String,
                          val place: String,
                          val desc: String,
                          val lastWateringDate: Long?,
                          val addedDate: Long)