import org.gradle.api.JavaVersion

object AppConfig {
    const val applicationId = "kr.hs.dgsw.bamboo.bamboo_android"
    const val compileSdk = 32
    const val minSdk = 26
    const val targetSdk = 32
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val jvmTarget = "11"
    val JAVA_VERSION = JavaVersion.VERSION_11

    const val buildType = "release"
    const val isMinifyEnabled = false
    const val proguardFileName = "proguard-android.txt"
    const val proguardFile = "proguard-rules.pro"

    const val compose = true
    const val kotlinCompilerVersion = "1.1.1"
    const val packagingOption = "/META-INF/{AL2.0,LGPL2.1}"
    const val dataBinding = true

    const val domain = ":domain"
    const val data = ":data"
    const val di = ":di"
}