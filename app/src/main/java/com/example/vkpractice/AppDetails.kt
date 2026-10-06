package com.example.vkpractice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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

@Composable
fun AppScreen() {}//x

@Composable
fun Screenshots(screenshots: List<Int>, modifier: Modifier) {//String
    Column(modifier) {
        Text(stringResource(R.string.app_screenshots), fontSize=40.sp)//id.//,sp , Modifier.size(40.dp)
        Row(horizontalArrangement=spacedBy(4.dp), modifier = Modifier.horizontalScroll(rememberScrollState(0))) {//Spaced
            for (s in screenshots) {
                //Box(Modifier.size(width=230.dp, height=43.dp).background(Color.Blue))//() c
                Image(painter = painterResource(s), contentDescription = "", Modifier.size(350.dp), contentScale= ContentScale.FillWidth)//xim PainterRes m R.drawable.u_exact width=0.dp, height = .content
            }
        }

    }
}//i
@Preview
@Composable
private fun Prev() {
    Screenshots(listOf(1, 2, 3), Modifier)//List "a", "b", "c"
}