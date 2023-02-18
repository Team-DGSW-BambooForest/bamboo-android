plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kapt)
    id(Plugins.kt_lint) version Versions.KT_LINT
    id(Plugins.hilt)
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = Plugins.testRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    compileOptions {
        sourceCompatibility = AppConfig.JAVA_VERSION
        targetCompatibility = AppConfig.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }
}

dependencies {

    implementation(AndroidX.CORE_KTX)
    testImplementation(Test.JUNIT)
    androidTestImplementation(AndroidTest.ANDROID_JUNIT)
    androidTestImplementation(AndroidTest.ESPRESSO_CORE)

    // Coroutines
    implementation(Coroutines.COROUTINE_CORE)

    // Dagger-Hilt
    implementation(Hilt.HILT_ANDROID)
    kapt(Hilt.HILT_COMPILER)

    implementation(project(AppConfig.domain))
}
