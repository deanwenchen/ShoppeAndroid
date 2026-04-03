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
import com.shoppe.android.ui.theme.ShoppeBlack
import com.shoppe.android.ui.theme.ShoppeBlue
import com.shoppe.android.ui.theme.ShoppeWhite
import com.shoppe.android.ui.theme.BackgroundGrey

@Composable
fun NewPasswordPage(
    onSaveClick: () -> Unit = {},
    onCancelClick: () -> Unit = {}
) {
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showNewPassword by remember { mutableStateOf(false) }
    var showConfirmPassword by remember { mutableStateOf(false) }

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
            ProfileImageNewPassword()

            Spacer(modifier = Modifier.height(24.dp))

            // Title
            Text(
                text = "Setup New Password",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = ShoppeBlack
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Subtitle
            Text(
                text = "Please, setup a new password for\nyour account",
                fontSize = 19.sp,
                fontWeight = FontWeight.Light,
                color = ShoppeBlack.copy(alpha = 0.9f),
                lineHeight = 27.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            // New Password Field
            PasswordInputField(
                value = newPassword,
                onValueChange = { newPassword = it },
                placeholder = "New Password",
                showPassword = showNewPassword,
                onToggleVisibility = { showNewPassword = !showNewPassword }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Confirm Password Field
            PasswordInputField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                placeholder = "Repeat Password",
                showPassword = showConfirmPassword,
                onToggleVisibility = { showConfirmPassword = !showConfirmPassword }
            )

            Spacer(modifier = Modifier.height(80.dp))

            // Save Button
            Surface(
                color = ShoppeBlue,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(61.dp)
                    .clickable { onSaveClick() },
                shadowElevation = 2.dp
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Save",
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
    }
}

@Composable
private fun ProfileImageNewPassword() {
    Box(
        modifier = Modifier
            .size(106.dp)
            .clip(CircleShape)
            .background(Color(0xFFFFF0F5))
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/7675eabd-fad5-42a6-9f6c-96ea94dad7b2")
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
private fun PasswordInputField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    showPassword: Boolean,
    onToggleVisibility: () -> Unit
) {
    Surface(
        color = BackgroundGrey,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = value,
                onValueChange = onValueChange,
                placeholder = {
                    Text(
                        text = placeholder,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFFD2D2D2)
                    )
                },
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardActions = KeyboardActions.Default,
                singleLine = true,
                modifier = Modifier.weight(1f),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = ShoppeBlack,
                    unfocusedTextColor = ShoppeBlack,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            // Show/Hide toggle - simplified for now
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onToggleVisibility() },
                contentAlignment = Alignment.Center
            ) {
                // Eye icon placeholder - can be replaced with actual icon
                Text(
                    text = if (showPassword) "👁" else "👁",
                    fontSize = 14.sp
                )
            }
        }
    }
}
