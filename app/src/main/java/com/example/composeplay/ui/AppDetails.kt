package com.example.composeplay.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
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
import com.example.composeplay.R
import com.example.composeplay.ui.theme.ComposePlayTheme
import com.example.composeplay.ui.theme.GeneralInfoDescription
import com.example.composeplay.ui.theme.Green


@Composable
fun ApplicationFullInfo() {
    Column(modifier = Modifier
        .padding(horizontal = 24.dp)
        .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(24.dp))
        AppHeader()
        Spacer(Modifier.height(16.dp))
        AppGeneralInfo()
        Spacer(Modifier.height(16.dp))
        Button(
            colors = ButtonDefaults.buttonColors(Green),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            onClick = { /*TODO*/ },
        ) {
            Text(text = stringResource(R.string.install), color = Color.White, letterSpacing = 0.5.sp)
        }
        Spacer(Modifier.height(16.dp))
        ScreenshotCarousel()
        Spacer(Modifier.height(16.dp))
        AboutSection()
        Spacer(Modifier.height(16.dp))
        SafetySection()
        Spacer(Modifier.height(24.dp))
    }
}

@Composable
private fun AppHeader() {
    Row(modifier = Modifier.padding(top = 12.dp)) {
        Image(
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = stringResource(R.string.description_app_icon),
            modifier = Modifier.size(72.dp)
        )
        Column {
            Text(
                text = "GitHub",
                modifier = Modifier.padding(start = 24.dp),
                fontSize = 24.sp
            )
            Text(
                text = "GitHub",
                Modifier.padding(start = 24.dp),
                color = Green,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
private fun AppGeneralInfo() {
    Row(
        modifier = Modifier.height(IntrinsicSize.Min),
        verticalAlignment = Alignment.Bottom
    ) {
        DetailsRating(this)
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .padding(vertical = 8.dp),
        )
        DetailsSize(this)
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .padding(vertical = 8.dp),
        )
        DetailsAge(this)
    }
}

@Composable
private fun DetailsRating(scope: RowScope) {
    scope.apply {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "4.8",
                    fontWeight = FontWeight.SemiBold,
                )
                Image(
                    painter = painterResource(R.drawable.ic_star),
                    contentDescription = "Content Star image",
                    modifier = Modifier.size(14.dp)
                )
            }
            Text(
                text = "66K reviews",
                style = GeneralInfoDescription,
            )
        }
    }
}

@Composable
private fun DetailsSize(scope: RowScope) {
    scope.apply {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.Companion.weight(1f)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_download),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "10MB",
                style = GeneralInfoDescription,
            )
        }
    }
}

@Composable
private fun DetailsAge(scope: RowScope) {
    scope.apply {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_looks_3),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Rated for 3+",
                style = GeneralInfoDescription,
            )
        }
    }
}

@Composable
private fun ScreenshotCarousel() {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        val list = listOf(
            R.drawable.app_screen_1,
            R.drawable.app_screen_2,
            R.drawable.app_screen_1,
            R.drawable.app_screen_2,
            R.drawable.app_screen_1,
            R.drawable.app_screen_2,
            R.drawable.app_screen_1,
            R.drawable.app_screen_2
        )
        items(list) {
            Image(
                painter = painterResource(id = it),
                contentDescription = stringResource(R.string.screenshot_description),
                modifier = Modifier.height(150.dp),
            )
        }
    }
}

@Composable
private fun AboutSection() {
    Column {
        Button(
            colors = ButtonDefaults.buttonColors(Color.White),
            elevation = null,
            contentPadding = PaddingValues(0.dp),
            onClick = {/*TODO*/ }
        ) {
            Text(
                text = stringResource(R.string.about_app),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 8.dp),
                color = Color.Black,
                letterSpacing = 0.5.sp,
            )
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_forward),
                contentDescription = null
            )
        }
        Text(
            "Triage notifications, review, comment and merge, right from your mobile device",
            fontSize = 14.sp,
            lineHeight = 22.sp,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Button(
            colors = ButtonDefaults.buttonColors(Color.White),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color.LightGray),
            elevation = null,
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "Productivity",
                letterSpacing = 0.5.sp,
                color = Color.Black
            )
        }

    }
}

@Composable
private fun SafetySection() {
    Column {
        Button(
            colors = ButtonDefaults.buttonColors(Color.White),
            elevation = null,
            contentPadding = PaddingValues(0.dp),
            onClick = {/*TODO*/ }
        ) {
            Text(
                text = stringResource(R.string.data_safety),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 8.dp),
                color = Color.Black,
                letterSpacing = 0.5.sp,
            )
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_forward),
                contentDescription = null
            )
        }
        Text(
            "Safety starts with understanding how develops collect and share your data. " +
                    "Data privacy and security practices may very based on your use, region and age." +
                    " The developer provided this information and may update it over time",
            fontSize = 14.sp,
            lineHeight = 22.sp,
            modifier = Modifier.padding(bottom = 12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePlayTheme {
        ApplicationFullInfo()
    }
}