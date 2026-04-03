package com.shoppe.android.data.model

data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val originalPrice: Double? = null,
    val rating: Float = 0f,
    val reviewCount: Int = 0,
    val imageUrl: String,
    val images: List<String> = emptyList(),
    val description: String = "",
    val variations: List<Variation> = emptyList(),
    val isFavorite: Boolean = false
)

data class Variation(
    val id: String,
    val type: VariationType,
    val name: String,
    val imageUrl: String? = null,
    val priceDelta: Double = 0.0
)

enum class VariationType {
    COLOR,
    SIZE,
    MATERIAL
}

data class ProductReview(
    val id: String,
    val userName: String,
    val userAvatar: String? = null,
    val rating: Float,
    val comment: String,
    val date: String,
    val images: List<String> = emptyList()
)
