package kr.hs.dgsw.bamboo.bamboo_android.core

import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import kr.hs.dgsw.bamboo.bamboo_android.R

@Composable
fun SearchIcon(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
) {
    Icon(
        painter = painterResource(id = R.drawable.search),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun PlusIcon(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
) {
    Icon(
        painter = painterResource(id = R.drawable.plus),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun BackIcon(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
) {
    Icon(
        painter = painterResource(id = R.drawable.back),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun AddIcon(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
) {
    Icon(
        painter = painterResource(id = R.drawable.add),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun CameraIcon(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
) {
    Icon(
        painter = painterResource(id = R.drawable.camera),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun ImageIcon(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
) {
    Icon(
        painter = painterResource(id = R.drawable.image),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun LogoIcon(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
) {
    Icon(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun ProfileIcon(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
) {
    Icon(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
internal fun SelectedProfileIcon(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    tint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
) {
    Icon(
        painter = painterResource(id = R.drawable.select_profile),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}
