package com.example.labortorio06

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomBottomBar() {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(onClick = { print("Build") }) {
                Icon(Icons.Filled.Build, contentDescription = "Build description")
            }
            IconButton(onClick = { print("Menu") }) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "Menu description",
                )
            }
            IconButton(onClick = { print("Favorite") }) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite description",
                )
            }
            IconButton(onClick = { print("Delete") }) {
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = "Delete description",
                )
            }
        }
    }
}
@Composable
@Preview
fun CustomBottomBarPreview() {
    CustomBottomBar()
}