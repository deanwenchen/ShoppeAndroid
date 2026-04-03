package com.shoppe.android.data.model

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
