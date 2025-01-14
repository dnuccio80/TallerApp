package com.example.tallerapp.application.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.tallerapp.R
import com.example.tallerapp.application.ui.models.Routes
import com.example.tallerapp.ui.theme.CardBackgroundColor

@Composable
fun BottomAppBarItem(navigationController: NavHostController) {

    var indexSelected by rememberSaveable { mutableIntStateOf(0) }

    NavigationBar(
        Modifier.fillMaxWidth(),
        containerColor = CardBackgroundColor,
        tonalElevation = 16.dp,
    ) {
        NavigationBarItem(
            selected = indexSelected == 0,
            onClick = {
                indexSelected = 0
                navigationController.navigate(Routes.HomeScreen.route)
            },
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home button") },
            label = { Text("Home") }
        )

        NavigationBarItem(
            selected = indexSelected == 1,
            onClick = {
                indexSelected = 1
                navigationController.navigate(Routes.WorkListScreen.route)
            },
            icon = {
                Icon(
                    painterResource(R.drawable.ic_work),
                    contentDescription = "work list button",
                )
            },
            label = { Text("Work Record") }
        )

        NavigationBarItem(
            selected = indexSelected == 2,
            onClick = {
                indexSelected = 2
                navigationController.navigate(Routes.AnnotationsScreen.route)
            },
            icon = {
                Icon(
                    Icons.Default.AccountBox,
                    contentDescription = "Annotations button",
                )
            },
            label = { Text("Annotations") }
        )
    }
}
