package com.tsu.calculator.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

val TitleTextStyle = TextStyle(
    fontFamily = Museo,
    fontSize = DefaultTextSize,
)

val ValueTextStyle = TextStyle(
    fontFamily = DigitalNumbers,
    fontSize = ValueTextSize,
    textAlign = TextAlign.End,
)

val ButtonTextStyle = TextStyle(
    fontFamily = Montserrat,
    fontSize = DefaultTextSize,
    color = AccentBlue,
    textAlign = TextAlign.Center
)

val AccentButtonTextStyle = TextStyle(
    fontFamily = Montserrat,
    fontSize = DefaultTextSize,
    color = White,
    textAlign = TextAlign.Center
)