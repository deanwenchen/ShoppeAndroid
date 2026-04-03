package com.shoppe.android.data.model

data class Category(
    val id: String,
    val name: String,
    val imageUrl: String,
    val itemCount: Int = 0
)

data class Banner(
    val id: String,
    val imageUrl: String,
    val linkUrl: String? = null,
    val title: String? = null
)

data class FlashSale(
    val id: String,
    val productId: String,
    val productName: String,
    val salePrice: Double,
    val originalPrice: Double,
    val discountPercent: Int,
    val endTime: Long,
    val soldCount: Int,
    val totalCount: Int
)
