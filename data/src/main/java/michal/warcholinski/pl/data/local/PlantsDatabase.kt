package michal.warcholinski.pl.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import michal.warcholinski.pl.data.local.dao.PlantDao
import michal.warcholinski.pl.data.local.entity.PlantEntity

/**
 * Created by Michał Warcholiński on 2022-02-13.
 */
@Database(entities = [PlantEntity::class],
	version = 2,
	exportSchema = false)
internal abstract class PlantsDatabase : RoomDatabase() {

	abstract fun plantDao(): PlantDao
}