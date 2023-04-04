package kr.hs.dgsw.bamboo.bamboo_android.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.BambooAndroidTheme
import kr.hs.dgsw.bamboo.bamboo_android.feature.create.CreateScreen
import kr.hs.dgsw.bamboo.bamboo_android.feature.main.HomeScreen
import kr.hs.dgsw.bamboo.bamboo_android.feature.search.SearchScreen
import kr.hs.dgsw.bamboo.bamboo_android.root.NavRoute.Create
import kr.hs.dgsw.bamboo.bamboo_android.root.NavRoute.Home
import kr.hs.dgsw.bamboo.bamboo_android.root.NavRoute.Search

@ExperimentalTextApi
@Composable
fun BambooApp() {
    BambooAndroidTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = Home
        ) {
            composable(Home) {
                HomeScreen(navController)
            }
            composable(Create) {
                CreateScreen(navController)
            }
            composable(Search) {
                SearchScreen(navController)
            }
        }
    }
}

@ExperimentalTextApi
@Preview
@Composable
fun PreviewBambooApp() {
    BambooApp()
}
