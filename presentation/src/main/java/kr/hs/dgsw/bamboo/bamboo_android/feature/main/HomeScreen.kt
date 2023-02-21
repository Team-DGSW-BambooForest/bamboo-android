@file:OptIn(
    ExperimentalTextApi::class, ExperimentalMaterialApi::class,
    ExperimentalMaterialApi::class
)

package kr.hs.dgsw.bamboo.bamboo_android.feature.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kr.hs.dgsw.bamboo.bamboo_android.R
import kr.hs.dgsw.bamboo.bamboo_android.core.PlusIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.SearchIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.component.BottomSheet
import kr.hs.dgsw.bamboo.bamboo_android.core.component.TopBar
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Background
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.BambooAndroidTheme
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Body1
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Body2
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Subtitle2
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.TextGray
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun MainScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    homeViewModel.getPostList()
    val state = homeViewModel.collectAsState().value
    val postList = state.postList?.list

    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    BottomSheet(sheetState) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = Background,
            topBar = {
                MainTopBar(
                    scope,
                    sheetState
                )
            }
        ) {
            LazyColumn(
                modifier = Modifier.padding(top = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                itemsIndexed(
                    items = postList ?: emptyList(),
                    key = { _, post ->
                        post.postId
                    }
                ) { _, post ->
                    homeViewModel.getImage(post.postId)
                    PostItem(
                        profileImage = post.profileImage,
                        name = post.author,
                        createTime = post.createTime,
                        content = post.content,
                        contentImage = state.contentImage
                    ) {
                    }
                }
            }
        }
    }
}

@Composable
fun MainTopBar(
    scope: CoroutineScope,
    sheetState: ModalBottomSheetState
) {
    TopBar(
        modifier = Modifier.background(Color.White),
        icon = {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null
            )
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                modifier = Modifier.size(34.dp),
                onClick = { /*TODO*/ },
                content = { SearchIcon() }
            )
            Spacer(modifier = Modifier.width(10.dp))
            IconButton(
                modifier = Modifier.size(34.dp),
                onClick = { /*TODO*/ },
                content = { PlusIcon() }
            )
            Spacer(modifier = Modifier.width(10.dp))
            IconButton(
                modifier = Modifier.size(34.dp),
                onClick = {
                    scope.launch { sheetState.show() }
                },
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(34.dp)
                        .clip(CircleShape),
                    model = "https://pbs.twimg.com/profile_images/1374979417915547648/vKspl9Et_400x400.jpg",
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun PostItem(
    profileImage: String,
    name: String,
    createTime: String,
    content: String,
    contentImage: String? = null,
    commentSize: Int = 0,
    onClick: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
            .padding(
                horizontal = 14.dp,
                vertical = 12.dp
            )
    ) {
        Column {
            Row {
                AsyncImage(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    model = profileImage,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Spacer(modifier = Modifier.height(2.dp))

                    Subtitle2(text = name)

                    Spacer(modifier = Modifier.height(3.dp))

                    Body2(
                        text = createTime,
                        textColor = TextGray
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))

            Body1(text = content)

            contentImage?.let {
                Spacer(modifier = Modifier.height(12.dp))

                AsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    model = it,
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            val interactionSource = remember { MutableInteractionSource() }
            Body1(
                modifier = Modifier
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = onClick
                    ),
                text = if (commentSize == 0) "댓글 작성하기" else "댓글 ${commentSize}개 모두 보기",
                textColor = TextGray
            )
        }
    }
}

@Preview(showBackground = true, heightDp = 844, widthDp = 390)
@Composable
fun PreviewMainScreen() {
    BambooAndroidTheme {
        MainScreen()
    }
}
