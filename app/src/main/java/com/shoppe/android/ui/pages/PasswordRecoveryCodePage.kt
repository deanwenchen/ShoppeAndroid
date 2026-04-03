package com.shoppe.android.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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

// Verification code color
val CodeBlue = Color(0xFF004CFF)
val CodePink = Color(0xFFFF5790)
val CodeEmpty = Color(0xFFE5E5E5)

@Composable
fun PasswordRecoveryCodePage(
    onCancelClick: () -> Unit = {},
    onSendAgainClick: () -> Unit = {},
    onCodeCompleted: (String) -> Unit = {}
) {
    var code by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ShoppeWhite)
    ) {
        // Status Bar
        StatusBarLight()

        // Decorative Bubbles
        DecorativeBubblesRecovery()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(120.dp))

            // Profile Image
            ProfileImageRecovery()

            Spacer(modifier = Modifier.height(24.dp))

            // Title
            Text(
                text = "Password Recovery",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = ShoppeBlack
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Subtitle
            Text(
                text = "Enter 4-digits code we sent you on\nyour phone number",
                fontSize = 19.sp,
                fontWeight = FontWeight.Light,
                color = ShoppeBlack.copy(alpha = 0.9f),
                lineHeight = 27.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Phone number
            Text(
                text = "+98*******00",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = ShoppeBlack,
                letterSpacing = 1.6.sp
            )

            Spacer(modifier = Modifier.height(50.dp))

            // Code input dots
            CodeInputDots(code = code)

            Spacer(modifier = Modifier.height(80.dp))

            // Send Again Button
            Surface(
                color = CodePink,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable { onSendAgainClick() },
                shadowElevation = 2.dp
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Send Again",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Light,
                        color = Color(0xFFF3F3F3)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Cancel Link
            Text(
                text = "Cancel",
                fontSize = 15.sp,
                fontWeight = FontWeight.Light,
                color = ShoppeBlack.copy(alpha = 0.9f),
                modifier = Modifier.clickable { onCancelClick() }
            )
        }

        // Hidden code input for keyboard
        PasswordRecoveryCodeInput(
            value = code,
            onValueChange = { newValue ->
                if (newValue.length <= 4) {
                    code = newValue
                    if (newValue.length == 4) {
                        onCodeCompleted(newValue)
                    }
                }
            }
        )
    }
}

@Composable
private fun DecorativeBubblesRecovery() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/80fc90b9-8ebd-420d-a4a4-81e42c277348")
                .build(),
            contentDescription = "Decorative bubble",
            modifier = Modifier
                .offset(x = 20.dp, y = (-240).dp)
                .size(374.dp, 443.dp)
                .rotate(-110f),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/dd21c3bb-0dce-4666-a26a-98f70cac51d4")
                .build(),
            contentDescription = "Decorative bubble",
            modifier = Modifier
                .offset(x = 120.dp, y = (-273).dp)
                .size(403.dp, 443.dp)
                .rotate(92f),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )
    }
}

@Composable
private fun ProfileImageRecovery() {
    Box(
        modifier = Modifier
            .size(106.dp)
            .clip(CircleShape)
            .background(Color(0xFFFFF0F5))
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/cb391ad4-5f3b-4688-8fc4-08b62eba0016")
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
private fun CodeInputDots(code: String) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(29.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until 4) {
            val isFilled = i < code.length
            Box(
                modifier = Modifier.size(17.dp),
                contentAlignment = Alignment.Center
            ) {
                // Empty state circle
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/0ff01acf-4c9d-465a-866a-ab61f9bc7a2e")
                        .build(),
                    contentDescription = if (isFilled) "Code entered" else "Code empty",
                    modifier = Modifier.size(17.dp),
                    alpha = if (isFilled) 0f else 1f
                )

                // Filled state (we'll use a simple colored dot)
                if (isFilled) {
                    Box(
                        modifier = Modifier
                            .size(17.dp)
                            .clip(CircleShape)
                            .background(CodeBlue)
                    )
                }
            }
        }
    }
}

// Hidden text field to capture keyboard input
@Composable
private fun PasswordRecoveryCodeInput(
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
