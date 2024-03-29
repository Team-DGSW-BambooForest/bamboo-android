plugins {
    id(Plugins.androidApplication) version Versions.ANDROID apply false
    id(Plugins.androidLibrary) version Versions.ANDROID apply false
    id(Plugins.kotlinAndroid) version Versions.KOTLIN apply false
    id(Plugins.kotlinJvm) version Versions.KOTLIN apply false
    id(Plugins.hilt) version Versions.HILT apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
