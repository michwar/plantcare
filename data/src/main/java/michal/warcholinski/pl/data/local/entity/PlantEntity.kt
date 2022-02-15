package michal.warcholinski.pl.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Michał Warcholiński on 2022-02-13.
 */
@Entity(tableName = "plant")
internal data class PlantEntity(@PrimaryKey(autoGenerate = true) val id: Long?,
                                val name: String,
                                val desc: String,
                                @ColumnInfo(name = "last_watering_date") val lastWateringDate: Long?,
                                @ColumnInfo(name = "added_date") val addedDate: Long)