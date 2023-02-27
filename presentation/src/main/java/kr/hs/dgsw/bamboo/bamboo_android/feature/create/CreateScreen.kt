@file:OptIn(
    ExperimentalTextApi::class, ExperimentalMaterialApi::class
)

package kr.hs.dgsw.bamboo.bamboo_android.feature.create

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import kr.hs.dgsw.bamboo.bamboo_android.R
import kr.hs.dgsw.bamboo.bamboo_android.core.BackIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.component.BambooBottomSheet
import kr.hs.dgsw.bamboo.bamboo_android.core.component.BambooTopBar
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.*
import kr.hs.dgsw.bamboo.bamboo_android.root.NavRoute.HomePostId
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@ExperimentalTextApi
@Composable
fun CreateScreen(
    navController: NavController,
    createViewModel: CreateViewModel = hiltViewModel()
) {
    val interactionSource = remember { MutableInteractionSource() }
    val scrollState = rememberScrollState()

    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    var content by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val selectedImageBitmap by remember { mutableStateOf<Bitmap?>(null) }
    val context = LocalContext.current

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { selectedImageUri = it }
    )

    val state = createViewModel.collectAsState().value
    createViewModel.collectSideEffect { handleSideEffect(navController, context, it) }

    BambooBottomSheet(sheetState) {
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

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Subtitle1(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(end = 24.dp),
                            text = "제보하기"
                        )
                        Button(
                            modifier = Modifier
                                .height(34.dp)
                                .width(60.dp)
                                .align(Alignment.CenterEnd),
                            shape = RoundedCornerShape(10.dp),
                            onClick = { createViewModel.createPost(content) },
                            elevation = null,
                            contentPadding = PaddingValues(0.dp),
                            colors = ButtonDefaults.buttonColors(Color.Transparent)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Primary),
                                contentAlignment = Alignment.Center
                            ) {
                                Body1(
                                    text = "제보",
                                    textColor = Color.White
                                )
                            }
                        }
                    }
                }
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(LightGray)
                    )

                    Spacer(modifier = Modifier.height(12.dp))


                    Row(
                        modifier = Modifier
                            .padding(horizontal = 14.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            modifier = Modifier.size(42.dp),
                            onClick = {
                                scope.launch { sheetState.show() }
                            }
                        ) {
                            AsyncImage(
                                model = R.drawable.select_profile,
                                contentDescription = null
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Subtitle2(text = "익명이")
                    }

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(focusRequester),
                        value = content,
                        onValueChange = { content = it },
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Black,
                            cursorColor = Green,
                            backgroundColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        placeholder = {
                            Body1(
                                text = "대대숲에 제보를 남겨보세요!",
                                textColor = Gray
                            )
                            Body1(
                                text = """
                                   
                                   
                                제보 시 이런 점을 주의해 주세요.
                                  •   수위 높은 저격글
                                  •   음담패설
                                  •   도배글
                                  •   분쟁을 일으키는 제보
                                  •   어그로성 제보
                                  •   지나치게 긴 제보
                                (이외에도 관리자가 부적절하다고 판단한 제보와 댓글은 
                                경고 처리 없이 삭제 조치 될 수 있습니다.)
                            """.trimIndent(),
                                textColor = Color(0xFFD9D9D9)
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(60.dp))
                }

                Column(
                    modifier = Modifier.align(Alignment.BottomCenter)
                ) {

                    selectedImageUri?.let { uri ->
                        AsyncImage(
                            modifier = Modifier
                                .padding(14.dp)
                                .size(100.dp)
                                .clip(RoundedCornerShape(20.dp)),
                            model = uri,
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(LightGray)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .clickable(
                                    interactionSource = interactionSource,
                                    indication = null
                                ) {

                                },
                        ) {
                            AsyncImage(
                                modifier = Modifier
                                    .size(28.dp)
                                    .align(Alignment.CenterHorizontally),
                                model = R.drawable.camera,
                                contentDescription = null
                            )

                            Body2(
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                text = "카메라",
                                textColor = Gray
                            )
                        }

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .clickable(
                                    interactionSource = interactionSource,
                                    indication = null
                                ) {
                                    imagePickerLauncher.launch("image/*")

                                }
                        ) {
                            AsyncImage(
                                modifier = Modifier
                                    .size(28.dp)
                                    .align(Alignment.CenterHorizontally),
                                model = R.drawable.image,
                                contentDescription = null
                            )

                            Body2(
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                text = "사진",
                                textColor = Gray
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

private fun handleSideEffect(navController: NavController, context: Context, sideEffect: CreateSideEffect) {
    when (sideEffect) {
        is CreateSideEffect.NavigateToHome -> {
            Log.d("TEST", "handleSideEffect: 화면 전환")
            navController.navigate(HomePostId) {
                navArgument("postId") {
                    type = NavType.StringType
                }
            }
        }
        is CreateSideEffect.Toast -> Toast.makeText(
            context,
            sideEffect.text, Toast.LENGTH_SHORT
        ).show()
    }
}

@Composable
@Preview(showBackground = true)
fun CreateScreenPreview() {
    val navController = rememberNavController()
    BambooAndroidTheme {
        CreateScreen(navController)
    }
}