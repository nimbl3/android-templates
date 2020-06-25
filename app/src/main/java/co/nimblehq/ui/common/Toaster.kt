package co.nimblehq.ui.common

import android.content.Context
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText
import androidx.annotation.StringRes
import co.nimblehq.di.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class Toaster @Inject constructor(private val context: Context) {

    private var toast: Toast? = null

    fun display(@StringRes messageRes: Int) {
        toast?.cancel()
        toast = makeText(context, messageRes, LENGTH_LONG).also { it.show() }
    }

    fun display(message: String) {
        toast?.cancel()
        toast = makeText(context, message, LENGTH_LONG).also { it.show() }
    }

}
