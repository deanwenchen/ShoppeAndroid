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
import com.shoppe.android.data.model.LoginResult
import com.shoppe.android.data.model.MockAuthService
import com.shoppe.android.ui.theme.ShoppeBlack
import com.shoppe.android.ui.theme.ShoppeWhite
import com.shoppe.android.ui.theme.BackgroundGrey
import com.shoppe.android.ui.theme.CodePink

@Composable
fun PasswordPage(
    userEmail: String,
    onNotYouClick: () -> Unit = {},
    onPasswordComplete: (String) -> Unit = {},
    onWrongPassword: () -> Unit = {}
) {
    var password by remember { mutableStateOf("") }
    var isWrongPassword by remember { mutableStateOf(false) }
    var showErrorMessage by remember { mutableStateOf(false) }

    // Password input handler with validation
    val handlePasswordComplete = { inputPassword: String ->
        val result = MockAuthService.verifyPassword(userEmail, inputPassword)
        when (result) {
            is LoginResult.Success -> {
                onPasswordComplete(inputPassword)
            }
            LoginResult.WrongPassword -> {
                isWrongPassword = true
                showErrorMessage = true
                // Reset after showing error
                password = ""
            }
            else -> {
                // Should not happen, but handle gracefully
                onPasswordComplete(inputPassword)
            }
        }
    }

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

            // Password input UI - switches between 4-dot and 8-dot states
            if (isWrongPassword) {
                // Error state: 8 red filled dots + "Forgot your password?" link
                WrongPasswordDots(
                    onForgotPasswordClick = {
                        isWrongPassword = false
                        showErrorMessage = false
                        password = ""
                        onWrongPassword()
                    }
                )

                Spacer(modifier = Modifier.height(240.dp))
            } else if (password.isNotEmpty()) {
                // 8-dot password entry state
                EightDotPasswordInput(
                    password = password,
                    onPasswordComplete = handlePasswordComplete
                )

                Spacer(modifier = Modifier.height(240.dp))
            } else {
                // Initial 4-dot empty state
                FourDotEmptyState()

                Spacer(modifier = Modifier.height(280.dp))
            }

            // Not you? link with arrow button (only shown when not in error state)
            if (!isWrongPassword) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { onNotYouClick() }
                ) {
                    Text(
                        text = "Not you?",
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
                                .data("https://www.figma.com/api/mcp/asset/f357ee9e-3646-4d9b-8c0a-fd6ea102eec5")
                                .build(),
                            contentDescription = "Arrow",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }

        // Hidden password input - supports up to 8 characters
        PasswordInputField(
            value = password,
            onValueChange = { newValue ->
                if (newValue.length <= 8) {
                    password = newValue
                    // Only validate when 8 characters are entered
                    if (newValue.length == 8 && !isWrongPassword) {
                        handlePasswordComplete(newValue)
                    }
                }
            }
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
                .data("https://www.figma.com/api/mcp/asset/e7b51c67-88a6-4113-a4da-1e51eebde31d")
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
                .data("https://www.figma.com/api/mcp/asset/6ac659c3-1705-4533-b908-27a3e2fd11a5")
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
                .data("https://www.figma.com/api/mcp/asset/5d4b2916-a5b5-40ef-83b7-b229fd7e84ea")
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

/**
 * Initial state: 4 empty boxes
 */
@Composable
private fun FourDotEmptyState() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until 4) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(BackgroundGrey)
            )
        }
    }
}

/**
 * Password entry state: 8 password dots
 */
@Composable
private fun EightDotPasswordInput(
    password: String,
    onPasswordComplete: (String) -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (i in 0 until 8) {
                val isFilled = i < password.length
                Box(
                    modifier = Modifier
                        .size(17.dp)
                        .clip(CircleShape)
                        .background(if (isFilled) ShoppeBlack else BackgroundGrey)
                )
            }
        }

        Spacer(modifier = Modifier.height(80.dp))

        // Hidden keyboard trigger
        TextField(
            value = password,
            onValueChange = { if (it.length <= 8) onPasswordComplete(it) },
            modifier = Modifier
                .size(1.dp)
                .alpha(0.01f),
            keyboardInput = true,
            singleLine = true,
            maxLines = 1
        )
    }
}

/**
 * Wrong password state: 8 red filled dots + "Forgot your password?" link
 */
@Composable
private fun WrongPasswordDots(
    onForgotPasswordClick: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // 8 red filled dots
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (i in 0 until 8) {
                Box(
                    modifier = Modifier
                        .size(17.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFFF0000))
                )
            }
        }

        Spacer(modifier = Modifier.height(80.dp))

        // Forgot your password? link
        Text(
            text = "Forgot your password?",
            fontSize = 15.sp,
            fontWeight = FontWeight.Light,
            color = ShoppeBlack.copy(alpha = 0.9f),
            modifier = Modifier.clickable { onForgotPasswordClick() }
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
                        .data("https://www.figma.com/api/mcp/asset/2a46432f-6257-409f-beb7-3bd5377ac51e")
                        .build(),
                    contentDescription = "Cellular",
                    modifier = Modifier.size(17.dp, 11.dp)
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/243249db-91d2-421c-8bd2-fab871d87797")
                        .build(),
                    contentDescription = "Wifi",
                    modifier = Modifier.size(15.dp, 11.dp)
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/f386b4f9-7c82-4c05-8324-43bcc839d9ac")
                        .build(),
                    contentDescription = "Battery",
                    modifier = Modifier.size(24.dp, 11.dp)
                )
            }
        }
    }
}
