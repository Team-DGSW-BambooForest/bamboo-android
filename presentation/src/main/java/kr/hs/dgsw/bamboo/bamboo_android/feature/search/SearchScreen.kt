package kr.hs.dgsw.bamboo.bamboo_android.feature.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
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
import coil.compose.AsyncImage
import kr.hs.dgsw.bamboo.bamboo_android.R
import kr.hs.dgsw.bamboo.bamboo_android.core.BackIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.component.BambooTopBar
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.*
import kr.hs.dgsw.bamboo.bamboo_android.feature.main.PostItem

@OptIn(ExperimentalTextApi::class)
@Composable
fun SearchScreen(
    navController: NavController,
    searchViewModel: SearchViewModel = hiltViewModel(),
) {
    var content by remember { mutableStateOf("") }

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
                    onValueChange = { content = it },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onDone = {

                    })
                ) {
                    Row(
                        modifier = Modifier.padding(0.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.width(14.dp))

                        if (content.isEmpty()) {
                            AsyncImage(
                                modifier = Modifier.size(24.dp),
                                model = R.drawable.search_gray,
                                contentDescription = null
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
        LazyColumn {
            itemsIndexed(
                items = potList ?: emptyList(),
                key = { _, post ->
                    post.postId
                }
            ) { _, post ->
                PostItem(
                    modifier = Modifier.padding(top = 8.dp),
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

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    val navController = rememberNavController()
    BambooAndroidTheme {
        SearchScreen(navController = navController)
    }
}