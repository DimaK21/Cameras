package ru.kryu.camera.presentation.details

import android.webkit.WebView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import ru.kryu.camera.R
import ru.kryu.camera.data.network.NetworkParams.BASE_URL
import ru.kryu.camera.data.network.NetworkParams.LOGIN

@Composable
fun DetailScreen(
    title: String,
    id: String,
) {
    val resource = "%s/mobile?login=%s&channelid=%s&resolutiony=500"
    val mjpegUrl = String.format(resource, BASE_URL, LOGIN, id)

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(stringResource(R.string.streaming_video_from, id))
        Spacer(modifier = Modifier.height(8.dp))
        MjpegPlayer(mjpegUrl)
    }
}

@Composable
fun MjpegPlayer(mjpegUrl: String) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                loadUrl(mjpegUrl)
            }
        }
    )
}
