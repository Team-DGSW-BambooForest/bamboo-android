 plugins {
     id(Plugins.androidApplication)
     id(Plugins.kotlinAndroid)
     id(Plugins.kt_lint) version Versions.KT_LINT
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
    implementation(Compose.ICONS)
    implementation(AndroidX.MATERIAL)
    testImplementation(Test.JUNIT)
    androidTestImplementation(AndroidTest.ANDROID_JUNIT)
    androidTestImplementation(AndroidTest.ESPRESSO_CORE)
    androidTestImplementation(Compose.UI_TEST_JUNIT)
    debugImplementation(Compose.UI_TOOLING)
    debugImplementation(Compose.UI_TEST_MANIFEST)

    implementation(project(AppConfig.domain))
    implementation(project(AppConfig.data))
}