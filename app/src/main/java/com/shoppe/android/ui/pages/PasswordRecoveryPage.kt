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

@Composable
fun PasswordRecoveryPage(
    onSmsSelected: () -> Unit = {},
    onEmailSelected: () -> Unit = {},
    onNextClick: () -> Unit = {},
    onCancelClick: () -> Unit = {}
) {
    var selectedOption by remember { mutableStateOf("sms") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ShoppeWhite)
    ) {
        // Status Bar
        StatusBarLight()

        // Decorative Bubbles
        DecorativeBubbles()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(120.dp))

            // Profile Image
            ProfileImage()

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
                text = "How you would like to restore\nyour password?",
                fontSize = 19.sp,
                fontWeight = FontWeight.Light,
                color = ShoppeBlack.copy(alpha = 0.9f),
                lineHeight = 27.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            // SMS Option
            RecoveryOption(
                label = "SMS",
                isSelected = selectedOption == "sms",
                backgroundColor = Color(0xFFE5EBFC),
                textColor = ShoppeBlue,
                onOptionSelected = {
                    selectedOption = "sms"
                    onSmsSelected()
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Email Option
            RecoveryOption(
                label = "Email",
                isSelected = selectedOption == "email",
                backgroundColor = Color(0xFFFFEBEB),
                textColor = ShoppeBlack,
                onOptionSelected = {
                    selectedOption = "email"
                    onEmailSelected()
                }
            )

            Spacer(modifier = Modifier.height(80.dp))

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
private fun StatusBarLight() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
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
                        .data("https://www.figma.com/api/mcp/asset/6869b642-b279-4b64-b02a-de507ca2cfa4")
                        .build(),
                    contentDescription = "Cellular",
                    modifier = Modifier.size(17.dp, 11.dp)
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/32a1e6b0-c0cb-4870-b9f6-63868a77effe")
                        .build(),
                    contentDescription = "Wifi",
                    modifier = Modifier.size(15.dp, 11.dp)
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/e738ede0-066b-49f8-bfe7-8afea33f5061")
                        .build(),
                    contentDescription = "Battery",
                    modifier = Modifier.size(24.dp, 11.dp)
                )
            }
        }
    }
}

@Composable
private fun DecorativeBubbles() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        // Bubble 02
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/a3fd5b3e-1941-4e55-8c67-f02dcd22f951")
                .build(),
            contentDescription = "Decorative bubble",
            modifier = Modifier
                .offset(x = 20.dp, y = (-240).dp)
                .size(374.dp, 443.dp)
                .rotate(-110f),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )

        // Bubble 01
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/5f5da21f-c0c4-487b-954b-5857e8c434f9")
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
private fun ProfileImage() {
    Box(
        modifier = Modifier
            .size(106.dp)
            .clip(CircleShape)
            .background(Color(0xFFFFF0F5))
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/c4f0d08e-b3c3-40a1-88c6-7b9d90ba3b52")
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
private fun RecoveryOption(
    label: String,
    isSelected: Boolean,
    backgroundColor: Color,
    textColor: Color,
    onOptionSelected: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(backgroundColor)
            .clickable { onOptionSelected() },
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                fontSize = 15.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = textColor
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Check icon or empty circle
            if (isSelected) {
                Box(
                    modifier = Modifier.size(18.dp),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://www.figma.com/api/mcp/asset/276ea97b-a5e1-4b47-a65c-38dd023b5092")
                            .build(),
                        contentDescription = "Selected",
                        modifier = Modifier.size(16.dp)
                    )
                }
            } else {
                Box(
                    modifier = Modifier.size(18.dp),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://www.figma.com/api/mcp/asset/168e48bf-afcb-4b09-9f72-63fb5d4846ff")
                            .build(),
                        contentDescription = "Not selected",
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}
