package com.example.tallerapp.application.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tallerapp.ui.theme.BackgroundColor
import com.example.tallerapp.ui.theme.CardBackgroundColor
import com.example.tallerapp.ui.theme.SecondBackgroundColor

@Composable
fun AnnotationsScreen(innerPadding: PaddingValues) {
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
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(top = innerPadding.calculateTopPadding(), bottom = innerPadding.calculateBottomPadding(), start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),

        ) {
            items(20) {
                NoteItem()
            }
        }
    }
}

@Composable
fun NoteItem() {
    Card(
        Modifier
            .fillMaxWidth().padding(vertical = 4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardBackgroundColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Column(Modifier.fillMaxWidth().padding(16.dp)) {
            Text("Title Example", fontWeight = FontWeight.ExtraBold, fontSize = 16.sp)
            HorizontalDivider(Modifier.fillMaxWidth(), thickness = 2.dp, color = Color.Black)
            Spacer(Modifier.size(8.dp))
            Text("adsjkladskjldasjkldasjklasdjklasdjklasdklj sadjklasdkjldasjkl jadskldkljasd", fontWeight = FontWeight.Normal, fontSize = 14.sp)
        }
    }
}