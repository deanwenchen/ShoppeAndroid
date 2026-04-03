package com.shoppe.android.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.rotate
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun DecorativeBubblesPassword() {
    Box(modifier = Modifier.fillMaxSize()) {
        // Bubble 02
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/7ef64c96-fb2e-4249-b1ce-61b88ff474a1")
                .build(),
            contentDescription = "Decorative bubble",
            modifier = Modifier
                .offset(x = (-137).dp, y = (-172).dp)
                .size(374.dp, 443.dp)
                .rotate(158f),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )

        // Bubble 01
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/8b19e1bf-a9ad-4c6f-a667-6be1b44cc6d6")
                .build(),
            contentDescription = "Decorative bubble",
            modifier = Modifier
                .offset(x = (-158).dp, y = (-171).dp)
                .size(403.dp, 443.dp),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
    }
}

@Composable
fun DecorativeBubblesOnboarding() {
    Box(modifier = Modifier.fillMaxSize()) {
        // Bubble 02
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/99b1e9b2-3ca2-492a-94ea-da03056f0b86")
                .build(),
            contentDescription = "Decorative bubble",
            modifier = Modifier
                .offset(x = (-141).dp, y = 239.dp)
                .size(377.dp, 443.dp)
                .rotate(108f),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )

        // Bubble 01
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/67470418-62b9-4fe7-809c-68559a92b6c0")
                .build(),
            contentDescription = "Decorative bubble",
            modifier = Modifier
                .offset(x = (-147).dp, y = (-123).dp)
                .size(403.dp, 443.dp),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
    }
}

@Composable
fun DecorativeBubblesLogin() {
    Box(modifier = Modifier.fillMaxSize()) {
        // Bubble 01
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/84e0f729-3a1e-4110-bb68-73a284b6f2a3")
                .build(),
            contentDescription = "Decorative bubble",
            modifier = Modifier
                .offset(x = (-107).dp, y = (-207).dp)
                .size(374.dp, 443.dp)
                .rotate(111f),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )

        // Bubble 02
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/4eb3a9b5-d7e7-423d-a619-8a5e6fb1dc77")
                .build(),
            contentDescription = "Decorative bubble",
            modifier = Modifier
                .offset(x = 223.dp, y = 351.dp)
                .size(310.dp, 382.dp)
                .rotate(242f),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )

        // Bubble 03
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/22bf67a3-26a1-4586-b2bf-4898df9e7b04")
                .build(),
            contentDescription = "Decorative bubble",
            modifier = Modifier
                .offset(x = (-164).dp, y = 262.dp)
                .size(349.dp, 382.dp),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )

        // Bubble 04
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/ef5e6679-8257-4867-bcbc-5766226d3bca")
                .build(),
            contentDescription = "Decorative bubble",
            modifier = Modifier
                .offset(x = 224.dp, y = (-116).dp)
                .size(375.dp, 382.dp),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
    }
}
