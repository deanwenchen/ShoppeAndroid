package com.shoppe.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shoppe.android.navigation.Screen
import com.shoppe.android.ui.pages.CreateAccountPage
import com.shoppe.android.ui.pages.HelloCardPage
import com.shoppe.android.ui.pages.LoginPage
import com.shoppe.android.ui.pages.NewPasswordPage
import com.shoppe.android.ui.pages.PasswordPage
import com.shoppe.android.ui.pages.PasswordRecoveryCodePage
import com.shoppe.android.ui.pages.PasswordRecoveryPage
import com.shoppe.android.ui.pages.PasswordTypingPage
import com.shoppe.android.ui.pages.ProductDetailPage
import com.shoppe.android.ui.pages.ShopPage
import com.shoppe.android.ui.pages.StartPage
import com.shoppe.android.ui.pages.WrongPasswordPage
import com.shoppe.android.ui.theme.ShoppeAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppeAndroidTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.StartPage.route
    ) {
        composable(Screen.StartPage.route) {
            StartPage(
                onLetsGetStartedClick = {
                    navController.navigate(Screen.CreateAccountPage.route)
                },
                onAlreadyHaveAccountClick = {
                    navController.navigate(Screen.LoginPage.route)
                }
            )
        }

        composable(Screen.CreateAccountPage.route) {
            CreateAccountPage(
                onDoneClick = {
                    navController.navigate(Screen.HelloCardPage.route)
                },
                onCancelClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.LoginPage.route) {
            LoginPage(
                onDoneClick = {
                    navController.navigate(Screen.PasswordPage.route)
                },
                onCancelClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.PasswordPage.route) {
            PasswordPage(
                onPasswordComplete = {
                    navController.navigate(Screen.PasswordTypingPage.route)
                },
                onNotYouClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.PasswordTypingPage.route) {
            PasswordTypingPage(
                onPasswordComplete = {
                    navController.navigate(Screen.ShopPage.route)
                }
            )
        }

        composable(Screen.WrongPasswordPage.route) {
            WrongPasswordPage(
                onForgotPasswordClick = {
                    navController.navigate(Screen.PasswordRecoveryPage.route)
                },
                onPasswordComplete = {
                    // TODO: Implement wrong password retry logic
                    // Show error message and reset password input
                }
            )
        }

        composable(Screen.PasswordRecoveryPage.route) {
            PasswordRecoveryPage(
                onNextClick = {
                    navController.navigate(Screen.PasswordRecoveryCodePage.route)
                },
                onCancelClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.PasswordRecoveryCodePage.route) {
            PasswordRecoveryCodePage(
                onVerifyClick = {
                    navController.navigate(Screen.NewPasswordPage.route)
                },
                onCancelClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.NewPasswordPage.route) {
            NewPasswordPage(
                onSaveClick = {
                    navController.navigate(Screen.LoginPage.route) {
                        popUpTo(Screen.StartPage.route) { inclusive = true }
                    }
                },
                onCancelClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(Screen.HelloCardPage.route) {
            HelloCardPage(
                onComplete = {
                    navController.navigate(Screen.ShopPage.route) {
                        popUpTo(Screen.HelloCardPage.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.ShopPage.route) {
            ShopPage(
                onProductClick = { productId ->
                    navController.navigate(Screen.ProductDetailPage.route)
                },
                onCategoryClick = { categoryId ->
                    // TODO: Implement category navigation
                    // Navigate to category detail page or filter products
                }
            )
        }

        composable(Screen.ProductDetailPage.route) {
            ProductDetailPage(
                onBackClick = {
                    navController.popBackStack()
                },
                onAddToCartClick = {
                    // TODO: Implement add to cart logic
                    // Show snackbar and update cart count
                },
                onBuyNowClick = {
                    // TODO: Implement buy now checkout flow
                    // Navigate to checkout screen
                }
            )
        }
    }
}
