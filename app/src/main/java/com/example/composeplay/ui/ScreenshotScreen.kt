package com.example.composeplay.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeplay.R
import com.example.composeplay.model.AppDetailsViewModel
import com.example.composeplay.ui.theme.ComposePlayTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState


@Composable
fun ScreenshotScreen(
    viewModel: AppDetailsViewModel,
    screenShotPosition: Int,
    navigateBack: () -> Unit,
) {
    val screenshotState = viewModel.getAppScreenshot().collectAsState().value
    ScreenshotScreen(screenshotState, screenShotPosition, navigateBack)
}

@Composable
@OptIn(ExperimentalPagerApi::class)
private fun ScreenshotScreen(
    screenResList: List<Int>,
    screenShotPosition: Int,
    navigateBack: () -> Unit
) {
    Box {
        HorizontalPager(
            count = screenResList.size,
            state = rememberPagerState(screenShotPosition)
        ) { page ->
            val itemRes = screenResList[page]
            Image(
                painter = painterResource(id = itemRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
        }
        IconButton(onClick = navigateBack ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = stringResource(R.string.back_button),
                tint = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun ImagesScreenPreview() {
    ComposePlayTheme {
        Surface {
            ScreenshotScreen(
                screenResList = listOf(R.drawable.app_screen_1),
                screenShotPosition = 0,
                navigateBack = {}
            )
        }
    }
}