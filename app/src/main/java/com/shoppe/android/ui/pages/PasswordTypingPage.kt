package com.shoppe.android.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import com.shoppe.android.ui.theme.ShoppeWhite

@Composable
fun PasswordTypingPage(
    passwordLength: Int = 5, // Shows 5 filled dots out of 8
    onPasswordComplete: (String) -> Unit = {}
) {
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ShoppeWhite)
    ) {
        // Status Bar
        StatusBar()

        // Decorative Bubbles
        DecorativeBubblesPassword()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(120.dp))

            // Profile Image
            ProfileImage()

            Spacer(modifier = Modifier.height(24.dp))

            // Greeting
            Text(
                text = "Hello, Romina!!",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = ShoppeBlack,
                letterSpacing = (-0.28).sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Subtitle
            Text(
                text = "Type your password",
                fontSize = 19.sp,
                fontWeight = FontWeight.Light,
                color = ShoppeBlack,
                lineHeight = 35.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Password Dots (8 dots, 5 filled blue, 3 empty)
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (i in 0 until 8) {
                    if (i < passwordLength) {
                        // Filled blue dot
                        Box(
                            modifier = Modifier.size(17.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data("https://www.figma.com/api/mcp/asset/54a7d78c-0680-4a95-82ba-1355437f17fb")
                                    .build(),
                                contentDescription = "Password dot filled",
                                modifier = Modifier.size(17.dp)
                            )
                        }
                    } else {
                        // Empty dot
                        Box(
                            modifier = Modifier.size(17.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data("https://www.figma.com/api/mcp/asset/957e1d4e-c2cb-4025-9cb3-71ba4f81b029")
                                    .build(),
                                contentDescription = "Password dot empty",
                                modifier = Modifier.size(17.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(150.dp))

            // Bottom Home Indicator only (system keyboard handles input)
            HomeIndicator()
        }

        // Hidden password input
        PasswordInputField(
            value = password,
            onValueChange = { newValue ->
                if (newValue.length <= 8) {
                    password = newValue
                    if (newValue.length == 8) {
                        onPasswordComplete(newValue)
                    }
                }
            }
        )
    }
}

@Composable
private fun HomeIndicator() {
    // Bottom Home Indicator for gesture navigation
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 9.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .size(width = 134.dp, height = 5.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(Color.Black)
        )
    }
}

@Composable
private fun ProfileImage() {
    Box(
        modifier = Modifier
            .size(106.dp)
            .clip(CircleShape)
            .background(Color(0xFFFFF0F5))
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/d70d7de4-6db4-456a-9cc6-b32d696a34bd")
                .build(),
            contentDescription = "Profile",
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun DecorativeBubblesPassword() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
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
private fun PasswordInputField(
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .size(1.dp)
            .alpha(0.01f),
        keyboardInput = true,
        singleLine = true,
        maxLines = 1
    )
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
                        .data("https://www.figma.com/api/mcp/asset/6099ebc8-d2e9-440d-8048-2baa1bab26be")
                        .build(),
                    contentDescription = "Cellular",
                    modifier = Modifier.size(17.dp, 11.dp)
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/cee7cbf9-a9b2-4469-bcc7-bc7e3a977953")
                        .build(),
                    contentDescription = "Wifi",
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
