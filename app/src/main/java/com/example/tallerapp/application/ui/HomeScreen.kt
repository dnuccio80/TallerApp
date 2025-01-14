package com.example.tallerapp.application.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.tallerapp.ui.theme.BackgroundColor
import com.example.tallerapp.ui.theme.ButtonColor
import com.example.tallerapp.ui.theme.CardBackgroundColor
import com.example.tallerapp.ui.theme.SecondBackgroundColor
import com.example.tallerapp.ui.theme.SecondaryTextColor
import com.example.tallerapp.ui.theme.TextColor

@Composable
fun HomeScreen() {
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
        HomeFabItem(Modifier.align(Alignment.BottomEnd))
    }
}

@Composable
fun HomeFabItem(modifier: Modifier) {

    var expandedValue by rememberSaveable { mutableStateOf(false) }

    FloatingActionButton(
        onClick = { expandedValue = true },
        modifier = modifier.padding(vertical = 128.dp, horizontal = 16.dp),
    ) {
        Icon(Icons.Filled.Add, contentDescription = "add button")
        DropdownMenuHome(expandedValue) { expandedValue = false }
    }
}

@Composable
fun DropdownMenuHome(expandedValue: Boolean, onDismiss: () -> Unit) {
    DropdownMenu(
        expanded = expandedValue,
        onDismissRequest = { onDismiss() },
        offset = DpOffset((-32).dp, (-2).dp),
        modifier = Modifier.background(ButtonColor)
    ) {
        DropdownMenuItem(
            text = { Text("Add work done", color = Color.White) },
            onClick = {}
        )
        DropdownMenuItem(
            text = { Text("Add payment received", color = Color.White) },
            onClick = {}
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