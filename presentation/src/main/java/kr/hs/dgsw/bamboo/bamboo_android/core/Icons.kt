package kr.hs.dgsw.bamboo.bamboo_android.core

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
<<<<<<< Updated upstream
=======
import androidx.compose.ui.graphics.Color
>>>>>>> Stashed changes
import androidx.compose.ui.res.painterResource
import kr.hs.dgsw.bamboo.bamboo_android.R

@Composable
<<<<<<< Updated upstream
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
=======
fun BackArrow(
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_back_arrow),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
>>>>>>> Stashed changes
    )
}
