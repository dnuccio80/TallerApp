package com.example.tallerapp.application.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tallerapp.ui.theme.BackgroundColor
import com.example.tallerapp.ui.theme.ButtonColor
import com.example.tallerapp.ui.theme.CardBackgroundColor
import com.example.tallerapp.ui.theme.SecondBackgroundColor
import com.example.tallerapp.ui.theme.SecondaryTextColor
import com.example.tallerapp.ui.theme.TextColor

@Composable
fun IndexScreen() {
    Scaffold(
        Modifier
            .fillMaxSize(),
        bottomBar = { BottomAppBarItem() }
    ) { paddingValues ->
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
                    .fillMaxWidth()
                    .padding(vertical = 52.dp, horizontal = 16.dp)
            ) {
                BalanceCardItem()
                Spacer(Modifier.size(16.dp))
                WorkDoneCardItem()
                Spacer(Modifier.size(16.dp))
                PaymentReceivedCardItem()
            }
        }

    }
}

@Composable
fun BottomAppBarItem() {

    var indexSelected by rememberSaveable { mutableIntStateOf(0) }

    NavigationBar(
        Modifier.fillMaxWidth(),
        containerColor = CardBackgroundColor,
        tonalElevation = 16.dp,
    ) {
        NavigationBarItem(
            selected = indexSelected == 0,
            onClick = { indexSelected = 0},
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home button") },
            label = { Text("Home") }

        )
        NavigationBarItem(
            selected = indexSelected == 1,
            onClick = { indexSelected = 1},
            icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "work list button") },
            label = { Text("Work List") }
        )
    }
}


@Composable
fun BalanceCardItem() {
    Card(
        Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardBackgroundColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Balance", color = TextColor, fontSize = 32.sp, fontWeight = FontWeight.ExtraBold)
            Text("$50.000", color = TextColor, fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)
            Spacer(Modifier.size(8.dp))
            Text(
                "Trabajos realizados: $150.000",
                color = SecondaryTextColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                "Pagos recibidos: $100.000",
                color = SecondaryTextColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.size(8.dp))
            Button(
                modifier = Modifier.align(Alignment.End),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ButtonColor,
                ),
                shape = RoundedCornerShape(8.dp),
                onClick = { }
            ) {
                Text("Clear All")
            }
        }
    }
}

@Composable
fun WorkDoneCardItem() {
    Card(
        Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardBackgroundColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                "Trabajos Realizados",
                color = TextColor,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(Modifier.size(16.dp))

            HorizontalDivider(Modifier.fillMaxWidth(), color = SecondaryTextColor, thickness = 2.dp)
            Text(
                "Lunes",
                color = SecondaryTextColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Row(Modifier.fillMaxWidth()) {
                Text(
                    "Tubos torneado",
                    color = SecondaryTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "x12",
                    color = SecondaryTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "$52.800",
                    color = SecondaryTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.weight(1f)
                )
            }
            Row(Modifier.fillMaxWidth()) {
                Text(
                    "Tubos agujereado",
                    color = SecondaryTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "x12",
                    color = SecondaryTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "$7.200",
                    color = SecondaryTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(Modifier.size(16.dp))
            HorizontalDivider(Modifier.fillMaxWidth(), color = SecondaryTextColor, thickness = 2.dp)
            Text(
                "Martes",
                color = SecondaryTextColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Row(Modifier.fillMaxWidth()) {
                Text(
                    "Tubos torneado",
                    color = SecondaryTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "x12",
                    color = SecondaryTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "$52.800",
                    color = SecondaryTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.weight(1f)
                )
            }
            Row(Modifier.fillMaxWidth()) {
                Text(
                    "Tubos agujereado",
                    color = SecondaryTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "x12",
                    color = SecondaryTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "$7.200",
                    color = SecondaryTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(Modifier.size(16.dp))
            HorizontalDivider(Modifier.fillMaxWidth(), color = SecondaryTextColor, thickness = 2.dp)
            Text(
                "Miercoles",
                color = SecondaryTextColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Row(Modifier.fillMaxWidth()) {
                Text(
                    "Tubos torneado",
                    color = SecondaryTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "x12",
                    color = SecondaryTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "$52.800",
                    color = SecondaryTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.weight(1f)
                )
            }
            Row(Modifier.fillMaxWidth()) {
                Text(
                    "Tubos agujereado",
                    color = SecondaryTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "x12",
                    color = SecondaryTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "$7.200",
                    color = SecondaryTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.weight(1f)
                )
            }

        }

    }
}


@Composable
fun PaymentReceivedCardItem() {
    Card(
        Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = CardBackgroundColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                "Pagos Recibidos",
                color = TextColor,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(Modifier.size(16.dp))
            Text(
                "Efectivo: $56.000",
                color = SecondaryTextColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                "Cheques: $156.000",
                color = SecondaryTextColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold
            )

        }
    }
}