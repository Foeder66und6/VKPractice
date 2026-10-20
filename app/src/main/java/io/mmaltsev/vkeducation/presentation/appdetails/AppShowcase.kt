package io.mmaltsev.vkeducation.presentation.appdetails

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.vkpractice.AppList
import com.example.vkpractice.StoreApp
import com.example.vkpractice.apps
import io.mmaltsev.vkeducation.R
import io.mmaltsev.vkeducation.presentation.AppItem
import io.mmaltsev.vkeducation.presentation.ListDestination

//class AppShowcase {
//}

@Composable
fun AppShowcase(apps: List<StoreApp>, pagerState: PagerState, navOnItemClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(stringResource(R.string.label_showcase), Modifier.padding(bottom=8.dp), fontSize = 25.sp)
        HorizontalPager(pagerState) { page ->
            Column(verticalArrangement= Arrangement.spacedBy(8.dp)) {
                for (i in 0..2) {
                    val index = page * 3 + i
                    if (index < apps.size) {
                        AppItem(apps[index], Modifier.clickable(onClick = navOnItemClick))

                    }
                }
            }
        }
    }
}

@Composable
fun Pager() {

}

@Composable
@Preview
fun Previeww() {
    AppShowcase(apps, rememberPagerState(pageCount = {1}), {})
}