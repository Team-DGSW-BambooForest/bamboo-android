package kr.hs.dgsw.bamboo.bamboo_android.feature.comment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.bamboo.bamboo_android.R
import kr.hs.dgsw.bamboo.bamboo_android.core.BackArrowIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.component.MTextField
import kr.hs.dgsw.bamboo.bamboo_android.core.component.TopBar

@Composable
fun CommentScreen() {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(icon = { BackArrowIcon(modifier = Modifier.size(24.dp)) }) {
                Spacer(modifier = Modifier.padding(horizontal = 6.dp))
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.padding(horizontal = 6.dp))
                Column() {
                    Text(text = "익명이")
                    Text(text = "2023.02.01", color = Color.LightGray)
                }
            }
        },
        bottomBar = {

        }
    ) {
        Column {
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            Text(text = "민트초코? 치약 아님..? 왜 먹음? ㅠㅠ", modifier = Modifier.padding(horizontal = 14.dp))
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            Divider(color = Color.LightGray, thickness = 1.dp)
            Spacer(modifier = Modifier.weight(1f))
            MTextField()
        }
//        Column(modifier = Modifier.padding(horizontal = 14.dp)) {
//
//        }

    }
}


@Composable
@Preview(showBackground = true)
fun Preview() {
    CommentScreen()
}