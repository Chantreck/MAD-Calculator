package com.tsu.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.LiveData
import com.tsu.calculator.ui.theme.*
import timber.log.Timber

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        setContent {
            Box(
                modifier = Modifier
                    .background(Background)
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Column(modifier = Modifier.padding(horizontal = DefaultPadding)) {
                    SetHeader()
                    SetButtons()
                }
            }
        }
    }

    @Composable
    private fun SetHeader() {
        Text(
            text = stringResource(id = R.string.app_name),
            style = TitleTextStyle,
        )

        Spacer(modifier = Modifier.height(DefaultPadding))

        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(R.drawable.result_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
            )
            Box {
                SetTextInHeader(text = stringResource(id = R.string.hint), color = NumbersBackground)
                ShowResult(viewModel.display)
            }
        }
    }

    @Composable
    private fun ShowResult(resultData: LiveData<String>) {
        val result by resultData.observeAsState(initial = "0")
        SetTextInHeader(text = result, color = Color.Black)
    }

    @Composable
    private fun SetTextInHeader(text: String, color: Color) {
        Text(
            text = text,
            color = color,
            style = ValueTextStyle
        )
    }

    @Composable
    private fun SetButtons() {
        Spacer(modifier = Modifier.height(DefaultPadding))

        val rows = listOf(
            listOf(Buttons.CLEAR, Buttons.PLUS_MINUS, Buttons.PERCENT, Buttons.DIVIDE),
            listOf(Buttons.SEVEN, Buttons.EIGHT, Buttons.NINE, Buttons.MULTIPLY),
            listOf(Buttons.FOUR, Buttons.FIVE, Buttons.SIX, Buttons.MINUS),
            listOf(Buttons.ONE, Buttons.TWO, Buttons.THREE, Buttons.PLUS),
            listOf(Buttons.ZERO, Buttons.COMMA, Buttons.EQUAL)
        )
        for (row in rows) {
            SetButtonRow(buttons = row)
        }

        Spacer(modifier = Modifier.height(LastRowPadding))
    }

    @Composable
    private fun SetButtonRow(buttons: List<Buttons>) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            if (buttons.size == 3) {
                Box(modifier = Modifier
                    .weight(WideButtonWeight)
                    .aspectRatio(WideButtonWeight)) {
                    SetButton(buttons[0])
                }
            } else {
                Box(modifier = Modifier
                    .weight(ButtonWeight)
                    .aspectRatio(ButtonWeight)) {
                    SetButton(buttons[0])
                }
                SpacerBetweenButtons()

                Box(modifier = Modifier
                    .weight(ButtonWeight)
                    .aspectRatio(ButtonWeight)) {
                    SetButton(buttons[1])
                }
            }
            SpacerBetweenButtons()

            Box(modifier = Modifier
                .weight(ButtonWeight)
                .aspectRatio(ButtonWeight)) {
                SetButton(buttons[buttons.size - 2])
            }
            SpacerBetweenButtons()

            Box(modifier = Modifier
                .weight(ButtonWeight)
                .aspectRatio(ButtonWeight)) {
                SetAccentButton(buttons[buttons.size - 1])
            }
        }
        Spacer(modifier = Modifier.height(SmallerPadding))
    }

    @Composable
    private fun SpacerBetweenButtons() {
        Spacer(modifier = Modifier.width(SmallerPadding))
    }

    @Composable
    private fun SetButton(action: Buttons) {
        Button(
            onClick = {
                viewModel.action(action)
            },
            colors = buttonColors(backgroundColor = Background),
            shape = ButtonShape,
            elevation = null,
            modifier = ButtonModifier
        ) {
            Text(
                text = action.label,
                style = ButtonTextStyle
            )
        }
    }

    @Composable
    private fun SetAccentButton(action: Buttons) {
        Button(
            onClick = {
                viewModel.action(action)
            },
            colors = buttonColors(backgroundColor = AccentBlue),
            shape = ButtonShape,
            elevation = null,
            modifier = AccentButtonModifier
        ) {
            Text(
                text = action.label,
                style = AccentButtonTextStyle
            )
        }
    }
}