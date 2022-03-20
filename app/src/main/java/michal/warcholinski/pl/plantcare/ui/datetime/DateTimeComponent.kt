package michal.warcholinski.pl.plantcare.ui.datetime

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.google.android.material.datepicker.MaterialDatePicker
import michal.warcholinski.pl.plantcare.R
import michal.warcholinski.pl.plantcare.extension.toDateFormat

/**
 * Created by Michał Warcholiński on 2022-03-20.
 */
@Composable
fun DateViewWithPicker(currentSelection: Long, onDateChanged: (Long) -> Unit) {
	val activity = LocalContext.current as AppCompatActivity
	var opened by remember { mutableStateOf(false) }

	OutlinedTextField(
		value = currentSelection.toDateFormat(),
		onValueChange = { },
		label = { Text(text = stringResource(id = R.string.last_watering_date)) },
		enabled = false,
		trailingIcon = {
			Image(
				painter = painterResource(id = R.drawable.ic_edit_calendar),
				contentDescription = "watering date",
				Modifier.clickable(enabled = !opened) {
					opened = true
					openDialog(activity, currentSelection, onDateChanged, { opened = false })
				}
			)
		},
		modifier = Modifier.fillMaxWidth()
	)
}

private fun openDialog(activity: AppCompatActivity,
                       currentSelection: Long,
                       onDateChanged: (Long) -> Unit,
                       onDialogClosed: () -> Unit) {

	val datePicker = MaterialDatePicker.Builder.datePicker()
		.setSelection(currentSelection)
		.build()

	datePicker.addOnPositiveButtonClickListener { pickedDate -> onDateChanged(pickedDate) }
	datePicker.addOnDismissListener { onDialogClosed() }

	datePicker.show(activity.supportFragmentManager, "date_picker")
}