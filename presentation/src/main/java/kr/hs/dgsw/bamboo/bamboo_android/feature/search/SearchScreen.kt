package kr.hs.dgsw.bamboo.bamboo_android.feature.search

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.bamboo.bamboo_android.core.component.BambooTopBar
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.BambooAndroidTheme

@Composable
fun SearchScreen(
    navController: NavController,
    homeViewModel: SearchViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.White,
        topBar = {
            BambooTopBar(
                icon = { /*TODO*/ }
            ) {
                
            }
        }
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    val navController = rememberNavController()
    BambooAndroidTheme {
        SearchScreen(navController = navController)
    }
}