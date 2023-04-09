@file:OptIn(ExperimentalTextApi::class)

package kr.hs.dgsw.bamboo.bamboo_android.feature.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kr.hs.dgsw.bamboo.bamboo_android.core.BackIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.SearchIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.component.BambooTopBar
import kr.hs.dgsw.bamboo.bamboo_android.core.component.PostCard
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Background
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.BambooAndroidTheme
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Black
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Body1
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Gray
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.LightGray
import kr.hs.dgsw.bamboo.domain.entity.post.Post
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun SearchScreen(
    navController: NavController,
    searchViewModel: SearchViewModel = hiltViewModel(),
) {
    val state = searchViewModel.collectAsState().value
    val postList = state.postList?.list

    var content by remember { mutableStateOf("") }

    SearchScreen(
        navController = navController,
        postList = postList,
        content = content,
        onValueChange = { content = it },
        onClickSearch = {
            searchViewModel.searchPost(content)
        }
    )
}

@Composable
internal fun SearchScreen(
    navController: NavController,
    postList: List<Post>?,
    content: String,
    onValueChange: (String) -> Unit,
    contentImage: String? = null,
    onClickSearch: KeyboardActionScope.() -> Unit
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
                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                        .height(36.dp)
                        .background(
                            color = LightGray,
                            shape = RoundedCornerShape(15.dp)
                        ),
                    value = content,
                    onValueChange = onValueChange,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = onClickSearch)
                ) {
                    Row(
                        modifier = Modifier.padding(0.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.width(14.dp))

                        if (content.isEmpty()) {
                            SearchIcon(
                                modifier = Modifier.size(24.dp),
                                tint = Gray
                            )

                            Spacer(modifier = Modifier.width(4.dp))

                            Body1(
                                text = "검색어를 입력하세요",
                                textColor = Gray
                            )
                        } else {
                            Body1(
                                text = content,
                                textColor = Black,
                                maxLines = 1
                            )
                        }
                    }
                }
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
        ) {
            itemsIndexed(
                items = postList ?: emptyList(),
                key = { _, post ->
                    post.postId
                }
            ) { _, post ->
                PostCard(
                    modifier = Modifier.padding(top = 8.dp),
                    profileImage = post.profileImage,
                    name = post.author,
                    createTime = post.createTime,
                    content = post.content,
                    contentImage = contentImage
                ) {
                }
            }
        }
    }
}

@Preview
@Composable
internal fun SearchScreenPreview() {
    BambooAndroidTheme {
        SearchScreen(
            navController = rememberNavController(),
            postList = emptyList(),
            content = "",
            onValueChange = {},
            onClickSearch = {}
        )
    }
}
