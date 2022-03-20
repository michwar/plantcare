package michal.warcholinski.pl.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import michal.warcholinski.pl.data.local.entity.PlantEntity

/**
 * Created by Michał Warcholiński on 2022-02-13.
 */
@Dao
internal interface PlantDao {

	@Query("SELECT * FROM plant")
	fun getAll(): Flow<List<PlantEntity>>

	@Insert
	suspend fun insert(vararg objects: PlantEntity): List<Long>
}