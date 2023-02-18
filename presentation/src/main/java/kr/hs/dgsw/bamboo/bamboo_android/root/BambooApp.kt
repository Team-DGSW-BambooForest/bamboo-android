package kr.hs.dgsw.bamboo.bamboo_android.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.BambooAndroidTheme
import kr.hs.dgsw.bamboo.bamboo_android.feature.main.MainScreen
import kr.hs.dgsw.bamboo.bamboo_android.root.NavRoute.Main

@Composable
fun BambooApp() {
    BambooAndroidTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = Main
        ) {
            composable(Main) {
                MainScreen()
            }
        }
    }
}

@Preview
@Composable
fun PreviewBambooApp() {
    BambooApp()
}