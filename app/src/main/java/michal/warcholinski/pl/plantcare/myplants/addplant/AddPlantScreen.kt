package michal.warcholinski.pl.plantcare.myplants.addplant

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

/**
 * Created by Michał Warcholiński on 2022-02-15.
 */

@Composable
fun AddPlantScreen(popBack: () -> Unit) {

	Button(onClick = popBack) {
		Text(text = "PopBack")
	}
}