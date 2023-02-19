package kr.hs.dgsw.bamboo.bamboo_android.feature.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import kr.hs.dgsw.bamboo.bamboo_android.R
import kr.hs.dgsw.bamboo.bamboo_android.core.PlusIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.SearchIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.component.TopBar
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Background
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.BambooAndroidTheme

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Background,
        topBar = { MainTopBar() }
    ) { innerPadding ->
    }
}

@Composable
fun MainTopBar() {
    TopBar(
        modifier = Modifier.background(Color.White),
        icon = {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null
            )
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                modifier = Modifier.size(34.dp),
                onClick = { /*TODO*/ },
                content = { SearchIcon() }
            )
            Spacer(modifier = Modifier.width(10.dp))
            IconButton(
                modifier = Modifier.size(34.dp),
                onClick = { /*TODO*/ },
                content = { PlusIcon() }
            )
            Spacer(modifier = Modifier.width(10.dp))
            IconButton(
                modifier = Modifier.size(34.dp),
                onClick = { /*TODO*/ },
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(34.dp)
                        .clip(CircleShape),
                    model = "https://pbs.twimg.com/profile_images/1374979417915547648/vKspl9Et_400x400.jpg",
                    contentDescription = null
                )
            }
        }
    }
}

@Preview(showBackground = true, heightDp = 844, widthDp = 390)
@Composable
fun PreviewMainScreen() {
    BambooAndroidTheme {
        MainScreen()
    }
}