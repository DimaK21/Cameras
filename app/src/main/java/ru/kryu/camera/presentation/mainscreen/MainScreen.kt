package ru.kryu.camera.presentation.mainscreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.kryu.camera.R
import ru.kryu.camera.domain.model.CardItem

@Composable
fun MainScreen(
    onItemClick: (String, String) -> Unit,
    viewModel: MainViewModel = hiltViewModel(),
) {
    val state = viewModel.uiState.collectAsState()
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            state.value.isLoading -> LoadingScreen()
            state.value.isError -> ErrorScreen { viewModel.processIntent(UiIntent.LoadData) }
            !state.value.isLoading && !state.value.isError -> {
                Box(
                    contentAlignment = Alignment.TopCenter,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CardGrid(state.value.items) { item ->
                        onItemClick(item.title, item.id)
                    }
                }
                Button(
                    onClick = { viewModel.processIntent(UiIntent.LoadData) },
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.BottomCenter)
                ) {
                    Text(stringResource(R.string.refresh))
                }
            }
        }
    }

    LaunchedEffect(state.value.errorMessage) {
        if (state.value.errorMessage.isNotBlank()) {
            Toast.makeText(context, state.value.errorMessage, Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun CardGrid(items: List<CardItem>, onCardClick: (CardItem) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(items.size) { index ->
            CardItemView(items[index], onCardClick)
        }
    }
}

@Composable
fun CardItemView(
    item: CardItem,
    onCardClick: (CardItem) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onCardClick(item) }
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            val image: Painter = painterResource(id = item.imageRes)
            Image(
                painter = image,
                contentDescription = item.title,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(item.title)
        }
    }
}