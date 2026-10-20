package io.mmaltsev.vkeducation.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.vkpractice.AppList
import com.example.vkpractice.apps
import dagger.hilt.android.AndroidEntryPoint
import io.mmaltsev.vkeducation.presentation.appdetails.AppDetailsScreen
import io.mmaltsev.vkeducation.presentation.theme.VkEducationTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkEducationTheme {
                Scaffold() {contentPadding ->
                    RootNavHost(Modifier.padding(contentPadding))
                }
                //AppDetailsScreen()
            }
        }
    }
}