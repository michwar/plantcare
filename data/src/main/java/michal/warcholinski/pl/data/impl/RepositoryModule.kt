package michal.warcholinski.pl.data.impl

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import michal.warcholinski.pl.domain.myplants.domain.PlantsRepository
import javax.inject.Singleton

/**
 * Created by Michał Warcholiński on 2022-02-11.
 */
@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

	@Binds
	@Singleton
	abstract fun bindPlantRepository(repo: PlantsRepositoryImpl): PlantsRepository
}