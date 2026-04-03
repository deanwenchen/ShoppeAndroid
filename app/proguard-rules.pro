# Add project specific ProGuard rules here.

# ============================================
# Coil Image Loading
# ============================================
-keep class coil.** { *; }
-keep interface coil.** { *; }
-dontwarn coil.**

# ============================================
# Jetpack Compose
# ============================================
-keep class androidx.compose.** { *; }
-dontwarn androidx.compose.**

# ============================================
# Navigation Compose
# ============================================
-keep class androidx.navigation.** { *; }
-dontwarn androidx.navigation.**

# ============================================
# Kotlin Coroutines
# ============================================
-keepnames class kotlinx.coroutines.internal.MainDispatcherFactory {}
-keepnames class kotlinx.coroutines.CoroutineExceptionHandler {}
-keepclassmembers class kotlinx.coroutines.** {
    volatile <fields>;
}

# ============================================
# Material 3
# ============================================
-keep class androidx.material3.** { *; }
-dontwarn androidx.material3.**

# ============================================
# Keep generic signature of Call, Response (R8 full mode strips signatures from non-kept items)
# ============================================
-keep,allowobfuscation,allowshrinking interface retrofit2.Call
-keep,allowobfuscation,allowshrinking class retrofit2.Response

# ============================================
# Keep entity classes (models)
# ============================================
-keep class com.shoppe.android.data.model.** { *; }
