package com.example.vkpractice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppList(apps: List<App>, modifier: Modifier = Modifier) {
    Column(modifier) {
        Toolbar()

        LazyColumn() {
            for (app in apps) {
                item{
                    AppItem(app)

                }
            }
        }
    }
}
@Composable
fun Toolbar() {
    Row(Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.secondary).padding(8.dp)) {
        Icon(painterResource(R.drawable.ic_launcher_foreground), stringResource(R.string.desc_app_icon), Modifier.size(75.dp))
    }
}
@Composable
fun AppColumn(apps: List<App>) {

}

@Composable
fun AppItem(app: App) {
    Row(Modifier.padding(8.dp), horizontalArrangement= Arrangement.spacedBy((8.dp))) {
        Image(painterResource(app.iconID), app.title, Modifier.size(100.dp, 100.dp).clip(RoundedCornerShape(25.dp)), contentScale=ContentScale.Crop)
        Column(verticalArrangement=Arrangement.spacedBy(6.dp)) {
            Text(app.title, maxLines = 1, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text("${stringResource(R.string.label_category)}: ${app.category}", maxLines = 1)
            Text(app.description, maxLines = 2, overflow = TextOverflow.Ellipsis)
        }
    }
}

@Composable
@Preview
fun preveiw() {
    val apps = listOf(App("Magical forest guide", "trevelling", "The most complete collection of information about magical forests",R.drawable.forest), App("Sleep manager", "health", "Application for tracking your sleep", R.drawable.sleep), App("Nutrition manager", "health", "This application heps you track consumed food and gained callories and nutrition elements. Contains a lot of other functions", R.drawable.looking))
    AppList(apps)
}