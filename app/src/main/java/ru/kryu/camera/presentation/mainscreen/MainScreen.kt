package ru.kryu.camera.presentation.mainscreen

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
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.kryu.camera.domain.model.CardItem

@Composable
fun MainScreen(
    state: UiState,
    onIntent: (UiIntent) -> Unit,
    navController: NavHostController,
    modifier: Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        when (state) {
            is UiState.Loading -> LoadingScreen()
            is UiState.Success -> CardGrid(state.items) { item ->
                navController.navigate("detail/${item.title}")
            }

            is UiState.Error -> ErrorScreen { onIntent(UiIntent.Retry) }
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
fun CardItemView(item: CardItem, onCardClick: (CardItem) -> Unit) {
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