package com.example.tugasindividulayout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Main() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
            Image(
                painter = painterResource(R.drawable.gojo),
                modifier = Modifier.size(150.dp),
                contentDescription = "Gojo"
            )
            Column(modifier = Modifier .padding(start = 8.dp)) {
                Text(
                    text = "Title",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Sub-Title",
                    fontSize = 20.sp,
                    modifier = Modifier .padding(top = 16.dp)
                )
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier .padding(top = 8.dp)) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Star",
                        modifier = Modifier .size(50.dp),
                        tint = Color(0xFFFFD700)
                    )
                    Text(
                        text = "9.23",
                        fontSize = 20.sp,
                        modifier = Modifier .padding(start = 8.dp)
                    )
                }
            }
        }
        Text(
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
            fontSize = 19.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier .padding(start = 30.dp, end = 30.dp, top = 16.dp)
        )
        Row(
            modifier = Modifier .fillMaxWidth() .padding(top = 40.dp), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3D6080)),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(2.dp, Color.Black)
            ) { Text(text = "Like", fontSize = 20.sp) }
            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC0392B)),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(2.dp, Color.Black)
            ) { Text(text = "Dislike", fontSize = 20.sp) }
            Button(onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2D6A2D)),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(2.dp, Color.Black)
            ) { Text(text = "Share", fontSize = 20.sp) }
        }
    }
}