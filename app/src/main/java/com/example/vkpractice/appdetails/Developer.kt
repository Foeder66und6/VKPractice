package com.example.vkpractice.appdetails

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.vkpractice.R
import com.example.vkpractice.ui.theme.VKPracticeTheme


@Composable
fun Developer(
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.clickable(onClick = onClick),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(text = name)
            Text(text = stringResource(R.string.app_details_developer))
        }
        IconButton(onClick = onClick) {
            Icon(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    VKPracticeTheme() {
        Developer(
            name = "VK Play",
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
        )
    }
}