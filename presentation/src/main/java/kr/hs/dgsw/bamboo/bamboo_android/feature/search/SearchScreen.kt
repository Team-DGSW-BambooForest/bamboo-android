package kr.hs.dgsw.bamboo.bamboo_android.feature.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.bamboo.bamboo_android.core.BackIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.component.BambooTopBar
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.BambooAndroidTheme
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.LightGray

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
                icon = {
                    IconButton(
                        modifier = Modifier.size(24.dp),
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        BackIcon()
                    }
                }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                        .height(36.dp)
                        .background(
                            color = LightGray,
                            shape = RoundedCornerShape(15.dp)
                        )
                ) {
                    Icon(
                        painter = ,
                        contentDescription = null
                    )
                }
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