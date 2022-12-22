import org.gradle.api.artifacts.dsl.DependencyHandler

object Versions {
    // KTX
    const val CORE = "1.7.0"
    const val LIFECYCLE_RUNTIME = "2.3.1"

    // AndroidX
    const val ACTIVITY_COMPOSE = "1.3.1"
    const val MATERIAL = "1.1.1"

    // Compose Ui
    const val COMPOSE_UI = "1.1.1"

    // TEST
    const val JUNIT = "4.13.2"

    // Android Test
    const val EXT_JUNIT = "1.1.4"
    const val ESPRESSO_CORE = "3.5.0"
}

object Libraries {
    // KTX
    const val CORE = "androidx.core:core-ktx:${Versions.CORE}"
    const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_RUNTIME}"

    // AndroidX
    const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ACTIVITY_COMPOSE}"
    const val MATERIAL = "androidx.compose.material:material:${Versions.MATERIAL}"

    // Compose Ui
    const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE_UI}"
    const val UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE_UI}"
    const val UI_TEST_JUNIT = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE_UI}"
    const val UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE_UI}"
    const val UI_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest:${Versions.COMPOSE_UI}"

    // TEST
    const val JUNIT = "junit:junit:${Versions.JUNIT}"

    // Android Test
    const val EXT_JUNIT = "androidx.test.ext:junit:${Versions.EXT_JUNIT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
}