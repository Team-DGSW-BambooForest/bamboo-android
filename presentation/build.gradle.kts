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
    packagingOptions {
        resources {
            excludes += AppConfig.packagingOption
        }
    }
    buildFeatures {
        dataBinding = AppConfig.dataBinding
    }
}

dependencies {

    implementation(AndroidX.CORE_KTX)
    implementation(AndroidX.LIFECYCLE)

    implementation(AndroidX.APP_COMPAT)
    implementation(AndroidX.MATERIAL)
    implementation(AndroidX.CONSTRAINT_LAYOUT)

    implementation(Navigation.NAVIGATION_FRAGMENT)

    testImplementation(Test.JUNIT)
    androidTestImplementation(AndroidTest.ANDROID_JUNIT)
    androidTestImplementation(AndroidTest.ESPRESSO_CORE)

    // Coroutine
    implementation(Coroutines.COROUTINE_ANDROID)

    // Dagger-Hilt
    implementation(Hilt.HILT_ANDROID)
    kapt(Hilt.HILT_COMPILER)

    // Retrofit2
    implementation(Retrofit.RETROFIT)
    implementation(Retrofit.RETROFIT_GSON_CONVERTER)
    implementation(Retrofit.OKHTTP)
    implementation(Retrofit.OKHTTP_LOGGING_INTERCEPTOR)

    // Glide
    implementation(Glide.GLIDE)

    implementation(project(AppConfig.domain))
    implementation(project(AppConfig.di))
}
