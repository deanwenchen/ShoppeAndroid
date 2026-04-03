package com.shoppe.android.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.shoppe.android.ui.theme.BackgroundGrey

@Composable
fun LoginPage(
    onNextClick: () -> Unit = {},
    onCancelClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ShoppeWhite)
    ) {
        // Status Bar
        StatusBar()

        // Decorative Bubbles
        DecorativeBubblesLogin()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(400.dp))

            // Title
            Text(
                text = "Login",
                fontSize = 52.sp,
                fontWeight = FontWeight.Bold,
                color = ShoppeBlack,
                letterSpacing = (-0.52).sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Subtitle with Heart Icon
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Good to see you back!",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Light,
                    color = ShoppeBlack,
                    lineHeight = 35.sp
                )

                // Heart Icon
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/100f0e13-9ed3-4def-ac16-72a37be928be")
                        .build(),
                    contentDescription = "Heart",
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Email Field
            TextField(
                value = email,
                onValueChange = { email = it },
                placeholder = {
                    Text(
                        text = "Email",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Grey20
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
                    .clip(RoundedCornerShape(60.dp))
                    .background(BackgroundGrey),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = ShoppeBlack,
                    unfocusedTextColor = ShoppeBlack,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(88.dp))

            // Next Button
            Surface(
                color = ShoppeBlue,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(61.dp)
                    .clickable { onNextClick() },
                shadowElevation = 2.dp
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Next",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Light,
                        color = Color(0xFFF3F3F3)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Cancel Link
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Cancel",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Light,
                    color = ShoppeBlack.copy(alpha = 0.9f),
                    modifier = Modifier.clickable { onCancelClick() }
                )
            }
        }
    }
}

@Composable
private fun DecorativeBubblesLogin() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Bubble 04
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/624bf23f-a774-4740-8289-e3c9239118ce")
                .build(),
            contentDescription = "Decorative bubble",
            modifier = Modifier
                .offset(x = 87.dp, y = 449.dp)
                .size(374.dp, 443.dp)
                .rotate(108f),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )

        // Bubble 03
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/cf4ff7a4-33d4-44b1-afab-98bbf3287087")
                .build(),
            contentDescription = "Decorative bubble",
            modifier = Modifier
                .offset(x = 282.dp, y = 239.dp)
                .size(138.dp, 151.dp)
                .rotate(-156f),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )

        // Bubble 02
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/ae4157ed-a84f-4556-b91f-7a3960edeccd")
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
                .data("https://www.figma.com/api/mcp/asset/a56f3bcb-9192-4441-bdaf-6ef99206217b")
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
private fun StatusBar() {
    Box(
        modifier = Modifier
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

            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/c26358d1-17de-4ade-a7b2-9409204eaf09")
                        .build(),
                    contentDescription = "Cellular",
                    modifier = Modifier.size(17.dp, 11.dp)
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/b26cb356-7387-4f4b-b587-807822ee25cd")
                        .build(),
                    contentDescription = "Wifi",
                    modifier = Modifier.size(15.dp, 11.dp)
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/aaf72a4e-8fa1-492e-a5ae-28359f97298a")
                        .build(),
                    contentDescription = "Battery",
                    modifier = Modifier.size(24.dp, 11.dp)
                )
            }
        }
    }
}
