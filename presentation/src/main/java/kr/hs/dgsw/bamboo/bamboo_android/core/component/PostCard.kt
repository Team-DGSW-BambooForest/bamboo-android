@file:OptIn(ExperimentalTextApi::class)

package kr.hs.dgsw.bamboo.bamboo_android.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.BambooAndroidTheme
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Body1
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.TextGray

@Composable
internal fun PostCard(
    modifier: Modifier = Modifier,
    profileImage: String,
    name: String,
    createTime: String,
    content: String,
    contentImage: String? = null,
    commentSize: Int = 0,
    onClick: () -> Unit,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.White)
            .padding(
                horizontal = 14.dp,
                vertical = 12.dp
            )
    ) {
        Column {
            BambooProfile(
                name = name,
                profileImage = profileImage,
                createTime = createTime
            )
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

            Body1(
                modifier = Modifier
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null,
                        onClick = onClick
                    ),
                text = if (commentSize == 0) "댓글 작성하기" else "댓글 ${commentSize}개 모두 보기",
                textColor = TextGray
            )
        }
    }
}

@Preview
@Composable
internal fun PostCardPreview() {
    BambooAndroidTheme {
        PostCard(
            profileImage = "",
            name = "홍길동",
            createTime = "2022.01.20",
            content = "Preview Test"
        ) {
        }
    }
}
