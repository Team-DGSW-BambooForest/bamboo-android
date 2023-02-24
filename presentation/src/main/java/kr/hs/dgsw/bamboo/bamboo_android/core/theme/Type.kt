package kr.hs.dgsw.bamboo.bamboo_android.core.theme

import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kr.hs.dgsw.bamboo.bamboo_android.R

val NotoSans = FontFamily(
    Font(R.font.notosans_medium, FontWeight.Medium),
    Font(R.font.notosans_regular, FontWeight.Normal)
)

@ExperimentalTextApi
@Composable
fun Body1(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = Black,
) {
    Text(
        modifier = modifier,
        text = text,
        color = textColor,
        fontFamily = NotoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        style = TextStyle(
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            )
        )
    )
}

@ExperimentalTextApi
@Composable
fun Body2(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = Black,
) {
    Text(
        modifier = modifier,
        text = text,
        color = textColor,
        fontFamily = NotoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        style = TextStyle(
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            )
        )
    )
}

@ExperimentalTextApi
@Composable
fun Subtitle1(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = Black,
) {
    Text(
        modifier = modifier,
        text = text,
        color = textColor,
        fontFamily = NotoSans,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        style = TextStyle(
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            )
        )
    )
}

@ExperimentalTextApi
@Composable
fun Subtitle2(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = Black,
) {
    Text(
        modifier = modifier,
        text = text,
        color = textColor,
        fontFamily = NotoSans,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        style = TextStyle(
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            )
        )
    )
}

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
