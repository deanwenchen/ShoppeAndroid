package com.shoppe.android.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.shoppe.android.ui.theme.ShoppeBlack
import com.shoppe.android.ui.theme.ShoppeBlue
import com.shoppe.android.ui.theme.ShoppeWhite
import com.shoppe.android.ui.components.StatusBar

@Composable
fun StartPage(
    onLetsGetStartedClick: () -> Unit = {},
    onAlreadyHaveAccountClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ShoppeWhite)
    ) {
        // Status Bar
        StatusBar()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(120.dp))

            // Logo
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://www.figma.com/api/mcp/asset/9451c2e4-3f27-429f-8392-bd80e2bbab20")
                    .build(),
                contentDescription = "Shoppe Logo",
                modifier = Modifier.size(134.dp, 112.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Title
            Text(
                text = "Shoppe",
                fontSize = 52.sp,
                fontWeight = FontWeight.Bold,
                color = ShoppeBlack,
                letterSpacing = (-0.52).sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Subtitle
            Text(
                text = "Beautiful eCommerce UI Kit\nfor your online store",
                fontSize = 19.sp,
                fontWeight = FontWeight.Light,
                color = ShoppeBlack,
                lineHeight = 33.sp,
                modifier = Modifier.width(249.dp)
            )

            Spacer(modifier = Modifier.height(140.dp))

            // Let's get started Button
            Surface(
                color = ShoppeBlue,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(61.dp)
                    .clickable { onLetsGetStartedClick() },
                shadowElevation = 2.dp
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Let's get started",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Light,
                        color = Color(0xFFF3F3F3)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // I already have an account
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { onAlreadyHaveAccountClick() }
            ) {
                Text(
                    text = "I already have an account",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    color = ShoppeBlack.copy(alpha = 0.9f)
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Arrow button
                Box(
                    modifier = Modifier.size(30.dp),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://www.figma.com/api/mcp/asset/441ded80-0f5b-457b-81dd-97443d480828")
                            .build(),
                        contentDescription = "Arrow",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}
