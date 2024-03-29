@file:OptIn(ExperimentalMaterialApi::class, ExperimentalTextApi::class)

package kr.hs.dgsw.bamboo.bamboo_android.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kr.hs.dgsw.bamboo.bamboo_android.R
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Aqua
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.BambooAndroidTheme
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Body2
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Gray
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Subtitle1

@Composable
internal fun BambooBottomSheet(
    sheetState: ModalBottomSheetState,
    content: @Composable () -> Unit
) {
    val radioState = remember { mutableStateOf(true) }

    BambooBottomSheet(
        sheetState = sheetState,
        radioState = radioState,
        content = content
    )
}

@Composable
internal fun BambooBottomSheet(
    sheetState: ModalBottomSheetState,
    radioState: MutableState<Boolean>,
    content: @Composable () -> Unit
) {
    ModalBottomSheetLayout(
        sheetShape = RoundedCornerShape(
            topStart = 15.dp,
            topEnd = 15.dp
        ),
        sheetState = sheetState,
        sheetContent = {
            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(40.dp)
                    .height(4.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFDDDDDD))
            )

            Spacer(modifier = Modifier.height(12.dp))

            Subtitle1(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "내 프로필 선택"
            )

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .padding(horizontal = 14.dp)
                    .background(Color(0xFFF2F2F2)),
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp)
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(34.dp)
                        .clip(CircleShape),
                    model = R.drawable.profile,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(12.dp))
                Body2(text = "익명이")
                Spacer(modifier = Modifier.weight(1F))
                RadioButton(
                    selected = radioState.value,
                    onClick = { radioState.value = true },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Aqua,
                        unselectedColor = Gray
                    )
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(34.dp)
                        .clip(CircleShape),
                    model = R.drawable.add,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(12.dp))
                Body2(
                    text = "도담도담 계정을 등록하세요!",
                    textColor = Gray
                )
                Spacer(modifier = Modifier.weight(1F))
                RadioButton(
                    selected = radioState.value.not(),
                    onClick = { radioState.value = false },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Aqua,
                        unselectedColor = Gray
                    )
                )
            }
            Spacer(modifier = Modifier.height(18.dp))
        }
    ) {
        content()
    }
}

@Preview
@Composable
internal fun BambooBottomSheetPreview() {
    BambooAndroidTheme {
        BambooBottomSheet(
            sheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Expanded),
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
            }
        }
    }
}
