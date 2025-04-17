package com.example.clickbehavior

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clickbehavior.ui.theme.ClickBehaviorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClickBehaviorTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                    ) {
                        LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    mainScreen()
}

@Composable
fun mainScreen(modifier: Modifier = Modifier){

    Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(R.string.Title),
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color(0xFFe0dc82))
                .fillMaxWidth()
                .padding(top = 60.dp, bottom = 5.dp)
        )
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val step = remember { mutableStateOf(1) }
        Button(
            onClick = {step.value = (step.value % 4) + 1},
            shape = RoundedCornerShape(60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFd5ebca)
            )
        ) {
            var imageResource = when(step.value) {

                1 -> R.drawable.lemon_tree
                2 -> R.drawable.lemon_squeeze
                3 -> R.drawable.lemon_drink
                else -> R.drawable.lemon_restart
            }
            Image(
                painter = painterResource(imageResource),
                contentDescription = null
            )
        }
        var textCaption = when(step.value) {

            1 -> R.string.treeText
            2 -> R.string.lemonText
            3 -> R.string.lemonadeText
            else -> R.string.emptyGlassText
        }
        Text(
            text = stringResource(textCaption),
            fontSize = 20.sp,
            modifier = Modifier
                .padding(top = 25.dp)

        )
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClickBehaviorTheme {
        Surface(modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LemonadeApp()
        }
    }
}