package michal.warcholinski.pl.plantcare.myplants

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Created by Michał Warcholiński on 2022-02-13.
 */

@Composable
fun PlantDetails(id: Long) {
	Box(modifier = Modifier.fillMaxSize()) {
		Text(text = "Plant details with id: $id")
	}
}