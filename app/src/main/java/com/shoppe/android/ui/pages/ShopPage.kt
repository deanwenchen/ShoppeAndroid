package com.shoppe.android.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kotlinx.coroutines.launch

// Design Tokens
val ShoppeBlue = Color(0xFF004CFF)
val ShoppeBlack = Color(0xFF202020)
val ShoppeWhite = Color(0xFFFFFFFF)
val BackgroundGrey = Color(0xFFF8F8F8)
val Grey20 = Color(0xFFD2D2D2)
val DiscountGradientStart = Color(0xFFFF5790)
val DiscountGradientEnd = Color(0xFFF81140)

@Composable
fun ShopPage(
    onProductClick: (Int) -> Unit = {},
    onCategoryClick: (String) -> Unit = {},
    onSearchClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ShoppeWhite)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            // Status Bar
            item { StatusBar() }

            // Header: Shop title + Search
            item { ShopHeader(onSearchClick = onSearchClick) }

            // Big Sale Banner
            item { BigSaleBanner() }

            // Categories Section
            item { CategoriesSection(onCategoryClick = onCategoryClick) }

            // Top Products
            item { TopProductsSection() }

            // New Items
            item { NewItemsSection(onProductClick = onProductClick) }

            // Flash Sale
            item { FlashSaleSection(onProductClick = onProductClick) }

            // Most Popular
            item { MostPopularSection(onProductClick = onProductClick) }

            // Just For You
            item { JustForYouSection(onProductClick = onProductClick) }

            // Bottom Navigation Bar
            item { BottomNavBar() }

            // Spacer for bottom nav
            item { Spacer(modifier = Modifier.height(100.dp)) }
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
                        .data("https://www.figma.com/api/mcp/asset/2c69fa6a-c4a7-49a0-bce7-e44f5326b6a0")
                        .build(),
                    contentDescription = "Cellular",
                    modifier = Modifier.size(17.dp, 11.dp)
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/7f86a06b-d5ff-41e5-95fa-7209121b6805")
                        .build(),
                    contentDescription = "Wifi",
                    modifier = Modifier.size(15.dp, 11.dp)
                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/5d0f5f61-361e-43a5-b2b2-084bcd75055e")
                        .build(),
                    contentDescription = "Battery",
                    modifier = Modifier.size(24.dp, 11.dp)
                )
            }
        }
    }
}

