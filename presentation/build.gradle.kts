plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kapt)
    id(Plugins.kt_lint) version Versions.KT_LINT
    id(Plugins.hilt)
}

android {
    namespace = AppConfig.applicationId
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = Plugins.testRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName(AppConfig.buildType) {
            isMinifyEnabled = AppConfig.isMinifyEnabled
            proguardFiles(getDefaultProguardFile(AppConfig.proguardFileName), AppConfig.proguardFile)
        }
    }
    compileOptions {
        sourceCompatibility = AppConfig.JAVA_VERSION
        targetCompatibility = AppConfig.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }
    buildFeatures {
        compose = AppConfig.compose
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.kotlinCompilerVersion
    }
    packagingOptions {
        resources {
            excludes += AppConfig.packagingOption
        }
    }
}

dependencies {

    implementation(AndroidX.CORE_KTX)
    implementation(AndroidX.LIFECYCLE)
    implementation(AndroidX.ACTIVITY_COMPOSE)
    implementation(Compose.COMPOSE_UI)
    implementation(Compose.UI_TOOLING_PREVIEW)
    implementation(AndroidX.MATERIAL)
    testImplementation(Test.JUNIT)
    androidTestImplementation(AndroidTest.ANDROID_JUNIT)
    androidTestImplementation(AndroidTest.ESPRESSO_CORE)
    androidTestImplementation(Compose.UI_TEST_JUNIT)
    debugImplementation(Compose.UI_TOOLING)
    debugImplementation(Compose.UI_TEST_MANIFEST)

    // Coroutine
    implementation(Coroutines.COROUTINE_ANDROID)

    // Jetpack Navigation
    implementation(Navigation.NAVIGATION_COMPOSE)

    // Dagger-Hilt
    implementation(Hilt.HILT_ANDROID)
    kapt(Hilt.HILT_COMPILER)
    implementation(Hilt.HILT_NAVIGATION)

    // Coil
    implementation(Coil.COIL_COMPOSE)

    // Retrofit2
    implementation(Retrofit.RETROFIT)
    implementation(Retrofit.RETROFIT_GSON_CONVERTER)
    implementation(Retrofit.OKHTTP)
    implementation(Retrofit.OKHTTP_LOGGING_INTERCEPTOR)

    implementation(project(AppConfig.domain))
    implementation(project(AppConfig.data))
}
