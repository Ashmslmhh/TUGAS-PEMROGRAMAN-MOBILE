package com.example.latihanlazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import com.example.latihanlazylist.ui.ItemListScreen
import com.example.latihanlazylist.viewmodel.ItemViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: ItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = lightColorScheme()) {
                ItemListScreen(viewModel)
            }
        }
    }
}