package kr.hs.dgsw.bamboo.bamboo_android.core

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import kr.hs.dgsw.bamboo.bamboo_android.R
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.ButtonGray

@Composable
fun SearchIcon(
    modifier: Modifier = Modifier
) {
    Icon(
        painter = painterResource(id = R.drawable.search),
        contentDescription = null,
        modifier = modifier,
    )
}

@Composable
fun PlusIcon(
    modifier: Modifier = Modifier,
) {
    Icon(
        painter = painterResource(id = R.drawable.plus),
        contentDescription = null,
        modifier = modifier,
    )
}

@Composable
<<<<<<< HEAD
fun BackArrowIcon(
    modifier: Modifier = Modifier,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_back_arrow),
=======
fun BackIcon(
    modifier: Modifier = Modifier,
) {
    Icon(
        painter = painterResource(id = R.drawable.back),
>>>>>>> develop
        contentDescription = null,
        modifier = modifier,
    )
}
<<<<<<< HEAD

@Composable
fun CameraIcon(
    modifier: Modifier = Modifier,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_camera),
        contentDescription = null,
        modifier = modifier,
        tint = ButtonGray
    )
}

@Composable
fun ImageIcon(
    modifier: Modifier = Modifier,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_image),
        contentDescription = null,
        modifier = modifier,
        tint = ButtonGray
    )
}
=======
>>>>>>> develop
