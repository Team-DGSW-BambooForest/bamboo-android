@file:OptIn(ExperimentalMaterialApi::class)

package kr.hs.dgsw.bamboo.bamboo_android.feature.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.hs.dgsw.bamboo.bamboo_android.R
import kr.hs.dgsw.bamboo.bamboo_android.core.PlusIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.SearchIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.component.BambooBottomSheet
import kr.hs.dgsw.bamboo.bamboo_android.core.component.BambooTopBar
import kr.hs.dgsw.bamboo.bamboo_android.core.component.PostCard
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Background
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.BambooAndroidTheme
import kr.hs.dgsw.bamboo.bamboo_android.root.NavRoute
import kr.hs.dgsw.bamboo.domain.entity.post.Post
import org.orbitmvi.orbit.compose.collectAsState

@Composable
internal fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    val state = homeViewModel.collectAsState().value
    val postList = state.postList?.list

    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    HomeScreen(
        navController = navController,
        sheetState = sheetState,
        scope = scope,
        postList = postList,
        contentImage = state.contentImage
    )
}

@Composable
internal fun HomeScreen(
    navController: NavController,
    sheetState: ModalBottomSheetState,
    scope: CoroutineScope,
    postList: List<Post>?,
    contentImage: String?
) {
    BambooBottomSheet(sheetState) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = Background,
            topBar = {
                BambooTopBar(
                    modifier = Modifier.background(Color.White),
                    icon = {
                        Image(
                            painter = painterResource(R.drawable.logo),
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
                            onClick = { navController.navigate(NavRoute.SEARCH.routeName) },
                            content = { SearchIcon() }
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        IconButton(
                            modifier = Modifier.size(34.dp),
                            onClick = { navController.navigate(NavRoute.CREATE.routeName) },
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
                                model = R.drawable.profile,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        ) {
            LazyColumn {
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
}

@Preview
@Composable
internal fun PreviewHomeScreen() {
    BambooAndroidTheme {
        HomeScreen(
            navController = rememberNavController(),
            sheetState = ModalBottomSheetState(ModalBottomSheetValue.Hidden),
            scope = CoroutineScope(Dispatchers.Unconfined),
            postList = emptyList(),
            contentImage = null
        )
    }
}
