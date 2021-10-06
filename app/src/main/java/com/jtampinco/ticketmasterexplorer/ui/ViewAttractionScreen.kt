package com.jtampinco.ticketmasterexplorer.ui

import android.content.res.Configuration
import android.webkit.WebView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebSettingsCompat.FORCE_DARK_OFF
import androidx.webkit.WebSettingsCompat.FORCE_DARK_ON
import androidx.webkit.WebViewFeature
import com.jtampinco.ticketmasterexplorer.viewmodel.ViewAttractionViewModel

@Composable
fun ViewAttractionScreen(
    viewModel: ViewAttractionViewModel,
    modifier: Modifier = Modifier,
) {
    AndroidView(
        modifier = modifier.fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                    when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
                        Configuration.UI_MODE_NIGHT_YES -> {
                            WebSettingsCompat.setForceDark(settings, FORCE_DARK_ON)
                        }
                        Configuration.UI_MODE_NIGHT_NO, Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                            WebSettingsCompat.setForceDark(settings, FORCE_DARK_OFF)
                        }
                        else -> { /* Use Default */
                        }
                    }
                }
            }
        }
    ) {
        viewModel.run {
            it.loadUrl(attractionUrl)
        }
    }
}