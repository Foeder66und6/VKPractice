package com.example.vkpractice.presentation

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkpractice.R
import com.example.vkpractice.domain.App
import com.example.vkpractice.domain.DetailedApp
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppScreen(appID: String, modifier: Modifier = Modifier, viewModel: AppDetailsViewModel = koinViewModel()) {
    viewModel.getDetails(appID)
    val appDetails = viewModel.appDetails.collectAsState().value
    if (appDetails is DetailsScreenState.DetailsEmpty) {
        Text(":(")
    }
    if (appDetails is DetailsScreenState.DetailsContent) {
        val app = appDetails.details
        Column(modifier.padding(horizontal=8.dp)) {
            MainBlock(app)
            Screenshots(app.screenshots)
            Text(app.description, fontSize=20.sp)
            Button({viewModel.onLoadClick()}, modifier=Modifier.fillMaxWidth()) {
                val loadingState = viewModel.loadingState.collectAsState().value
                var text = stringResource(R.string.installed)
                if (loadingState < 0.0f) {
                    text = stringResource(R.string.install)
                }
                if (0.0f < loadingState  && loadingState < app.size) {
                    text = "${stringResource(R.string.installing)}... (${loadingState}/${app.size})"
                }
                Text(text, fontSize = 30.sp)
            }
        }
    }
}

@Composable
fun MainBlock(app: DetailedApp) {
Column() {
    Row(horizontalArrangement=spacedBy(12.dp)) {
        Image(bitmap = app.icon.asImageBitmap(), contentDescription=app.title )
        Column(verticalArrangement=spacedBy(4.dp)) {
            Text(app.title, fontSize=30.sp, fontWeight= FontWeight.Bold)
            Text(app.developer, fontSize=20.sp)
            Row(horizontalArrangement=spacedBy(8.dp)) {
                Text(app.ageRating.toString())
                Text(app.size.toString())
            }
        }
    }

}
}
@Composable
fun Screenshots(screenshots: List<Bitmap>, modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(stringResource(R.string.app_screenshots), fontSize=40.sp)
        Row(horizontalArrangement=spacedBy(4.dp), modifier = Modifier.horizontalScroll(rememberScrollState(0)).padding(40.dp).background(Color.Blue)) {
            for (s in screenshots) {

                Image(bitmap = s.asImageBitmap(), contentDescription = "", Modifier.size(350.dp), contentScale= ContentScale.FillWidth)
            }
        }

    }
}

@Composable
fun SimalarApps(apps: List<App>, modifier: Modifier = Modifier) {
    Column() {
        Text(stringResource(R.string.details_similar_label))
    }
}
@Preview
@Composable
private fun Prev() {
    Screenshots(listOf(), Modifier)//List "a", "b", "c" listOf(1, 2, 3)
}