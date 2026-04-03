package com.shoppe.android.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import kotlinx.coroutines.launch

// Onboarding page data
data class OnboardingPage(
    val imageUrl: String,
    val title: String,
    val description: String
)

val onboardingPages = listOf(
    OnboardingPage(
        imageUrl = "https://www.figma.com/api/mcp/asset/d07a1fda-132e-4163-8158-6a231cbc1ec4",
        title = "Hello",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non consectetur turpis. Morbi eu eleifend lacus."
    ),
    OnboardingPage(
        imageUrl = "https://www.figma.com/api/mcp/asset/d07a1fda-132e-4163-8158-6a231cbc1ec4",
        title = "Explore",
        description = "Discover amazing products and find your perfect style. Shop with confidence and ease."
    ),
    OnboardingPage(
        imageUrl = "https://www.figma.com/api/mcp/asset/d07a1fda-132e-4163-8158-6a231cbc1ec4",
        title = "Choose",
        description = "Select from thousands of items. Fast shipping and easy returns available."
    ),
    OnboardingPage(
        imageUrl = "https://www.figma.com/api/mcp/asset/d07a1fda-132e-4163-8158-6a231cbc1ec4",
        title = "Ready?",
        description = "You're all set! Let's start shopping and discover your style today."
    )
)

@Composable
fun HelloCardPage(
    onComplete: () -> Unit = {}
) {
    val pagerState = rememberPagerState(pageCount = { onboardingPages.size })
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ShoppeWhite)
    ) {
        // Status Bar
        StatusBar()

        // Decorative Bubbles
        DecorativeBubblesOnboarding()

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            // Pager content
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { page ->
                OnboardingCard(pageData = onboardingPages[page])
            }

            // Dot indicators
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                for (i in onboardingPages.indices) {
                    DotIndicator(
                        isActive = pagerState.currentPage == i,
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                scope.launch {
                                    pagerState.animateScrollToPage(i)
                                }
                            }
                    )
                }
            }

            // Let's Go button (only on last page)
            if (pagerState.currentPage == onboardingPages.lastIndex) {
                Surface(
                    color = ShoppeBlue,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .height(61.dp)
                        .clickable { onComplete() },
                    shadowElevation = 2.dp
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Let's Go",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Light,
                            color = Color(0xFFF3F3F3)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}

@Composable
private fun OnboardingCard(pageData: OnboardingPage) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Card with image
        Surface(
            color = ShoppeWhite,
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.85f),
            shadowElevation = 10.dp
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Image section
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(pageData.imageUrl)
                        .build(),
                    contentDescription = pageData.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentScale = ContentScale.Crop
                )

                // Content section
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = pageData.title,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = ShoppeBlack,
                        letterSpacing = (-0.28).sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = pageData.description,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Light,
                        color = ShoppeBlack,
                        lineHeight = 27.sp,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
private fun DotIndicator(isActive: Boolean, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        if (isActive) {
            // Active dot - blue filled
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://www.figma.com/api/mcp/asset/a0e9ee82-0518-4607-872e-3a132dd70ba5")
                    .build(),
                contentDescription = "Active page indicator",
                modifier = Modifier.size(20.dp)
            )
        } else {
            // Inactive dot - light blue
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://www.figma.com/api/mcp/asset/6001c44e-4c2a-493b-b217-a0f9c29006c5")
                    .build(),
                contentDescription = "Inactive page indicator",
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
private fun DecorativeBubblesOnboarding() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Bubble 02
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/99b1e9b2-3ca2-492a-94ea-da03056f0b86")
                .build(),
            contentDescription = "Decorative bubble",
            modifier = Modifier
                .offset(x = (-141).dp, y = 239.dp)
                .size(377.dp, 443.dp)
                .rotate(108f),
            contentScale = ContentScale.Crop,
            alpha = 0.5f
        )

        // Bubble 01
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/67470418-62b9-4fe7-809c-68559a92b6c0")
                .build(),
            contentDescription = "Decorative bubble",
            modifier = Modifier
                .offset(x = (-147).dp, y = (-123).dp)
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
                        .data("https://www.figma.com/api/mcp/asset/9fe4e5b2-4692-4e15-87c4-dc58c41443a3")
                        .build(),
                    contentDescription = "Cellular",
                    modifier = Modifier.size(17.dp, 11.dp)
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/8d1c29f5-4476-4ab9-83ff-6354f12d226a")
                        .build(),
                    contentDescription = "Wifi",
                    modifier = Modifier.size(15.dp, 11.dp)
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/54f1045c-7c79-4ea6-bb9d-9bf6e9ed3616")
                        .build(),
                    contentDescription = "Battery",
                    modifier = Modifier.size(24.dp, 11.dp)
                )
            }
        }
    }
}
