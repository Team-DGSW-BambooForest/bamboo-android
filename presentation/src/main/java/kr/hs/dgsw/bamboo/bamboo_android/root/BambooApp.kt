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

@ExperimentalTextApi
@Composable
fun BambooApp() {
    BambooAndroidTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = NavRoute.HOME.routeName
        ) {
            composable(NavRoute.HOME.routeName) {
                HomeScreen(navController)
            }
            composable(NavRoute.CREATE.routeName) {
                CreateScreen(navController)
            }
            composable(NavRoute.SEARCH.routeName) {
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
