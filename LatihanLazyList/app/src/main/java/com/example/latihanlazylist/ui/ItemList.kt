package com.example.latihanlazylist.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.latihanlazylist.model.Item
import com.example.latihanlazylist.viewmodel.ItemViewModel

@Composable
fun ItemListScreen(viewModel: ItemViewModel) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(viewModel.items) { index, item ->
            ItemCard(
                item = item,
                isEven = index % 2 == 0,
                onSwitchChanged = { isActive ->
                    viewModel.updateSwitchState(index, isActive)
                    if (isActive) {
                        Toast.makeText(context, "Switch hidup pada item ${item.id}", Toast.LENGTH_SHORT).show()
                    }
                },
                onButtonClicked = {
                    Toast.makeText(context, "Tombol telah ditekan untuk tombol ${item.id}", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}

@Composable
fun ItemCard(
    item: Item,
    isEven: Boolean,
    onSwitchChanged: (Boolean) -> Unit,
    onButtonClicked: () -> Unit
) {
    val backgroundColor = if (isEven) Color.White else Color(0xFFD4EDDA)

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.size(60.dp),
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = item.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(text = item.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = item.description, fontSize = 12.sp)
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Switch(
                    checked = item.isActive,
                    onCheckedChange = onSwitchChanged
                )
                Spacer(modifier = Modifier.height(4.dp))
                Button(
                    onClick = onButtonClicked,
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.height(40.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp)
                ) {
                    Text(text = "Aksi", fontSize = 11.sp)
                }
            }
        }
    }
}