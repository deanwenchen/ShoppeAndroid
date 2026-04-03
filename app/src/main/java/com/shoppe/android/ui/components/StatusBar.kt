package com.shoppe.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun StatusBar(
    modifier: Modifier = Modifier,
    showIcons: Boolean = true
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "9:41",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )

            if (showIcons) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://www.figma.com/api/mcp/asset/6099ebc8-d2e9-440d-8048-2baa1bab26be")
                            .build(),
                        contentDescription = "Cellular signal",
                        modifier = Modifier.size(17.dp, 11.dp)
                    )
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://www.figma.com/api/mcp/asset/cee7cbf9-a9b2-4469-bcc7-bc7e3a977953")
                            .build(),
                        contentDescription = "WiFi",
                        modifier = Modifier.size(15.dp, 11.dp)
                    )
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://www.figma.com/api/mcp/asset/2db269c5-9fe6-47a0-91fa-fa79cc8bf0c9")
                            .build(),
                        contentDescription = "Battery",
                        modifier = Modifier.size(24.dp, 11.dp)
                    )
                }
            }
        }
    }
}
