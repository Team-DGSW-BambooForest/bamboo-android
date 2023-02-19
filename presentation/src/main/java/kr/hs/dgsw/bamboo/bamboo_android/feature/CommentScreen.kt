@file:OptIn(ExperimentalAnimationGraphicsApi::class)

package kr.hs.dgsw.bamboo.bamboo_android.feature

import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.bamboo.bamboo_android.R
import kr.hs.dgsw.bamboo.bamboo_android.core.BackArrow
import kr.hs.dgsw.bamboo.bamboo_android.core.component.BambooTopBar

@Composable
fun CommentScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            BambooTopBar(
                trailingIcon = { BackArrow(modifier = Modifier.size(24.dp)) },
                content = {
                    Image(
                        modifier = Modifier.size(40.dp),
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 12.dp))
                    Column() {
                        Text(text = "asdf")
                        Text(text = "asdf")
                    }
                }
            )
        }
    ) {

    }
}

@Composable
@Preview(showBackground = true)
fun Preview() {
    CommentScreen()
}