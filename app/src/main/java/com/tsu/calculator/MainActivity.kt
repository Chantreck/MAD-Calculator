package com.tsu.calculator

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tsu.calculator.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UI()
        }
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun UI() {
    Column(
        modifier = Modifier
            .background(Background)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Text(
            text = "Calculator",
            fontSize = 28.sp,
            fontFamily = museo,
            modifier = Modifier.padding(top = 24.dp, start = 24.dp, end = 24.dp)
        )

        Box(modifier = Modifier.padding(top = 24.dp, start = 24.dp, end = 24.dp)) {
            Image(
                painter = painterResource(R.drawable.result_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
            )
            Text(
                text = "8888888888",
                color = NumbersBackground,
                fontFamily = digitalNumbers,
                fontSize = 37.sp,
                modifier = Modifier.padding(top = 23.dp, start = 22.dp)
            )
            Text(
                text = "0123456789",
                fontFamily = digitalNumbers,
                fontSize = 37.sp,
                modifier = Modifier.padding(top = 23.dp, start = 22.dp)
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
        ) {
            TextButton(
                onClick = {},
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, fill = true)
                    .aspectRatio(1f)
            ) {
                Text(
                    text = "AC",
                    style = buttonTextStyle
                )
            }

            TextButton(
                onClick = {},
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, fill = true)
                    .aspectRatio(1f)
            ) {
                Text(
                    text = "+/-",
                    style = buttonTextStyle
                )
            }

            TextButton(
                onClick = {},
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, fill = true)
                    .aspectRatio(1f)
            ) {
                Text(
                    text = "%",
                    style = buttonTextStyle
                )
            }

            Button(
                onClick = {},
                colors = buttonColors(backgroundColor = AccentBlue),
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, fill = true)
                    .aspectRatio(1f)
            ) {
                Text(
                    text = "÷",
                    style = accentButtonTextStyle
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
        ) {
            TextButton(
                onClick = {},
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, fill = true)
                    .aspectRatio(1f)
            ) {
                Text(
                    text = "7",
                    style = buttonTextStyle
                )
            }

            TextButton(
                onClick = {},
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, fill = true)
                    .aspectRatio(1f)
            ) {
                Text(
                    text = "8",
                    style = buttonTextStyle
                )
            }

            TextButton(
                onClick = {},
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, fill = true)
                    .aspectRatio(1f)
            ) {
                Text(
                    text = "9",
                    style = buttonTextStyle
                )
            }

            Button(
                onClick = {},
                colors = buttonColors(backgroundColor = AccentBlue),
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, fill = true)
                    .aspectRatio(1f)
            ) {
                Text(
                    text = "X",
                    style = accentButtonTextStyle
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
        ) {
            TextButton(
                onClick = {},
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, fill = true)
                    .aspectRatio(1f)
            ) {
                Text(
                    text = "4",
                    style = buttonTextStyle
                )
            }
            TextButton(
                onClick = {},
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, fill = true)
                    .aspectRatio(1f)
            ) {
                Text(
                    text = "5",
                    style = buttonTextStyle
                )
            }
            TextButton(
                onClick = {},
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, fill = true)
                    .aspectRatio(1f)
            ) {
                Text(
                    text = "6",
                    style = buttonTextStyle
                )
            }
            Button(
                onClick = {},
                colors = buttonColors(backgroundColor = AccentBlue),
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, fill = true)
                    .aspectRatio(1f)
            ) {
                Text(
                    text = "–",
                    style = accentButtonTextStyle
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
        ) {
            TextButton(
                onClick = {},
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, fill = true)
                    .aspectRatio(1f)
            ) {
                Text(
                    text = "1",
                    style = buttonTextStyle
                )
            }
            TextButton(
                onClick = {},
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, fill = true)
                    .aspectRatio(1f)
            ) {
                Text(
                    text = "2",
                    style = buttonTextStyle
                )
            }
            TextButton(
                onClick = {},
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, fill = true)
                    .aspectRatio(1f)
            ) {
                Text(
                    text = "3",
                    style = buttonTextStyle
                )
            }
            Button(
                onClick = {},
                colors = buttonColors(backgroundColor = AccentBlue),
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, fill = true)
                    .aspectRatio(1f)
            ) {
                Text(
                    text = "+",
                    style = accentButtonTextStyle
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 64.dp)
                .fillMaxWidth()
        ) {
            TextButton(
                onClick = {},
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(2f, fill = true)
                    .aspectRatio(11f / 5)
            ) {
                Text(
                    text = "0",
                    style = buttonTextStyle
                )
            }
            TextButton(
                onClick = {},
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, fill = true)
                    .aspectRatio(1f)
            ) {
                Text(
                    text = ",",
                    style = buttonTextStyle
                )
            }
            Button(
                onClick = {},
                colors = buttonColors(backgroundColor = AccentBlue),
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f, fill = true)
                    .aspectRatio(1f)
            ) {
                Text(
                    text = "=",
                    style = accentButtonTextStyle
                )
            }
        }
    }
}

private val buttonTextStyle = TextStyle(
    fontFamily = montserrat,
    color = AccentBlue,
    fontSize = 29.sp,
    textAlign = TextAlign.Center
)

private val accentButtonTextStyle = TextStyle(
    fontFamily = montserrat,
    color = Color.White,
    fontSize = 29.sp,
    textAlign = TextAlign.Center
)