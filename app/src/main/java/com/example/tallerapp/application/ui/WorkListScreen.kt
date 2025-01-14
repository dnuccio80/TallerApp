package com.example.tallerapp.application.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tallerapp.ui.theme.BackgroundColor
import com.example.tallerapp.ui.theme.CardBackgroundColor
import com.example.tallerapp.ui.theme.SecondBackgroundColor
import com.example.tallerapp.ui.theme.SecondaryTextColor
import com.example.tallerapp.ui.theme.TextColor

@Composable
fun WorkListScreen(innerPadding: PaddingValues) {
    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        BackgroundColor,
                        SecondBackgroundColor
                    )
                )
            )
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text(
                "Work Record".uppercase(),
                modifier = Modifier.padding(horizontal = 16.dp),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp
            )
            Spacer(Modifier.size(16.dp))
            WorkItem()
            WorkItem()
            WorkItem()
            WorkItem()
            WorkItem()
        }
        WorkListFabItem(Modifier.align(Alignment.BottomEnd))
    }
}

@Composable
fun WorkListFabItem(modifier: Modifier) {
    FloatingActionButton(
        onClick = { },
        modifier = modifier.padding(vertical = 128.dp, horizontal = 16.dp),

    ) {
        Icon(Icons.Filled.Add, contentDescription = "add button")
    }
}

@Composable
fun WorkItem() {
    Card(
        Modifier
            .fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardBackgroundColor
        ),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Row (Modifier.fillMaxWidth().padding(8.dp)){
            Text("Tubo torneado", modifier = Modifier.weight(1f), fontWeight = FontWeight.ExtraBold, color = SecondaryTextColor)
            Text("Valot unit:", modifier = Modifier.padding(end = 8.dp), fontWeight = FontWeight.SemiBold, color = SecondaryTextColor)
            Text("$52.800", modifier = Modifier.padding(end = 16.dp), fontWeight = FontWeight.Bold, color = SecondaryTextColor)
            Icon(Icons.Filled.Edit, contentDescription = "Edit button", modifier = Modifier.padding(horizontal = 16.dp))
            Icon(Icons.Filled.Delete, contentDescription = "Edit button")
        }
    }
}