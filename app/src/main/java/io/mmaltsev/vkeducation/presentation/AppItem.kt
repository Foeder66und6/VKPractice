package io.mmaltsev.vkeducation.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkpractice.StoreApp
import io.mmaltsev.vkeducation.R

@Composable
fun AppItem(app: StoreApp, modifier: Modifier = Modifier) {
    Row(modifier.padding(8.dp), horizontalArrangement= Arrangement.spacedBy((8.dp))) {
        Image(painterResource(app.iconID), app.title, Modifier.size(100.dp, 100.dp).clip(RoundedCornerShape(25.dp)), contentScale=ContentScale.Crop)
        Column(verticalArrangement=Arrangement.spacedBy(6.dp)) {
            Text(app.title, maxLines = 1, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text("${stringResource(R.string.label_category)}: ${app.category}", maxLines = 1)
            Text(app.description, maxLines = 2, overflow = TextOverflow.Ellipsis)
        }
    }
}