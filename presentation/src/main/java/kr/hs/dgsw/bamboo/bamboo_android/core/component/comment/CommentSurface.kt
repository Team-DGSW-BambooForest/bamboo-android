package kr.hs.dgsw.bamboo.bamboo_android.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.hs.dgsw.bamboo.bamboo_android.R
import kr.hs.dgsw.bamboo.bamboo_android.core.component.comment.MComment
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.TextGray2
import kr.hs.dgsw.bamboo.bamboo_android.feature.comment.CommentScreen

@Composable
fun CommentSurface(
    profile: Painter,
    name: String,
    comment: String,
    time: String
){
    Row(){
        Image(
            modifier = Modifier.size(34.dp),
            painter = profile,
            contentDescription = null
        )
        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
        Column() {
            MComment(name = name, comment = comment)
            Spacer(modifier = Modifier.padding(vertical = 2.dp))
            Row() {
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Text(text = "답글달기", fontSize = 10.sp)
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                Text(text = time, fontSize = 10.sp, color = TextGray2)
            }
        }
    }
}

data class Comment(
    val profile: Painter,
    val name: String,
    val comment: String,
    val time: String
)

@Composable
@Preview(showBackground = true)
fun Preview() {
    val comments = listOf<Comment>(
        Comment(painterResource(id = R.drawable.profile), "익명이", "ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ", "2분"),
        Comment(painterResource(id = R.drawable.profile), "익명이", "ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ", "2분"),
        Comment(painterResource(id = R.drawable.profile), "익명이", "ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ", "2분"),
        Comment(painterResource(id = R.drawable.profile), "익명이", "ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ", "2분"),
        Comment(painterResource(id = R.drawable.profile), "익명이", "ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ", "2분"),
    )

    LazyColumn(){
        itemsIndexed(comments) { index, it ->
            CommentSurface(profile = it.profile, name = it.name, comment = it.comment, time = it.time)
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
        }
    }
}