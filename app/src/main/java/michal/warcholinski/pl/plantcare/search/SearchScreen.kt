package michal.warcholinski.pl.plantcare.search

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * Created by Michał Warcholiński on 2022-02-11.
 */

@Composable
fun SearchScreen() {
	Column(modifier = Modifier.fillMaxSize()) {
		Text(text = "Search screen")
	}
}

@Preview(name = "Light", showBackground = true)
@Preview(name = "Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SearchScreenPreview() {
	SearchScreen()
}