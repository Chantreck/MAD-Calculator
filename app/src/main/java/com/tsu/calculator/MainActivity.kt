package com.tsu.calculator

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import com.tsu.calculator.ui.theme.*

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrawUI()
        }
    }

    @Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
    @Composable
    private fun DrawUI() {
        Column(
            modifier = Modifier
                .background(Background)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom,
        ) {
            DrawHeader()
            DrawButtons()
        }
    }

    @Composable
    private fun DrawHeader() {
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
                text = "88888888888",
                color = NumbersBackground,
                fontFamily = digitalNumbers,
                fontSize = 37.sp,
                modifier = Modifier.padding(top = 23.dp, start = 22.dp)
            )

            ShowResult(viewModel.display)
        }
    }

    @Composable
    private fun ShowResult(resultData: LiveData<String>) {
        val result by resultData.observeAsState(initial = "0")

        Text(
            text = result,
            textAlign = TextAlign.End,
            fontFamily = digitalNumbers,
            fontSize = 37.sp,
            modifier = Modifier.padding(top = 23.dp, start = 22.dp)
        )
    }

    @Composable
    private fun DrawButtons() {
        Row(
            modifier = Modifier
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
        ) {
            Box(modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
                .aspectRatio(1f)) {
                SetButton("C") {
                    viewModel.clear()
                }
            }
            Box(modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
                .aspectRatio(1f)) {
                SetButton("+/-") {
                    viewModel.changeSign()
                }
            }
            Box(modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
                .aspectRatio(1f)) {
                SetButton("%") {
                    viewModel.setOperation("percent")
                }
            }
            Box(modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
                .aspectRatio(1f)) {
                SetAccentButton("÷") {
                    viewModel.setOperation("divide")
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
        ) {
            Box(modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
                .aspectRatio(1f)) {
                SetButton("7") {
                    viewModel.addNumber("7")
                }
            }
            Box(modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
                .aspectRatio(1f)) {
                SetButton("8") {
                    viewModel.addNumber("8")
                }
            }
            Box(modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
                .aspectRatio(1f)) {
                SetButton("9") {
                    viewModel.addNumber("9")
                }
            }
            Box(modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
                .aspectRatio(1f)) {
                SetAccentButton("X") {
                    viewModel.setOperation("multiply")
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
        ) {
            Box(modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
                .aspectRatio(1f)) {
                SetButton("4") {
                    viewModel.addNumber("4")
                }
            }
            Box(modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
                .aspectRatio(1f)) {
                SetButton("5") {
                    viewModel.addNumber("5")
                }
            }
            Box(modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
                .aspectRatio(1f)) {
                SetButton("6") {
                    viewModel.addNumber("6")
                }
            }
            Box(modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
                .aspectRatio(1f)) {
                SetAccentButton("-") {
                    viewModel.setOperation("subtract")
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
        ) {
            Box(modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
                .aspectRatio(1f)) {
                SetButton("1") {
                    viewModel.addNumber("1")
                }
            }
            Box(modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
                .aspectRatio(1f)) {
                SetButton("2") {
                    viewModel.addNumber("2")
                }
            }
            Box(modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
                .aspectRatio(1f)) {
                SetButton("3") {
                    viewModel.addNumber("3")
                }
            }
            Box(modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
                .aspectRatio(1f)) {
                SetAccentButton("+") {
                    viewModel.setOperation("add")
                }
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 64.dp)
                .fillMaxWidth()
        ) {
            Box(modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(2f)
                .aspectRatio(11f / 5)) {
                SetButton("0") {
                    viewModel.addNumber("0")
                }
            }
            Box(modifier = Modifier
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color.Yellow,
                            Color.Transparent
                        )
                    )
                )
                .padding(horizontal = 8.dp)
                .weight(1f)
                .aspectRatio(1f)) {
                SetButton(",") {
                    viewModel.addNumber(".")
                }
            }
            Box(modifier = Modifier
                .padding(horizontal = 8.dp)
                .weight(1f)
                .aspectRatio(1f)) {
                SetAccentButton("=") {
                    viewModel.getResult()
                }
            }
        }
    }

    @Composable
    private fun SetButton(text: String, action: () -> Unit) {
        Button(
            onClick = action,
            colors = buttonColors(backgroundColor = Background, contentColor = AccentBlue),
            shape = RoundedCornerShape(25),
            elevation = null,
            modifier = Modifier
                .drawColoredShadow(Color.White, offsetX = (-5).dp, offsetY = (-5).dp)
                .drawColoredShadow(BlueShadow, alpha = 0.1f, offsetX = 5.dp, offsetY = 5.dp)
                .fillMaxSize()
        ) {
            Text(
                text = text,
                style = TextStyle(
                    fontFamily = montserrat,
                    color = AccentBlue,
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center
                ),
            )
        }
    }

    @Composable
    private fun SetAccentButton(text: String, action: () -> Unit) {
        Button(
            onClick = action,
            colors = buttonColors(backgroundColor = AccentBlue),
            shape = RoundedCornerShape(25),
            elevation = null,
            modifier = Modifier
                .drawColoredShadow(Color.White, offsetX = (-5).dp, offsetY = (-5).dp)
                .drawColoredShadow(BlueShadow, alpha = 0.1f, offsetX = 5.dp, offsetY = 5.dp)
                .fillMaxSize()
        ) {
            Text(
                text = text,
                style = TextStyle(
                    fontFamily = montserrat,
                    color = Color.White,
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}