@Composable
private fun ShopHeader(onSearchClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 10.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Shop Title
            Text(
                text = "Shop",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = ShoppeBlack,
                letterSpacing = (-0.28).sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Search Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(36.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(BackgroundGrey)
                    .clickable { onSearchClick() }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Search",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFC7C7C7)
                    )

                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://www.figma.com/api/mcp/asset/9fa70ce9-6a6c-4b8f-8976-12fbda5192a5")
                            .build(),
                        contentDescription = "Search",
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun BigSaleBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
    ) {
        // Banner background with image
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/3e13742f-dc3f-445f-bdb1-9682256e7181")
                .build(),
            contentDescription = "Big Sale Banner",
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(9.dp)),
            contentScale = ContentScale.Crop
        )

        // Decorative bubbles
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/c0ffb1be-2bf4-4989-8f18-decfd72d9fd8")
                .build(),
            contentDescription = "Bubble",
            modifier = Modifier
                .size(150.dp)
                .offset(x = 50.dp, y = (-30).dp),
            alpha = 0.6f
        )

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.figma.com/api/mcp/asset/185adce5-529c-4d17-9d62-53050c494281")
                .build(),
            contentDescription = "Bubble",
            modifier = Modifier
                .size(180.dp)
                .offset(x = (-50).dp, y = 20.dp),
            alpha = 0.6f
        )

        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(
                text = "Big Sale",
                fontSize = 29.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                letterSpacing = (-0.29).sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Up to 50%",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Happening\nNow",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                lineHeight = 15.sp
            )
        }

        // Timer controls at bottom
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp)
                .height(10.dp)
                .width(120.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://www.figma.com/api/mcp/asset/572c4a07-daaf-4efc-933f-b4e3d91ecac2")
                    .build(),
                contentDescription = "Timer controls",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
private fun CategoriesSection(onCategoryClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Categories",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = ShoppeBlack,
                letterSpacing = (-0.21).sp
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "See All",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = ShoppeBlack
                )

                // Arrow button
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .clickable { }
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://www.figma.com/api/mcp/asset/4cd4199d-88c2-41af-9360-c405f2ec3d18")
                            .build(),
                        contentDescription = "Arrow",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(4.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Categories grid - 2 columns, 3 rows
        val categories = listOf(
            CategoryItem("Clothing", 109, "https://www.figma.com/api/mcp/asset/501cd83d-5d0c-4a2e-b9f3-6c8d56b03598"),
            CategoryItem("Shoes", 530, "https://www.figma.com/api/mcp/asset/ebed0a95-c8d1-4405-9a18-64a26e2cc1d9"),
            CategoryItem("Bags", 87, "https://www.figma.com/api/mcp/asset/2aa80842-558d-4160-a98a-5278a020c4b6"),
            CategoryItem("Lingerie", 218, "https://www.figma.com/api/mcp/asset/d3340cd6-c4aa-48e8-9594-1c3b9614eefc"),
            CategoryItem("Watch", 218, "https://www.figma.com/api/mcp/asset/731d40e1-4cd7-403b-8ab8-787e865018ad"),
            CategoryItem("Hoodies", 218, "https://www.figma.com/api/mcp/asset/9b182209-1661-4151-b702-8986f83c59b8")
        )

        categories.chunked(2).forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                row.forEach { category ->
                    CategoryCard(
                        category = category,
                        modifier = Modifier.weight(1f),
                        onClick = { onCategoryClick(category.name) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

data class CategoryItem(
    val name: String,
    val count: Int,
    val imageUrl: String
)

@Composable
private fun CategoryCard(
    category: CategoryItem,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .height(120.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(9.dp),
        shadowElevation = 5.dp,
        color = ShoppeWhite
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // 2x2 grid of images
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(category.imageUrl)
                            .build(),
                        contentDescription = category.name,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(5.dp)),
                        contentScale = ContentScale.Crop
                    )
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(category.imageUrl)
                            .build(),
                        contentDescription = category.name,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(5.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(category.imageUrl)
                            .build(),
                        contentDescription = category.name,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(5.dp)),
                        contentScale = ContentScale.Crop
                    )
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(category.imageUrl)
                            .build(),
                        contentDescription = category.name,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(5.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            // Category name
            Text(
                text = category.name,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = ShoppeBlack,
                letterSpacing = (-0.17).sp,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(10.dp)
            )

            // Item count badge
            Surface(
                color = Color(0xFFDFE9FF),
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(10.dp)
                    .width(38.dp)
                    .height(20.dp),
                shadowElevation = 1.dp
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = category.count.toString(),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = ShoppeBlack
                    )
                }
            }
        }
    }
}

@Composable
private fun TopProductsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
    ) {
        Text(
            text = "Top Products",
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            color = ShoppeBlack,
            letterSpacing = (-0.21).sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val products = listOf("Dresses", "T-Shirts", "Skirts", "Shoes", "Bags")
            val images = listOf(
                "https://www.figma.com/api/mcp/asset/d4ed37ec-c391-4257-98a6-c8e2f47d5752",
                "https://www.figma.com/api/mcp/asset/1f2a9e4a-deee-4bf7-a04e-15a78bbec43a",
                "https://www.figma.com/api/mcp/asset/890a9fdb-86ea-4f3e-a451-a9ed0858d4a9",
                "https://www.figma.com/api/mcp/asset/ebed0a95-c8d1-4405-9a18-64a26e2cc1d9",
                "https://www.figma.com/api/mcp/asset/2aa80842-558d-4160-a98a-5278a020c4b6"
            )

            items(products.size) { index ->
                TopProductItem(
                    name = products[index],
                    imageUrl = images[index]
                )
            }
        }
    }
}

@Composable
private fun TopProductItem(name: String, imageUrl: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .build(),
                contentDescription = name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = name,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = ShoppeBlack,
            letterSpacing = (-0.13).sp
        )
    }
}

@Composable
private fun NewItemsSection(onProductClick: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "New Items",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = ShoppeBlack,
                letterSpacing = (-0.21).sp
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "See All",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = ShoppeBlack
                )

                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(RoundedCornerShape(12.dp))
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://www.figma.com/api/mcp/asset/4cd4199d-88c2-41af-9360-c405f2ec3d18")
                            .build(),
                        contentDescription = "Arrow",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(4.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Products row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            val products = listOf(
                ProductItem("https://www.figma.com/api/mcp/asset/bca8ec86-aa92-48c2-ade9-e12d4f656888", "$17,00"),
                ProductItem("https://www.figma.com/api/mcp/asset/ebed0a95-c8d1-4405-9a18-64a26e2cc1d9", "$32,00"),
                ProductItem("https://www.figma.com/api/mcp/asset/209c9733-3aed-4208-b674-a3c47b7cd94e", "$21,00")
            )

            products.forEach { product ->
                NewItemCard(
                    product = product,
                    modifier = Modifier.weight(1f),
                    onClick = { onProductClick(0) }
                )
            }
        }
    }
}

