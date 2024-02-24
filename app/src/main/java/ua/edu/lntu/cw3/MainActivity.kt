package ua.edu.lntu.cw3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.edu.lntu.cw3.data.Datasource
import ua.edu.lntu.cw3.model.GalleryItem
import ua.edu.lntu.cw3.ui.theme.ControlWork3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ControlWork3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GalleryItemList(galleryItemList = Datasource().loadGallery())
                }
            }
        }
    }
}

@Composable
fun GalleryItemCard(galleryItem: GalleryItem, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(id = galleryItem.imageResourceId),
                contentDescription = stringResource(id = galleryItem.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentScale = ContentScale.Crop
            )
            Text (
                text = stringResource(id = galleryItem.stringResourceId),
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
fun GalleryItemList(galleryItemList: List<GalleryItem>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(galleryItemList) {
            galleryItem -> GalleryItemCard(
                galleryItem = galleryItem,
                modifier = Modifier.padding(8.dp)
                )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GalleryPreview() {
    ControlWork3Theme {
        GalleryItemList(galleryItemList = Datasource().loadGallery())
    }
}