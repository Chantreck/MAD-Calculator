package com.tsu.calculator.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier

val ButtonModifier = Modifier
    .drawColoredShadow(White, offsetX = ShadowOffset, offsetY = ShadowOffset)
    .drawColoredShadow(BlueShadow, alpha = ShadowAlpha, offsetX = ShadowOffset, offsetY = ShadowOffset)
    .fillMaxSize()

val AccentButtonModifier = Modifier
    .drawColoredShadow(White, offsetX = ShadowNegativeOffset, offsetY = ShadowNegativeOffset)
    .drawColoredShadow(BlueShadow, alpha = ShadowAlpha, offsetX = ShadowOffset, offsetY = ShadowOffset)
    .fillMaxSize()