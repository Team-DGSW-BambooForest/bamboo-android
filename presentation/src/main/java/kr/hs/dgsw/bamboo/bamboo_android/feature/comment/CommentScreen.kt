<<<<<<< HEAD
@file:OptIn(ExperimentalTextApi::class)

package kr.hs.dgsw.bamboo.bamboo_android.feature.comment

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import kr.hs.dgsw.bamboo.bamboo_android.R
import kr.hs.dgsw.bamboo.bamboo_android.core.BackArrowIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.BackIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.component.BambooProfile
import kr.hs.dgsw.bamboo.bamboo_android.core.component.BambooTopBar
import kr.hs.dgsw.bamboo.bamboo_android.core.component.TextFieldSurface
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.*
import kr.hs.dgsw.bamboo.domain.entity.comment.Comment
=======
package kr.hs.dgsw.bamboo.bamboo_android.feature.comment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.bamboo.bamboo_android.R
import kr.hs.dgsw.bamboo.bamboo_android.core.BackArrowIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.BackIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.component.BambooTopBar
import kr.hs.dgsw.bamboo.bamboo_android.core.component.TextFieldSurface
>>>>>>> #2_comment_screen
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun CommentScreen(
    navController: NavController,
    commentViewModel: CommentViewModel = hiltViewModel(),
) {
    val state = commentViewModel.collectAsState().value
<<<<<<< HEAD
    val comments = state.comments
=======
>>>>>>> #2_comment_screen

    Scaffold(
        modifier = Modifier.fillMaxSize(),
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
        }
    ) {
        Column {
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            Text(text = "민트초코? 치약 아님..? 왜 먹음? ㅠㅠ", modifier = Modifier.padding(horizontal = 14.dp))
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            Divider(color = Color.LightGray, thickness = 1.dp)
            Spacer(modifier = Modifier.weight(1f))
            TextFieldSurface()
        }
<<<<<<< HEAD
        LazyColumn {
            itemsIndexed(
                items = comments ?: emptyList(),
                key = { _, comment ->
                    comment.id
                }
            ) { _, comment ->
                CommentItem(
                    modifier = Modifier.padding(start = 14.dp),
                    profileImage = comment.profileImage,
                    content = comment.content,
                    createTime = comment.createdAt,
                    name = comment.writer,
                    contentImage = state.contentImage
                ) {
                    /* Todo('onClick') */
                }
            }
        }
    }
}

@Composable
fun CommentItem(
    modifier: Modifier = Modifier,
    profileImage: String,
    content: String,
    createTime: String,
    name: String,
    contentImage: String? = null,
    onClick: () -> Unit,
) {
    Surface(
        modifier = modifier
            .padding(
                horizontal = 14.dp,
                vertical = 12.dp
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.Start
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                model = profileImage,
                contentDescription = null
            )
            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Column() {
                CommentContainer(name = name, comment = content)
                Spacer(modifier = Modifier.padding(vertical = 2.dp))
                Row() {
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    Text(text = "답글달기", fontSize = 10.sp)
                    Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                    Text(text = createTime, fontSize = 10.sp, color = TextGray2)
                }
            }
        }
    }
}

@Composable
fun CommentContainer(
    name: String,
    comment: String,
) {
    Surface(
        color = SurfaceGray,
        shape = RoundedCornerShape(15.dp)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 14.dp)
        ) {
            Name1(text = name)
            Body1(text = comment)
        }
    }
}
=======
//        LazyColumn(content = )
    }
}

>>>>>>> #2_comment_screen

@Composable
@Preview(showBackground = true)
fun Preview() {
    val navController = rememberNavController()
    CommentScreen(navController)
}