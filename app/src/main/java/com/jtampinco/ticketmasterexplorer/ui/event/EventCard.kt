package com.jtampinco.ticketmasterexplorer.ui.event

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.jtampinco.ticketmasterexplorer.app.theme.typography
import com.jtampinco.ticketmasterexplorer.data.domain.model.Event
import com.jtampinco.ticketmasterexplorer.ui.components.AnimatedHeartButton

@OptIn(
    ExperimentalCoilApi::class,
    ExperimentalAnimationApi::class,
)
@Composable
fun EventCard(
    event: Event,
    onFavoriteClicked: (Boolean) -> Unit,
    onAttractionClicked: (String) -> Unit,
) {
    BoxWithConstraints {
        val layoutWidth = maxWidth
        Surface(
            shape = RoundedCornerShape(16.dp),
            elevation = 4.dp,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)
                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = event.image,
                        ),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    AnimatedHeartButton(
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.TopEnd),
                        isSelected = event.isFavorite,
                        onButtonClicked = { onFavoriteClicked(it) })
                }

                Spacer(modifier = Modifier.size(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Text(
                            text = event.name,
                            style = typography.subtitle1,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                        )
                        for (venue in event.venues) {
                            Text(
                                text = venue.name,
                                style = typography.subtitle2,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                        for (price in event.priceRanges) {
                            Text(
                                text = price,
                                style = typography.caption,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                        }
                        Text(
                            text = event.date,
                            style = typography.overline,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
                Spacer(modifier = Modifier.size(16.dp))
                if (event.attractions.isNotEmpty()) {
                    Divider(modifier = Modifier.fillMaxWidth())
                    Text(
                        text = "Attractions",
                        style = typography.subtitle2,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    )
                    AnimatedVisibility(visible = layoutWidth > 300.dp) {
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            items(event.attractions) { attraction ->
                                Attraction(
                                    image = attraction.image!!,
                                    contentDescription = attraction.name,
                                    url = attraction.url,
                                    value = attraction.name,
                                    onAttractionClicked = { onAttractionClicked(it) }
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.size(8.dp))
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .background(colors.primary)
                        .padding(top = 8.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun Attraction(
    modifier: Modifier = Modifier,
    image: String,
    contentDescription: String,
    url: String,
    value: String,
    onAttractionClicked: (String) -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.medium,
        ) {
            Image(
                painter = rememberImagePainter(image) {
                    crossfade(true)
                },
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(75.dp)
                    .background(Color.LightGray)
                    .clickable { onAttractionClicked(url) }
            )
        }
        Column(
            modifier = Modifier.wrapContentSize(),
        ) {
            Text(
                text = value,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = typography.body2,
            )
        }
    }
}