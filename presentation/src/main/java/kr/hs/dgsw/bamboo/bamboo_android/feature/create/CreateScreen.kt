package kr.hs.dgsw.bamboo.bamboo_android.feature.create

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kr.hs.dgsw.bamboo.bamboo_android.core.BackIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.component.BambooTopBar
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Background

@Composable
fun CreateScreen(
    navController: NavController
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Background,
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

            }
        }
    ) {

    }
}