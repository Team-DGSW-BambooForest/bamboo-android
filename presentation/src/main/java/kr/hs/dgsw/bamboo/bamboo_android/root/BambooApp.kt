package kr.hs.dgsw.bamboo.bamboo_android.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.BambooAndroidTheme
import kr.hs.dgsw.bamboo.bamboo_android.feature.comment.CommentScreen
import kr.hs.dgsw.bamboo.bamboo_android.feature.create.CreateScreen
import kr.hs.dgsw.bamboo.bamboo_android.feature.main.HomeScreen
import kr.hs.dgsw.bamboo.bamboo_android.root.NavRoute.Comment
import kr.hs.dgsw.bamboo.bamboo_android.root.NavRoute.Create
import kr.hs.dgsw.bamboo.bamboo_android.root.NavRoute.Home
import kr.hs.dgsw.bamboo.bamboo_android.root.NavRoute.HomePostId

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
            composable(HomePostId) {
                HomeScreen(navController)
            }
            composable(
                route = Comment,
                arguments = listOf(
                    navArgument("postId") {
                        defaultValue = 0
                        type = NavType.LongType
                    }
                )
            ) {
                val postId = it.arguments?.getLong("postId")

                postId?.let {
                    CommentScreen(postId = postId, navController = navController)
                }
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
