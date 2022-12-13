package com.example.composeplay.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composeplay.model.AppDetailsViewModel
import com.example.composeplay.model.AppInfo
import com.example.composeplay.R
import com.example.composeplay.model.gitHubInfo
import com.example.composeplay.ui.theme.ComposePlayTheme


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@OptIn(ExperimentalLifecycleComposeApi::class)
fun ApplicationFullInfoScreen(
    viewModel: AppDetailsViewModel,
    openAboutScreen: () -> Unit,
    openImages: (Int) -> Unit
) {
    val state = viewModel.getAppInfo().collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { /*Text("GitHub") */ },
                backgroundColor = MaterialTheme.colors.background,
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.ArrowBack, stringResource(R.string.back_button))
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Search, stringResource(R.string.search_button))
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.MoreVert, stringResource(R.string.menu_button))
                    }
                }
            )
        },
        content = { paddingValues ->
            ApplicationFullInfo(state.value, paddingValues, openAboutScreen, openImages)
        }
    )

}

@Composable
private fun ApplicationFullInfo(
    appInfo: AppInfo,
    paddingValues: PaddingValues,
    openAboutScreen: () -> Unit,
    openImages: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .verticalScroll(rememberScrollState())
    ) {
        AppHeader(appInfo)
        Spacer(Modifier.height(16.dp))
        AppGeneralInfo(appInfo)
        Spacer(Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            shape = RoundedCornerShape(16.dp),
            onClick = { /*TODO*/ },
        ) {
            Text(
                text = stringResource(R.string.install),
                letterSpacing = 0.5.sp
            )
        }
        Spacer(Modifier.height(16.dp))
        ScreenshotCarousel(appInfo.screenshotRes, openImages)
        Spacer(Modifier.height(16.dp))
        AboutSection(appInfo.aboutApp, appInfo.tags, openAboutScreen)
        Spacer(Modifier.height(16.dp))
        SafetySection(appInfo.dataSafety)
        Spacer(Modifier.height(36.dp))
    }
}

@Composable
private fun AppHeader(appInfo: AppInfo) {
    Row(modifier = Modifier.padding(top = 12.dp, start = 24.dp, end = 24.dp)) {
        Image(
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = stringResource(R.string.description_app_icon),
            modifier = Modifier.size(72.dp)
        )
        Column {
            Text(
                text = appInfo.name,
                modifier = Modifier.padding(start = 24.dp),
                fontSize = 24.sp
            )
            Text(
                text = appInfo.publisherName,
                Modifier.padding(start = 24.dp),
                color = MaterialTheme.colors.primary,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
private fun AppGeneralInfo(appInfo: AppInfo) {
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .padding(horizontal = 24.dp),
        verticalAlignment = Alignment.Bottom,
    ) {
        DetailsRating(this, appInfo)
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .padding(vertical = 8.dp),
        )
        DetailsSize(this, appInfo)
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .padding(vertical = 8.dp),
        )
        DetailsAge(this, appInfo)
    }
}

@Composable
private fun DetailsRating(scope: RowScope, appInfo: AppInfo) {
    scope.apply {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = appInfo.rating,
                    fontWeight = FontWeight.SemiBold,
                )
                Image(
                    painter = painterResource(R.drawable.ic_star),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
                    modifier = Modifier.size(14.dp)
                )
            }
            Text(
                text = appInfo.reviewCount,
                style = MaterialTheme.typography.caption,
            )
        }
    }
}

@Composable
private fun DetailsSize(scope: RowScope, appInfo: AppInfo) {
    scope.apply {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.Companion.weight(1f)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_download),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = appInfo.size,
                style = MaterialTheme.typography.caption,
            )
        }
    }
}

@Composable
private fun DetailsAge(scope: RowScope, appInfo: AppInfo) {
    scope.apply {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_looks_3),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = appInfo.ageRating,
                style = MaterialTheme.typography.caption,
            )
        }
    }
}

@Composable
private fun ScreenshotCarousel(
    screenshotRes: List<Int>,
    openImages: (Int) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        itemsIndexed(screenshotRes) { position, item ->
            Image(
                painter = painterResource(id = item),
                contentDescription = stringResource(R.string.screenshot_description),
                modifier = Modifier
                    .height(150.dp)
                    .clickable { openImages(position) },
            )
        }
    }
}

@Composable
private fun AboutSection(
    aboutApp: String,
    tags: List<String>,
    openAboutScreen: () -> Unit
) {
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Button(
            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface),
            elevation = null,
            contentPadding = PaddingValues(0.dp),
            onClick = { openAboutScreen() }
        ) {
            Text(
                text = stringResource(R.string.about_app),
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 8.dp),
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.subtitle1
            )
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_forward),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
            )
        }
        Text(
            text = aboutApp,
            fontSize = 14.sp,
            lineHeight = 22.sp,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        AboutTagList(tags)
    }
}

@Composable
private fun AboutTagList(tags: List<String>) {
    LazyRow {
        items(tags) {
            Button(
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(0.5.dp, MaterialTheme.colors.onSurface),
                elevation = null,
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = it,
                    color = MaterialTheme.colors.onSurface
                )
            }
        }
    }
}

@Composable
private fun SafetySection(dataSafety: String) {
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        Button(
            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.surface),
            elevation = null,
            contentPadding = PaddingValues(0.dp),
            onClick = {/*TODO*/ }
        ) {
            Text(
                text = stringResource(R.string.data_safety),
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 8.dp),
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.subtitle1
            )
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_forward),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface)
            )
        }
        Text(
            text = dataSafety,
            fontSize = 14.sp,
            lineHeight = 22.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePlayTheme {
        ApplicationFullInfo(
            appInfo = gitHubInfo,
            paddingValues = PaddingValues(),
            openAboutScreen = {},
            openImages = {}
        )
    }
}

@Preview
@Composable
fun DefaultPreviewDark() {
    ComposePlayTheme(darkTheme = true) {
        ApplicationFullInfo(
            appInfo = gitHubInfo,
            paddingValues = PaddingValues(),
            openAboutScreen = {},
            openImages = {}
        )
    }
}