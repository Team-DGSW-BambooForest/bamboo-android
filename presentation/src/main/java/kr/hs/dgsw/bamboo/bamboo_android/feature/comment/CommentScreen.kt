@file:OptIn(ExperimentalTextApi::class, ExperimentalTextApi::class)

package kr.hs.dgsw.bamboo.bamboo_android.feature.comment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import kr.hs.dgsw.bamboo.bamboo_android.core.BackIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.component.BambooTopBar
import kr.hs.dgsw.bamboo.bamboo_android.core.component.TextFieldSurface
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun CommentScreen(
    navController: NavController,
    commentViewModel: CommentViewModel = hiltViewModel(),
    postId: Long
) {
    commentViewModel.getPostById(postId) // TODO : 안들고 오는 거 같은데

    val state = commentViewModel.collectAsState().value
    val comments = state.comments
    val post = state.post

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
                Spacer(modifier = Modifier.width(12.dp))
                AsyncImage(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    model = post?.profileImage,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Subtitle2(text = post?.author.toString())
                    Spacer(modifier = Modifier.height(3.dp))
                    Number1(text = post?.createTime.toString())
                }
            }
        }
    ) {
        Column {
            Spacer(modifier = Modifier.height(8.dp))
            Body1(text = post?.content.toString(), modifier = Modifier.padding(horizontal = 14.dp))
            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = LineGray, thickness = 1.dp)
            Spacer(modifier = Modifier.weight(1f))
            TextFieldSurface()
        }
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
                    createAt = comment.createdAt,
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
    createAt: String,
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
            Column {
                CommentContainer(name = name, comment = content)
                Spacer(modifier = Modifier.padding(vertical = 2.dp))
                Row {
                    Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                    Text(text = "답글달기", fontSize = 10.sp)
                    Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                    Text(text = createAt, fontSize = 10.sp, color = TextGray2)
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

@Composable
@Preview(showBackground = true)
fun Preview() {
//    val navController = rememberNavController()
//    CommentScreen(navController)
}