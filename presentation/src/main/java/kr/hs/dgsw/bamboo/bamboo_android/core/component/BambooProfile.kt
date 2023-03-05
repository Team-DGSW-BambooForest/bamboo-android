package kr.hs.dgsw.bamboo.bamboo_android.core.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Body2
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Subtitle2
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.TextGray

@ExperimentalTextApi
@Composable
fun BambooProfile(
    name: String,
    profileImage: String,
    createTime: String
) {
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
}
