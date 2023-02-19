package kr.hs.dgsw.bamboo.bamboo_android.core

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import kr.hs.dgsw.bamboo.bamboo_android.R

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
