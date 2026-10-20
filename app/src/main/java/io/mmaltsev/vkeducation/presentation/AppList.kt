package com.example.vkpractice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import io.mmaltsev.vkeducation.R
import io.mmaltsev.vkeducation.presentation.AppDetailsDestination
import io.mmaltsev.vkeducation.presentation.AppItem

val appGuide = StoreApp("Magical forest guide", "trevelling", "The most complete collection of information about magical forests", R.drawable.forest)
val appSleep = StoreApp("Sleep manager", "health", "Application for tracking your sleep", R.drawable.sleep)
val appNutrition = StoreApp("Nutrition manager", "health", "This application heps you track consumed food and gained callories and nutrition elements. Contains a lot of other functions", R.drawable.looking)
public val apps = listOf(appGuide, appSleep, appNutrition, StoreApp("Magical forest guide", "trevelling", "The most complete collection of information about magical forests"), appNutrition, appNutrition, appSleep, appNutrition, appGuide)

@Composable
fun AppList(apps: List<StoreApp>, navOnClick: (Int) -> Unit, modifier: Modifier = Modifier) {
    Column(modifier) {
        Toolbar()

        LazyColumn() {
            for (i in 0..<apps.size) {
                item{
                    AppItem(apps[i], Modifier.clickable() {navOnClick(i * 1)})

                }
            }
        }
    }
}
@Composable
fun Toolbar() {
    Row(Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.secondary).padding(8.dp)) {
        Icon(painterResource(R.drawable.ic_launcher_foreground), stringResource(R.string.app_name), Modifier.size(75.dp))
    }
}
@Composable
fun AppColumn(apps: List<StoreApp>) {

}



@Composable
@Preview
fun preveiw() {

    //,R.drawable.forest
    //, R.drawable.sleep
    //, R.drawable.looking
}