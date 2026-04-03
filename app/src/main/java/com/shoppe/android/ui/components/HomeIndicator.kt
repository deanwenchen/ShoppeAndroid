package com.shoppe.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeIndicator(
    modifier: Modifier = Modifier,
    color: Color = Color.Black
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 9.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .size(width = 134.dp, height = 5.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(color)
        )
    }
}
