package com.example.vkpractice

//import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
//import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

//import androidx.compose.ui.text.style.LineHeightStyle.Alignment

@Composable
fun AppList(modifier: Modifier = Modifier, viewModel: AppListViewModel = viewModel() ) {
    val apps = viewModel.appList.collectAsState().value

    Column(modifier) {
        Toolbar(Modifier.clickable() {viewModel.sendMessage("ok")})

        Box() {
            LazyColumn() {

                for (app in apps) {
                    item{
                        AppItem(app, Modifier.clickable(){viewModel.addNaxt(app)})

                    }
                }
            }
            val msg = viewModel.events.collectAsState(null).value
            LaunchedEffect(viewModel.events) {
                viewModel.events.collect {msg ->
//                    SnackbarHostState().showSnackbar(msg?: ":(")

                }

            }//viewN
            if (msg != null) {//ша
                DismissableButton(true, modifier = Modifier.padding(20.dp).fillMaxWidth().align(
                    Alignment.BottomCenter)) {Text(msg)}//,

            }

        }
//        Button() {
//            Text("ok")
//        }
    }

}
@Composable
fun DismissableButton( isVis: Boolean, modifier: Modifier = Modifier, content: @Composable (RowScope.() -> Unit)) {// Unitr
    var isVisible by remember {mutableStateOf(true)}
    if (isVisible) {
        Button(onClick = {isVisible = false}, modifier = modifier, content = content)// {Text("ok") }

    }

//    fun DismissableButton(modifier: Modifier =  content: @Composable (RowScope.() -> Unit)) {// Unitr
}
@Composable
fun Toolbar(modifier: Modifier = Modifier) {
    Row(modifier.fillMaxWidth().background(MaterialTheme.colorScheme.secondary).padding(8.dp)) {
        Icon(painterResource(R.drawable.ic_launcher_foreground), stringResource(R.string.desc_app_icon), Modifier.size(75.dp))
    }
}
@Composable
fun AppColumn(apps: List<App>) {

}

@Composable
fun AppItem(app: App, modifier: Modifier = Modifier) {
    Row(modifier.padding(8.dp), horizontalArrangement= Arrangement.spacedBy((8.dp))) {
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
    AppList()
}