data class ProductItem(
    val imageUrl: String,
    val price: String
)

@Composable
private fun NewItemCard(
    product: ProductItem,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.85f),
            shape = RoundedCornerShape(9.dp),
            shadowElevation = 5.dp,
            color = ShoppeWhite
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.imageUrl)
                    .build(),
                contentDescription = "Product",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = product.price,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            color = ShoppeBlack,
            letterSpacing = (-0.17).sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Lorem ipsum dolor sit amet consectetur.",
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            lineHeight = 16.sp,
            maxLines = 2
        )
    }
}

@Composable
private fun FlashSaleSection(onProductClick: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
    ) {
        // Header with timer
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/b973c5a2-9d70-4722-ac9f-6305f95129fc")
                        .build(),
                    contentDescription = "Clock",
                    modifier = Modifier.size(20.dp)
                )

                Text(
                    text = "Flash Sale",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = ShoppeBlack,
                    letterSpacing = (-0.21).sp
                )
            }

            // Timer display
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                listOf("00", "36", "58").forEach { time ->
                    Box(
                        modifier = Modifier
                            .size(27.dp)
                            .clip(RoundedCornerShape(7.dp))
                            .background(Color(0xFFF3F3F3)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = time,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = ShoppeBlack,
                            letterSpacing = (-0.17).sp
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Products grid - 2 rows, 3 columns
        val products = listOf(
            FlashSaleProduct("https://www.figma.com/api/mcp/asset/e7c8f6bd-1ff6-465a-b172-b623da9ec8a6", "-20%"),
            FlashSaleProduct("https://www.figma.com/api/mcp/asset/cddcb203-65a1-4ef9-b823-3bb11fca34de", "-20%"),
            FlashSaleProduct("https://www.figma.com/api/mcp/asset/9d91dbd4-7776-4129-a0f2-2a26a1f6591b", "-20%"),
            FlashSaleProduct("https://www.figma.com/api/mcp/asset/45D808E05E004D2A9Bdc5Ed6F427010E", "-20%"),
            FlashSaleProduct("https://www.figma.com/api/mcp/asset/c94032b3-633f-4e52-91ff-28e7356c4936", "-20%"),
            FlashSaleProduct("https://www.figma.com/api/mcp/asset/8a0b928c-83cf-4830-8e33-c67ce55aca31", "-20%")
        )

        products.chunked(3).forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                row.forEach { product ->
                    FlashSaleCard(
                        product = product,
                        modifier = Modifier.weight(1f),
                        onClick = { onProductClick(0) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}

data class FlashSaleProduct(
    val imageUrl: String,
    val discount: String
)

@Composable
private fun FlashSaleCard(
    product: FlashSaleProduct,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .aspectRatio(0.85f)
            .clickable { onClick() },
        shape = RoundedCornerShape(9.dp),
        shadowElevation = 5.dp,
        color = ShoppeWhite
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.imageUrl)
                    .build(),
                contentDescription = "Product",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Discount badge
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(DiscountGradientStart, DiscountGradientEnd)
                        ),
                        shape = RoundedCornerShape(
                            topStart = 5.dp,
                            topEnd = 5.dp,
                            bottomStart = 5.dp
                        )
                    )
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = product.discount,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
private fun MostPopularSection(onProductClick: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Most Popular",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = ShoppeBlack,
                letterSpacing = (-0.21).sp
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "See All",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = ShoppeBlack
                )

                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(RoundedCornerShape(12.dp))
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://www.figma.com/api/mcp/asset/4cd4199d-88c2-41af-9360-c405f2ec3d18")
                            .build(),
                        contentDescription = "Arrow",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(4.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Products horizontal scroll
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            val products = listOf(
                PopularProduct("https://www.figma.com/api/mcp/asset/cd9d8281-84ed-400c-a310-8eadfda8cd7d", "1780", "New"),
                PopularProduct("https://www.figma.com/api/mcp/asset/e7c8f6bd-1ff6-465a-b172-b623da9ec8a6", "1780", "Sale"),
                PopularProduct("https://www.figma.com/api/mcp/asset/147bc846-72b5-467f-834b-95bf9aac1b23", "1780", "Hot"),
                PopularProduct("https://www.figma.com/api/mcp/asset/c94032b3-633f-4e52-91ff-28e7356c4936", "1780", "Hot")
            )

            items(products.size) { index ->
                PopularProductCard(
                    product = products[index],
                    onClick = { onProductClick(0) }
                )
            }
        }
    }
}

data class PopularProduct(
    val imageUrl: String,
    val count: String,
    val tag: String
)

@Composable
private fun PopularProductCard(
    product: PopularProduct,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(140.dp)
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            modifier = Modifier
                .size(140.dp),
            shape = RoundedCornerShape(9.dp),
            shadowElevation = 5.dp,
            color = ShoppeWhite
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(product.imageUrl)
                        .build(),
                    contentDescription = "Product",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Like icon
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/9f436281-92cb-4b66-8a47-eb3885e6b844")
                        .build(),
                    contentDescription = "Like",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(24.dp)
                        .padding(4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = product.count,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            letterSpacing = (-0.15).sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = product.tag,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = ShoppeBlack,
            letterSpacing = (-0.13).sp
        )
    }
}

