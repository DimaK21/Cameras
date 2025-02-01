package ru.kryu.camera.presentation.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {
    var videoUrl by mutableStateOf("https://example.com/stream.mp4")
        private set
}