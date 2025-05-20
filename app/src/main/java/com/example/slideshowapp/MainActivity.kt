package com.example.slideshowapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.slideshowapp.ui.theme.SlideshowAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SlideshowAppTheme {
                SlideListScreen()
            }
        }
    }
}

@Composable
fun SlideListScreen() {
    val slideItems = listOf(
        SlideItem(R.drawable.image1, stringResource(R.string.caption_1)),
        SlideItem(R.drawable.image2, stringResource(R.string.caption_2)),
        SlideItem(R.drawable.image3, stringResource(R.string.caption_3)),
        SlideItem(R.drawable.image4, stringResource(R.string.caption_4)),
        SlideItem(R.drawable.image5, stringResource(R.string.caption_5)),
        SlideItem(R.drawable.image6, stringResource(R.string.caption_6)),
        SlideItem(R.drawable.image7, stringResource(R.string.caption_7)),
        SlideItem(R.drawable.image8, stringResource(R.string.caption_8)),
        SlideItem(R.drawable.image9, stringResource(R.string.caption_9)),
        SlideItem(R.drawable.image10, stringResource(R.string.caption_10))
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(slideItems.size) { index ->
            SlideItemCard(slideItems[index])
        }
    }
}

@Composable
fun SlideItemCard(item: SlideItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = item.imageResId),
                contentDescription = item.caption,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = item.caption,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSlideListScreen() {
    SlideshowAppTheme {
        SlideListScreen()
    }
}


data class SlideItem(
    val imageResId: Int,
    val caption: String
)
