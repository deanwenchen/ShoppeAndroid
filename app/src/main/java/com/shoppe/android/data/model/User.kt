package com.shoppe.android.data.model

/**
 * 用户数据模型
 */
data class User(
    val email: String,
    val password: String,
    val displayName: String,
    val avatarUrl: String? = null
)

/**
 * 模拟认证服务
 * 提供测试账号数据
 */
object MockAuthService {

    /**
     * 测试账号列表
     */
    private val testUsers = listOf(
        User(
            email = "deanwen@gmail.com",
            password = "12345678",
            displayName = "Romina",
            avatarUrl = "https://www.figma.com/api/mcp/asset/e7b51c67-88a6-4113-a4da-1e51eebde31d"
        ),
        User(
            email = "test@gmail.com",
            password = "12345678",
            displayName = "Test User",
            avatarUrl = null
        )
    )

    /**
     * 验证邮箱是否存在
     * @param email 用户输入的邮箱
     * @return 如果邮箱存在返回对应的用户，否则返回 null
     */
    fun findUserByEmail(email: String): User? {
        return testUsers.find { it.email.equals(email, ignoreCase = true) }
    }

    /**
     * 验证密码是否正确
     * @param email 用户邮箱
     * @param password 用户输入的密码
     * @return 验证结果
     */
    fun verifyPassword(email: String, password: String): LoginResult {
        val user = findUserByEmail(email) ?: return LoginResult.UserNotFound

        return if (user.password == password) {
            LoginResult.Success(user)
        } else {
            LoginResult.WrongPassword
        }
    }

    /**
     * 验证邮箱格式
     * @param email 待验证的邮箱
     * @return 如果格式有效返回 true
     */
    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}

/**
 * 登录验证结果
 */
sealed class LoginResult {
    data class Success(val user: User) : LoginResult()
    object WrongPassword : LoginResult()
    object UserNotFound : LoginResult()
    object InvalidEmail : LoginResult()
}
