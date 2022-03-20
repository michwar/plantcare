package michal.warcholinski.pl.plantcare.extension

import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * Created by Michał Warcholiński on 2022-03-20.
 */

fun Long.toDateFormat(): String {
	return SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date(this))
}