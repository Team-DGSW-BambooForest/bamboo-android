package kr.hs.dgsw.bamboo.bamboo_android.core.component

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.bamboo.bamboo_android.core.BackArrow
import kr.hs.dgsw.bamboo.bamboo_android.feature.CommentScreen

@Composable
fun BambooTopBar(
    modifier: Modifier = Modifier,
    trailingIcon: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    Surface(
        color = Color.White,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(AppBarHeight)
                .padding(horizontal = 14.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CompositionLocalProvider() {
                trailingIcon()
            }
            Spacer(modifier = Modifier.padding(horizontal = 12.dp))
            content()
        }
    }
}

private val AppBarHeight = 56.dp

@Composable
@Preview(showBackground = true)
fun Preview() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            BambooTopBar(
                trailingIcon = { BackArrow(modifier = Modifier.size(24.dp)) },
                content = { Text(text = "asdf") }
            )
        }
    ) {

    }
}