@Composable
private fun JustForYouSection(onProductClick: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
    ) {
        // Header with star mark
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Just For You",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = ShoppeBlack,
                letterSpacing = (-0.21).sp
            )

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://www.figma.com/api/mcp/asset/6f014ecb-58c7-4c9e-9d46-620a11386a1e")
                    .build(),
                contentDescription = "Star",
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Products grid - 2 columns
        val products = listOf(
            ProductItem("https://www.figma.com/api/mcp/asset/a7c7da00-c6d3-4b83-afa1-eb1cd3975a54", "$17,00"),
            ProductItem("https://www.figma.com/api/mcp/asset/970b3f5f-af43-436a-9aa3-9d5381f2dec5", "$17,00"),
            ProductItem("https://www.figma.com/api/mcp/asset/8a0b928c-83cf-4830-8e33-c67ce55aca31", "$17,00"),
            ProductItem("https://www.figma.com/api/mcp/asset/c94032b3-633f-4e52-91ff-28e7356c4936", "$17,00")
        )

        products.chunked(2).forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                row.forEach { product ->
                    JustForYouCard(
                        product = product,
                        modifier = Modifier.weight(1f),
                        onClick = { onProductClick(0) }
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
private fun JustForYouCard(
    product: ProductItem,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .clickable { onClick() }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.85f),
            shape = RoundedCornerShape(9.dp),
            shadowElevation = 5.dp,
            color = ShoppeWhite
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.imageUrl)
                    .build(),
                contentDescription = "Product",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = product.price,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            color = ShoppeBlack,
            letterSpacing = (-0.17).sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Lorem ipsum dolor sit amet consectetur",
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            lineHeight = 16.sp,
            maxLines = 2
        )
    }
}

@Composable
private fun BottomNavBar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(84.dp),
        color = ShoppeWhite,
        shadowElevation = 5.dp
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Home
                BottomNavItem(
                    icon = "https://www.figma.com/api/mcp/asset/5414e1c4-b6aa-483c-a16b-44fc25bce190",
                    active = false,
                    onClick = {}
                )

                // Categories
                BottomNavItem(
                    icon = "https://www.figma.com/api/mcp/asset/1494aa16-9b1d-4947-9e42-81eadb202c01",
                    active = false,
                    onClick = {}
                )

                // Cart (active)
                BottomNavItem(
                    icon = "https://www.figma.com/api/mcp/asset/8df5c9d5-bd1a-408b-9662-bebf224f2ea0",
                    active = true,
                    onClick = {}
                )

                // Wishlist
                BottomNavItem(
                    icon = "https://www.figma.com/api/mcp/asset/30b037ea-a34b-4241-b66e-0dc5bbe35591",
                    active = false,
                    onClick = {}
                )

                // Profile
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(BackgroundGrey)
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://www.figma.com/api/mcp/asset/fc941d82-fe4c-40fa-ab88-14f8600c5205")
                            .build(),
                        contentDescription = "Profile",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            // Home indicator
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 9.dp)
                    .size(width = 134.dp, height = 5.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(Color.Black)
            )
        }
    }
}

@Composable
private fun BottomNavItem(
    icon: String,
    active: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(icon)
                    .build(),
                contentDescription = "Nav Item",
                modifier = Modifier.size(24.dp)
            )

            if (active) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://www.figma.com/api/mcp/asset/ac8e1810-dad7-4474-abb3-084ba36de565")
                        .build(),
                    contentDescription = "Active indicator",
                    modifier = Modifier
                        .size(9.dp)
                        .padding(top = 2.dp)
                )
            }
        }
    }
}
