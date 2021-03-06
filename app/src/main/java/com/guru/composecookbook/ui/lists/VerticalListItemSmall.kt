package com.guru.composecookbook.ui.lists

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.guru.composecookbook.data.DemoDataProvider
import com.guru.composecookbook.data.model.Item
import com.guru.composecookbook.theme.ComposeCookBookTheme

@Composable
fun VerticalListItemSmall(item: Item, modifier: Modifier = Modifier) {
    val typography = MaterialTheme.typography
    Row(
        modifier = Modifier.clickable(onClick = { })
            .padding(16.dp)
    ) {
        ItemImage(
            item,
            Modifier.padding(end = 16.dp)
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(item.title, style = typography.subtitle1)
            Text(item.subtitle, style = typography.body2)
        }
        FavIcon(modifier)
    }
}

@Composable
fun ItemImage(item: Item, modifier: Modifier = Modifier) {
    val image = imageResource(item.imageId)
    Image(
        asset = image,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .preferredSize(100.dp, 80.dp)
            .clip(MaterialTheme.shapes.medium)
    )
}

@Composable
fun FavIcon(modifier: Modifier = Modifier) {
    val isFavourite = remember { mutableStateOf(true) }
    IconToggleButton(
        checked = isFavourite.value,
        onCheckedChange = { isFavourite.value = !isFavourite.value }
    ) {
        if (isFavourite.value) {
            Icon(asset = Icons.Filled.Favorite, modifier = modifier)
        } else {
            Icon(
                asset = Icons.Default.FavoriteBorder, modifier = modifier
            )
        }
    }
}


@Preview
@Composable
fun PreviewListViewItemSmall() {
    val item = DemoDataProvider.item
    ComposeCookBookTheme {
        VerticalListItemSmall(item)
    }
}
