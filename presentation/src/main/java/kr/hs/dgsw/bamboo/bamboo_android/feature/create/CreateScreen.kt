@file:OptIn(ExperimentalMaterialApi::class, ExperimentalTextApi::class)

package kr.hs.dgsw.bamboo.bamboo_android.feature.create

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.core.app.ActivityCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.AsyncImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.hs.dgsw.bamboo.bamboo_android.R
import kr.hs.dgsw.bamboo.bamboo_android.core.*
import kr.hs.dgsw.bamboo.bamboo_android.core.component.BambooBottomSheet
import kr.hs.dgsw.bamboo.bamboo_android.core.component.BambooTopBar
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.*
import kr.hs.dgsw.bamboo.bamboo_android.root.NavRoute
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import java.io.ByteArrayOutputStream

@Composable
internal fun CreateScreen(
    navController: NavController,
    createViewModel: CreateViewModel = hiltViewModel(),
) {
    val activity = LocalContext.current as Activity

    val state = createViewModel.collectAsState().value
    createViewModel.collectSideEffect { handleSideEffect(navController, activity, it) }

    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scrollState = rememberScrollState()

    val focusRequester = remember { FocusRequester() }
    val interactionSource = remember { MutableInteractionSource() }

    var image by remember { mutableStateOf<MultipartBody.Part?>(null) }
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    val content = remember { mutableStateOf("") }

    val takePhotoFromAlbumLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                image = result.data?.data?.let { uri ->
                    val bitmapImage = uri.uriToBitmap(activity)
                    bitmap = bitmapImage
                    bitmapImage.bitmapToMultipart()
                }
            }
        }

    val takePhotoFromCameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) { takenPhoto ->
            image = takenPhoto?.let { photo ->
                bitmap = photo
                photo.bitmapToMultipart()
            }
        }

    val chooserIntent = Intent(Intent.ACTION_CHOOSER).apply {
        this.putExtra(
            Intent.EXTRA_INTENT,
            Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
        )
        this.putExtra(Intent.EXTRA_TITLE, "사용할 앱을 선택해주세요.")
    }

    CreateScreen(
        navController = navController,
        sheetState = sheetState,
        scrollState = scrollState,
        focusRequester = focusRequester,
        interactionSource = interactionSource,
        activity = activity,
        image = image,
        bitmap = bitmap,
        scope = scope,
        content = content,
        takePhotoFromAlbumLauncher = takePhotoFromAlbumLauncher,
        takePhotoFromCameraLauncher = takePhotoFromCameraLauncher,
        chooserIntent = chooserIntent
    ) {
        createViewModel.createPost(content.value, image)
    }
}

@Composable
internal fun CreateScreen(
    navController: NavController,
    sheetState: ModalBottomSheetState,
    scrollState: ScrollState,
    focusRequester: FocusRequester,
    interactionSource: MutableInteractionSource,
    activity: Activity,
    image: MultipartBody.Part? = null,
    bitmap: Bitmap? = null,
    scope: CoroutineScope,
    content: MutableState<String>,
    takePhotoFromAlbumLauncher: ManagedActivityResultLauncher<Intent, ActivityResult>,
    takePhotoFromCameraLauncher: ManagedActivityResultLauncher<Void?, Bitmap?>,
    chooserIntent: Intent,
    onClickSubmit: () -> Unit,
) {
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
                            onClick = onClickSubmit,
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
                        value = content.value,
                        onValueChange = { content.value = it },
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

                    bitmap?.let { image ->
                        AsyncImage(
                            modifier = Modifier
                                .padding(14.dp)
                                .size(100.dp)
                                .clip(RoundedCornerShape(20.dp)),
                            model = image,
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
                                    when (activity.checkSelfPermission(Manifest.permission.CAMERA)) {
                                        PackageManager.PERMISSION_GRANTED ->
                                            takePhotoFromCameraLauncher.launch()
                                        else ->
                                            ActivityCompat.requestPermissions(
                                                activity,
                                                arrayOf(Manifest.permission.CAMERA),
                                                2
                                            )
                                    }
                                },
                        ) {
                            CameraIcon(
                                modifier = Modifier
                                    .size(28.dp)
                                    .align(Alignment.CenterHorizontally),
                                tint = Aqua
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
                                    when (activity.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                                        PackageManager.PERMISSION_GRANTED ->
                                            takePhotoFromAlbumLauncher.launch(chooserIntent)
                                        else ->
                                            ActivityCompat.requestPermissions(
                                                activity,
                                                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                                                1
                                            )
                                    }
                                }
                        ) {
                            ImageIcon(
                                modifier = Modifier
                                    .size(28.dp)
                                    .align(Alignment.CenterHorizontally),
                                tint = Aqua
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

@Preview
@Composable
internal fun CreateScreenPreview() {
    BambooAndroidTheme {
        CreateScreen(
            navController = rememberNavController(),
            sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden),
            scrollState = rememberScrollState(),
            focusRequester = FocusRequester(),
            interactionSource = MutableInteractionSource(),
            activity = Activity(),
            scope = CoroutineScope(Dispatchers.Unconfined),
            content = remember { mutableStateOf("") },
            takePhotoFromAlbumLauncher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {},
            takePhotoFromCameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) {},
            chooserIntent = Intent()
        ) {

        }
    }
}


private fun handleSideEffect(
    navController: NavController,
    context: Context,
    sideEffect: CreateSideEffect,
) = when (sideEffect) {
    is CreateSideEffect.NavigateToHome -> {
        navController.navigate(NavRoute.HOME.routeName) {
            navArgument("postId") {
                type = NavType.StringType
            }
        }
    }
    is CreateSideEffect.Toast -> shortToast(context, sideEffect.text)
}

private fun shortToast(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

@SuppressLint("NewApi")
private fun Uri.uriToBitmap(context: Context): Bitmap {
    return when (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        true -> {
            val source = ImageDecoder.createSource(context.contentResolver, this)
            ImageDecoder.decodeBitmap(source)
        }
        else -> {
            MediaStore.Images.Media.getBitmap(context.contentResolver, this)
        }
    }
}

private fun Bitmap.bitmapToMultipart(): MultipartBody.Part {
    val byteArrayOutputStream = ByteArrayOutputStream()
    this.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
    val requestFile =
        RequestBody.create("image/png".toMediaTypeOrNull(), byteArrayOutputStream.toByteArray())
    return MultipartBody.Part.createFormData("image", "image.png", requestFile)
}