package michal.warcholinski.pl.data.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Michał Warcholiński on 2022-02-13.
 */
@InstallIn(SingletonComponent::class)
@Module
internal object DatabaseModule {

	@Provides
	@Singleton
	fun providesDatabase(@ApplicationContext context: Context) =
		Room.databaseBuilder(context, PlantsDatabase::class.java, "plant_care_db")
			.fallbackToDestructiveMigration()
			.build()

	@Provides
	@Singleton
	fun providePlantDao(db: PlantsDatabase) = db.plantDao()
}