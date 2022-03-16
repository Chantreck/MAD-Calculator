package com.tsu.calculator

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tsu.calculator.ui.theme.*

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UI()
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
                Box(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
                    .aspectRatio(1f)) {
                    SetButton("AC") {

                    }
                }
                Box(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
                    .aspectRatio(1f)) {
                    SetButton("+/-") {

                    }
                }
                Box(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
                    .aspectRatio(1f)) {
                    SetButton("%") {

                    }
                }
                Box(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
                    .aspectRatio(1f)) {
                    SetAccentButton("÷") {

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

                    }
                }
                Box(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
                    .aspectRatio(1f)) {
                    SetButton("8") {

                    }
                }
                Box(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
                    .aspectRatio(1f)) {
                    SetButton("9") {

                    }
                }
                Box(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
                    .aspectRatio(1f)) {
                    SetAccentButton("X") {

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

                    }
                }
                Box(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
                    .aspectRatio(1f)) {
                    SetButton("5") {

                    }
                }
                Box(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
                    .aspectRatio(1f)) {
                    SetButton("6") {

                    }
                }
                Box(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
                    .aspectRatio(1f)) {
                    SetAccentButton("-") {

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

                    }
                }
                Box(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
                    .aspectRatio(1f)) {
                    SetButton("2") {

                    }
                }
                Box(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
                    .aspectRatio(1f)) {
                    SetButton("3") {

                    }
                }
                Box(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
                    .aspectRatio(1f)) {
                    SetAccentButton("+") {

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

                    }
                }
                Box(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
                    .aspectRatio(1f)) {
                    SetAccentButton("=") {

                    }
                }
            }
        }
    }
}

@Composable
fun SetButton(text: String, action: () -> Unit) {
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
                fontSize = 29.sp,
                textAlign = TextAlign.Center
            ),
        )
    }
}

@Composable
fun SetAccentButton(text: String, action: () -> Unit) {
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
                fontSize = 29.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}

//нашел где-то в интернете :)
fun Modifier.drawColoredShadow(
    color: Color,
    alpha: Float = 1f,
    borderRadius: Dp = 0.dp,
    shadowRadius: Dp = 10.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp
) = this.drawBehind {
    val transparentColor = android.graphics.Color.toArgb(color.copy(alpha = 0.0f).value.toLong())
    val shadowColor = android.graphics.Color.toArgb(color.copy(alpha = alpha).value.toLong())
    this.drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
            shadowRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        it.drawRoundRect(
            0f,
            0f,
            this.size.width,
            this.size.height,
            borderRadius.toPx(),
            borderRadius.toPx(),
            paint
        )
    }
}