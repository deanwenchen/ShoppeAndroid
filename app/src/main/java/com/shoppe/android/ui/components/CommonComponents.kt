package com.shoppe.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PasswordDots(
    length: Int = 8,
    filledCount: Int,
    filledColor: Color = Color(0xFF004CFF),
    emptyColor: Color = Color(0xFFD2D2D2),
    filledDotAsset: String = "https://www.figma.com/api/mcp/asset/54a7d78c-0680-4a95-82ba-1355437f17fb",
    emptyDotAsset: String = "https://www.figma.com/api/mcp/asset/957e1d4e-c2cb-4025-9cb3-71ba4f81b029"
) {
    Row(
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until length) {
            Box(
                modifier = Modifier.size(17.dp),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(if (i < filledCount) filledDotAsset else emptyDotAsset)
                        .build(),
                    contentDescription = "Password dot ${if (i < filledCount) "filled" else "empty"}",
                    modifier = Modifier.size(17.dp)
                )
            }
        }
    }
}

@Composable
fun ProfileImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    size: androidx.compose.ui.unit.Dp = 106.dp
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(RoundedCornerShape(50))
            .background(Color(0xFFFFF0F5))
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .build(),
            contentDescription = "Profile",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )
    }
}

@Composable
fun DotIndicator(
    isActive: Boolean,
    modifier: Modifier = Modifier,
    activeAsset: String = "https://www.figma.com/api/mcp/asset/a0e9ee82-0518-4607-872e-3a132dd70ba5",
    inactiveAsset: String = "https://www.figma.com/api/mcp/asset/6001c44e-4c2a-493b-b217-a0f9c29006c5"
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(if (isActive) activeAsset else inactiveAsset)
                .build(),
            contentDescription = if (isActive) "Active page" else "Inactive page",
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFF004CFF),
    textColor: Color = Color(0xFFF3F3F3),
    enabled: Boolean = true
) {
    Surface(
        color = backgroundColor,
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(61.dp)
            .clickable(enabled = enabled, onClick = onClick),
        shadowElevation = 2.dp
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                fontSize = 22.sp,
                fontWeight = FontWeight.Light,
                color = textColor
            )
        }
    }
}

@Composable
fun LinkText(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    fontSize: sp = 15.sp,
    color: Color = Color(0xFF202020)
) {
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = FontWeight.Light,
        color = color,
        modifier = modifier.clickable { onClick() }
    )
}
