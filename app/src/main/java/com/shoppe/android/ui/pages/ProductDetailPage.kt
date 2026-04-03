package com.shoppe.android.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.shoppe.android.ui.theme.*

// Product data models
data class VariationImage(
    val imageUrl: String,
    val contentDescription: String
)

data class ProductDetail(
    val mainImage: String,
    val additionalImages: List<String>,
    val price: String,
    val description: String,
    val color: String,
    val size: String,
    val variationImages: List<VariationImage>
)

@Composable
fun ProductDetailPage(
    onBackClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onLikeClick: () -> Unit = {},
    onAddToCartClick: () -> Unit = {},
    onBuyNowClick: () -> Unit = {},
    onVariationClick: () -> Unit = {}
) {
    val product = remember {
        ProductDetail(
            mainImage = "https://www.figma.com/api/mcp/asset/8e9310b1-9848-4266-abaf-fc06d32bc520",
            additionalImages = listOf(
                "https://www.figma.com/api/mcp/asset/32eb245a-e30d-4d15-b57a-23a577c43459"
            ),
            price = "$17,00",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam arcu mauris, scelerisque eu mauris id, pretium pulvinar sapien.",
            color = "Pink",
            size = "M",
            variationImages = listOf(
                VariationImage(
                    "https://www.figma.com/api/mcp/asset/17572b11-b63b-406b-9673-21806ff3cf34",
                    "Pink outfit variation"
                ),
                VariationImage(
                    "https://www.figma.com/api/mcp/asset/ea0f9b06-6d77-4073-b801-0e1dccdb3e83",
                    "Floral dress variation"
                ),
                VariationImage(
                    "https://www.figma.com/api/mcp/asset/e8d44102-3ac9-4c4b-b09c-f082fdba2f73",
                    "White dress variation"
                )
            )
        )
    }

    var currentPage by remember { mutableStateOf(0) }
    val totalImages = 5 // From Figma design

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(ShoppeWhite)
    ) {
        // Status Bar
        item {
            StatusBar()
        }

        // Product Image Carousel
        item {
            ProductImageCarousel(
                mainImage = product.mainImage,
                additionalImages = product.additionalImages,
                currentPage = currentPage,
                totalImages = totalImages,
                onPageChange = { currentPage = it }
            )
        }

        // Share Button
        item {
            ShareButton(onShareClick = onShareClick)
        }

        // Price
        item {
            PriceDisplay(price = product.price)
        }

        // Description
        item {
            ProductDescription(description = product.description)
        }

        // Variations Section
        item {
            VariationsSection(
                color = product.color,
                size = product.size,
                variationImages = product.variationImages,
                onVariationClick = onVariationClick
            )
        }

        // Bottom Action Bar
        item {
            BottomActionBar(
                onLikeClick = onLikeClick,
                onAddToCartClick = onAddToCartClick,
                onBuyNowClick = onBuyNowClick
            )
        }

        // Bottom padding for navigation bar
        item {
            Spacer(modifier = Modifier.height(100.dp))
        }
    }
}

@Composable
fun StatusBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Time
        Text(
            text = "9:41",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )

        // Status icons
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Cellular signal
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://www.figma.com/api/mcp/asset/6308b0c3-6e13-4cf6-9dd6-885186b53693")
                    .build(),
                contentDescription = "Cellular signal",
                modifier = Modifier.size(17.dp, 11.dp)
            )

            // Wifi
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://www.figma.com/api/mcp/asset/75f41cd1-dd4d-40e2-95fb-e8034dc00865")
                    .build(),
                contentDescription = "Wifi",
                modifier = Modifier.size(15.dp, 11.dp)
            )

            // Battery
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://www.figma.com/api/mcp/asset/19de4cfa-d03b-4ca1-acee-8dec13498c1b")
                    .build(),
                contentDescription = "Battery",
                modifier = Modifier.size(24.dp, 11.dp)
            )
        }
    }
}

@Composable
fun ProductImageCarousel(
    mainImage: String,
    additionalImages: List<String>,
    currentPage: Int,
    totalImages: Int,
    onPageChange: (Int) -> Unit
) {
    Column {
        // Main image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(439.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(mainImage)
                    .build(),
                contentDescription = "Product image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        // Dot indicators
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (i in 0 until totalImages) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(if (i == currentPage) ShoppeBlue else Grey20)
                )
                if (i < totalImages - 1) {
                    Spacer(modifier = Modifier.width(10.dp))
                }
            }
        }
    }
}

@Composable
fun ShareButton(onShareClick: () -> Unit) {
    Box(
        modifier = Modifier
            .offset(x = 325.dp, y = (-20).dp)
            .size(30.dp)
            .clip(CircleShape)
            .background(Color(0xFFFFEBEB))
            .clickable { onShareClick() },
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/972b5f5b-2259-4693-8e3f-44003c6a509d")
                .build(),
            contentDescription = "Share",
            modifier = Modifier.size(14.dp)
        )
    }
}

@Composable
fun PriceDisplay(price: String) {
    Text(
        text = price,
        fontSize = 26.sp,
        fontWeight = FontWeight.ExtraBold,
        color = Color.Black,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 8.dp)
    )
}

@Composable
fun ProductDescription(description: String) {
    Text(
        text = description,
        fontSize = 15.sp,
        fontWeight = FontWeight.Normal,
        color = Color.Black,
        lineHeight = 20.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 8.dp)
    )
}

@Composable
fun VariationsSection(
    color: String,
    size: String,
    variationImages: List<VariationImage>,
    onVariationClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 8.dp)
    ) {
        // Section header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Variations",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black
            )

            // Expand button
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(ShoppeBlue)
                    .clickable { onVariationClick() },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "→",
                    fontSize = 18.sp,
                    color = ShoppeWhite
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Selected variation chips
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Color chip
            Surface(
                color = BackgroundGrey,
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .width(80.dp)
                    .height(32.dp),
                shadowElevation = 2.dp
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = color,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                }
            }

            // Size chip
            Surface(
                color = BackgroundGrey,
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .width(80.dp)
                    .height(32.dp),
                shadowElevation = 2.dp
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = size,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Variation images
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(variationImages) { variation ->
                VariationImageCard(variation = variation)
            }
        }
    }
}

@Composable
fun VariationImageCard(variation: VariationImage) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(variation.imageUrl)
            .build(),
        contentDescription = variation.contentDescription,
        modifier = Modifier
            .size(75.dp, 75.dp)
            .clip(RoundedCornerShape(5.dp)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun BottomActionBar(
    onLikeClick: () -> Unit,
    onAddToCartClick: () -> Unit,
    onBuyNowClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(84.dp)
            .background(ShoppeWhite)
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Like button
            Surface(
                color = BackgroundGrey,
                shape = RoundedCornerShape(11.dp),
                modifier = Modifier
                    .size(48.dp),
                shadowElevation = 2.dp
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://www.figma.com/api/mcp/asset/0598c781-c0de-4b0a-93d0-8f5fadb66ab4")
                            .build(),
                        contentDescription = "Like",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            // Add to Cart button
            Surface(
                color = ShoppeBlack,
                shape = RoundedCornerShape(11.dp),
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                shadowElevation = 2.dp
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Add to cart",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light,
                        color = Color(0xFFF3F3F3)
                    )
                }
            }

            // Buy Now button
            Surface(
                color = ShoppeBlue,
                shape = RoundedCornerShape(11.dp),
                modifier = Modifier
                    .weight(1.5f)
                    .height(50.dp),
                shadowElevation = 2.dp
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Buy now",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light,
                        color = Color(0xFFF3F3F3)
                    )
                }
            }
        }
    }
}
