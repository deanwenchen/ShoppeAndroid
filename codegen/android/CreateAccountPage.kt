package com.shoppe.android.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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

@Composable
fun CreateAccountPage(
    onDoneClick: () -> Unit = {},
    onCancelClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ShoppeWhite)
    ) {
        // Status Bar
        StatusBar()

        // Decorative Bubbles
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/b1ae1d1b-05cd-4167-bcc8-87d73f01d378")
                .build(),
            contentDescription = "Decorative bubbles",
            modifier = Modifier
                .offset(x = (-132).dp, y = (-206).dp)
                .size(659.dp, 513.dp),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            // Title
            Text(
                text = "Create\nAccount",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = ShoppeBlack,
                lineHeight = 54.sp,
                letterSpacing = (-0.5).sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Upload Photo Button
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .border(
                        width = 2.dp,
                        dash = intArrayOf(6.dp, 4.dp),
                        color = ShoppeBlue,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/ea0be292-b240-4cd0-ad72-8d998fc4df87")
                        .build(),
                    contentDescription = "Upload photo",
                    modifier = Modifier.size(60.dp)
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

            Spacer(modifier = Modifier.height(16.dp))

            // Password Field
            TextField(
                value = password,
                onValueChange = { password = it },
                placeholder = {
                    Text(
                        text = "Password",
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
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                singleLine = true,
                trailingIcon = {
                    IconButton(onClick = { showPassword = !showPassword }) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data("https://www.figma.com/api/mcp/asset/dcdfc0ad-7d11-4eef-8674-23dd7bb68447")
                                .build(),
                            contentDescription = if (showPassword) "Show password" else "Hide password",
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Phone Number Field
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .clip(RoundedCornerShape(60.dp))
                    .background(BackgroundGrey)
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Country Code Selector
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // UK Flag
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://www.figma.com/api/mcp/asset/1e0390f2-4d00-4ecf-aa55-44a157dcc04e")
                            .build(),
                        contentDescription = "UK Flag",
                        modifier = Modifier
                            .size(24.dp, 18.dp)
                            .clip(RoundedCornerShape(2.dp))
                    )

                    // Dropdown Arrow
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://www.figma.com/api/mcp/asset/6bccebf8-0036-45dd-a26b-720e5ed25406")
                            .build(),
                        contentDescription = "Dropdown",
                        modifier = Modifier.size(16.dp)
                    )
                }

                // Vertical Divider
                Box(
                    modifier = Modifier
                        .height(24.dp)
                        .width(1.dp)
                        .background(Color(0xFFD2D2D2))
                )

                // Phone Number Input
                TextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    placeholder = {
                        Text(
                            text = "Your number",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Grey20
                        )
                    },
                    modifier = Modifier.weight(1f),
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
            }

            Spacer(modifier = Modifier.height(80.dp))

            // Done Button
            Surface(
                color = ShoppeBlue,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(61.dp)
                    .clickable { onDoneClick() },
                shadowElevation = 2.dp
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Done",
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
                        .data("https://www.figma.com/api/mcp/asset/385f4cdd-08f0-4624-9307-8be543d77adb")
                        .build(),
                    contentDescription = "Cellular",
                    modifier = Modifier.size(17.dp, 11.dp)
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/7edd0c69-a29f-4c35-a744-06ab4ca6ad9d")
                        .build(),
                    contentDescription = "Wifi",
                    modifier = Modifier.size(15.dp, 11.dp)
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/216eb1ec-918d-412d-b9ec-ab38fffe99e8")
                        .build(),
                    contentDescription = "Battery",
                    modifier = Modifier.size(24.dp, 11.dp)
                )
            }
        }
    }
}
