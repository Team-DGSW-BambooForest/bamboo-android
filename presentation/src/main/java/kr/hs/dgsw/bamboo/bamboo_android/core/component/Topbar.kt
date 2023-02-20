package kr.hs.dgsw.bamboo.bamboo_android.core.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    Surface(
        color = Color.White,
        modifier = modifier
            .height(44.dp)
            .fillMaxWidth()
            .padding(horizontal = 14.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon()
            content()
        }
    }
}
