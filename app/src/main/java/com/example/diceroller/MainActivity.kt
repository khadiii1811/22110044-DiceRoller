package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var diceValue by remember { mutableIntStateOf(1) }

    val diceImages = listOf(
        R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
        R.drawable.dice4, R.drawable.dice5, R.drawable.dice6
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "🎲 Dice Roller 🎲",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(id = diceImages[diceValue - 1]),
            contentDescription = diceValue.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { diceValue = (1..6).random() },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = stringResource(R.string.roll), fontSize = 18.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}
