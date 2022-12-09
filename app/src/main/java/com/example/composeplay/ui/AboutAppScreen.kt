package com.example.composeplay.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composeplay.R
import com.example.composeplay.model.AppDetails
import com.example.composeplay.model.AppDetailsViewModel
import com.example.composeplay.model.gitHubAppDetails
import com.example.composeplay.ui.theme.ComposePlayTheme

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun AboutAppScreen(
    viewModel: AppDetailsViewModel,
    navigateBack: () -> Unit
) {
    val appDetails = viewModel.getAppDetails().collectAsStateWithLifecycle().value
    Scaffold(
        topBar = {
            TopBar(navigateBack)
        },
        content = { paddingValue ->
            AboutAppScreen(appDetails, paddingValue)
        }
    )
}

@Composable
private fun TopBar(
    navigateBack: () -> Unit
) {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.app_logo),
                    contentDescription = "",
                    modifier = Modifier.size(48.dp).padding(end = 24.dp)
                )
                Column {
                    Text(
                        text = "GitHub",
                        fontSize = 14.sp
                    )
                    Text(
                        text = "Details",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        },
        backgroundColor = MaterialTheme.colors.background,
        navigationIcon = {
            IconButton(onClick = { navigateBack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back_button)
                )
            }
        }
    )
}

@Composable
fun AboutAppScreen(
    appDetails: AppDetails,
    paddingValue: PaddingValues
) {
    LazyColumn(modifier = Modifier.padding(paddingValue)) {
        item {
            Text(
                text = stringResource(R.string.about_this_app),
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 24.dp, start = 24.dp, end = 24.dp)
            )
        }
        item {
            Text(
                text = appDetails.aboutAppText,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                modifier = Modifier
                    .padding(vertical = 12.dp, horizontal = 24.dp),
            )
        }
        item {
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
            )
        }
        item {
            Text(
                text = stringResource(R.string.what_new),
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 12.dp, start = 24.dp, end = 24.dp)
            )
        }
        item {
            Text(
                text = appDetails.whatNewText,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 24.dp),
            )
        }
    }
}

@Preview
@Composable
fun AboutAppScreenPreview() {
    ComposePlayTheme(darkTheme = false) {
        Surface {
            AboutAppScreen(gitHubAppDetails, PaddingValues())
        }
    }
}


@Preview
@Composable
fun TopBarPreview() {
    ComposePlayTheme {
        Surface {
           (TopBar {})
        }
    }
}