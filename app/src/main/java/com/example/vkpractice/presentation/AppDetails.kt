package com.example.vkpractice.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkpractice.R
import com.example.vkpractice.domain.App

@Composable
fun AppScreen() {

}

@Composable
fun Screenshots(screenshots: List<Int>, modifier: Modifier) {
    Column(modifier) {
        Text(stringResource(R.string.app_screenshots), fontSize=40.sp)
        Row(horizontalArrangement=spacedBy(4.dp), modifier = Modifier.horizontalScroll(rememberScrollState(0)).padding(40.dp).background(Color.Blue)) {
            for (s in screenshots) {

                Image(painter = painterResource(s), contentDescription = "", Modifier.size(350.dp), contentScale= ContentScale.FillWidth)
            }
        }

    }
}//ii

@Composable
fun SimalarApps(apps: List<App>, modifier: Modifier = Modifier) {
    Column() {
        Text(stringResource(R.string.details_similar_label))
    }
}
@Preview
@Composable
private fun Prev() {
    Screenshots(listOf(1, 2, 3), Modifier)//List "a", "b", "c"
}