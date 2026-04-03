package com.shoppe.android.navigation

sealed class Screen(val route: String) {
    object StartPage : Screen("start_page")
    object CreateAccountPage : Screen("create_account_page")
    object LoginPage : Screen("login_page")
    object PasswordPage : Screen("password_page")
    object PasswordTypingPage : Screen("password_typing_page")
    object WrongPasswordPage : Screen("wrong_password_page")
    object PasswordRecoveryPage : Screen("password_recovery_page")
    object PasswordRecoveryCodePage : Screen("password_recovery_code_page")
    object NewPasswordPage : Screen("new_password_page")
    object HelloCardPage : Screen("hello_card_page")
    object ShopPage : Screen("shop_page")
    object ProductDetailPage : Screen("product_detail_page")

    companion object {
        fun passwordPageWithEmail(email: String): String {
            return "password_page/$email"
        }
    }
}
