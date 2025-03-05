package com.maitreyasave.clickcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maitreyasave.clickcounter.ui.theme.ClickCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClickCounterTheme {
                // A surface container using the 'background' color from the theme
                var valueCounter by remember {
                    mutableIntStateOf(0)
                }
                val context = LocalContext.current

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(
                        onValueIncreaseClick = {
                            valueCounter += 1
                        },
                        onValueDecreaseClick = {
                            valueCounter -= 1
                        },
                        onResetClick = {
                            valueCounter = 0
                        },
                        cnt = valueCounter.toString()
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    onValueIncreaseClick: () -> Unit,
    onValueDecreaseClick: () -> Unit,
    onResetClick: () -> Unit,
    cnt: String
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "Click to count!!",
                fontSize = 30.sp
            )
        }
        item {
            LazyRow {
                item {
                    Button(
                        modifier = Modifier
                            .width(160.dp)
                            .height(120.dp)
                            .padding(10.dp),
                        onClick = onValueDecreaseClick
                    ) {
                        Text(text = "-", fontSize = 60.sp)
                    }
                }
                item {
                    Button(
                        modifier = Modifier
                            .width(160.dp)
                            .height(120.dp)
                            .padding(10.dp),
                        onClick = onValueIncreaseClick
                    ) {
                        Text(text = "+", fontSize = 60.sp)
                    }

                }
            }

        }
        item {
            Button(
                onClick = onResetClick
            ) {
                Text(text = "Reset")
            }
        }
        item {
            Text(
                modifier = Modifier.padding(30.dp),
                fontSize = 40.sp,
                text = "Count: $cnt"
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClickCounterTheme {
        Greeting(
            onValueIncreaseClick = {},
            onValueDecreaseClick = {},
            onResetClick = {},
            cnt = "1"
        )
    }
}