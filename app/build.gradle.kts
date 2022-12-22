 plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "kr.hs.dgsw.bamboo.bamboo_android"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "kr.hs.dgsw.bamboo.bamboo_android"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Libraries.CORE)
    implementation(Libraries.LIFECYCLE_RUNTIME)
    implementation(Libraries.ACTIVITY_COMPOSE)
    implementation(Libraries.COMPOSE_UI)
    implementation(Libraries.MATERIAL)
    implementation(Libraries.UI_TOOLING_PREVIEW)
    testImplementation(Libraries.JUNIT)
    androidTestImplementation(Libraries.EXT_JUNIT)
    androidTestImplementation(Libraries.ESPRESSO_CORE)
    androidTestImplementation(Libraries.UI_TEST_JUNIT)
    debugImplementation(Libraries.UI_TOOLING)
    debugImplementation(Libraries.UI_TEST_MANIFEST)
}