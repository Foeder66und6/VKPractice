
package com.example.vkpractice

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.vkpractice.ui.theme.VKPracticeTheme//.Theme//

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKPracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    //Screenshots(listOf(R.drawable.forest, R.drawable.sleep, R.drawable.running, R.drawable.looking), Modifier.padding(innerPadding))// 1, 2, 3 ,
                    AppList(listOf(App("Magical forest guide", "trevelling", "The most complete collection of information about magical forests",R.drawable.forest), App("Sleep manager", "health", "Application for tracking your sleep", R.drawable.sleep), App("Nutrition manager", "health", "This application heps you track consumed food and gained callories and nutrition elements. Contains a lot of other functions", R.drawable.looking)), Modifier.padding(innerPadding))
                }
            }
        }
        val intt = Intent()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VKPracticeTheme {
        Greeting("Android")
    }
}