object AndroidX {
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
    const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.COMPOSE}"
    const val MATERIAL = "androidx.compose.material:material:${Versions.MATERIAL}"
}

object Compose {
    const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE_UI}"
    const val UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE_UI}"

    const val UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE_UI}"
    const val UI_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest:${Versions.COMPOSE_UI}"
    const val UI_TEST_JUNIT = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE_UI}"
}

object AndroidTest {
    const val ANDROID_JUNIT = "androidx.test.ext:junit:${Versions.ANDROID_JUNIT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
}

object Test {
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
}

object Coroutines {
    const val COROUTINE_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    const val COROUTINE_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
}

object Navigation {
    const val NAVIGATION_COMPOSE = "androidx.navigation:navigation-compose:${Versions.NAVIGATION_COMPOSE}"
}

object Hilt {
    const val HILT_ANDROID = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    const val HILT_NAVIGATION = "androidx.hilt:hilt-navigation-compose:${Versions.HILT_NAVIGATION}"
}

object Coil {
    const val COIL_COMPOSE = "io.coil-kt:coil-compose:${Versions.COIL}"
}

object Retrofit {
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
    const val OKHTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_GSON_CONVERTER = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
}

object OrbitMVI {
    const val ORBIT_CORE = "org.orbit-mvi:orbit-core:${Versions.ORBIT_MVI}"
    const val ORBIT_VIEWMODEL = "org.orbit-mvi:orbit-viewmodel:${Versions.ORBIT_MVI}"
    const val ORBIT_COMPOSE = "org.orbit-mvi:orbit-compose:${Versions.ORBIT_MVI}"
    const val ORBIT_TEST = "org.orbit-mvi:orbit-test:${Versions.ORBIT_MVI}"
}