package com.example.ui.alcoach_ui.otp.github_otp

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.ui.alcoach_ui.otp.BorderDark
import com.example.ui.alcoach_ui.otp.BorderLight
import kotlinx.coroutines.delay


/**
 * A composable function for creating an OTP input field.
 * This OTP input field allows for the entry of a One Time Password (OTP) with a configurable number of characters.
 *
 * @sample otpExample
 */
@Composable
fun OtpInputField(
    modifier: Modifier = Modifier,
    otpText: String,
    otpLength: Int = 6,
    shouldShowCursor: Boolean = true,
    shouldCursorBlink: Boolean = true,
    onOtpModified: (String, Boolean) -> Unit,
    focusedColor: Color,
    unfocusedColor: Color
) {

    val context = LocalContext.current
    LaunchedEffect(Unit) {
        if (otpText.length > otpLength) {
            Toast.makeText(
                context,
                "OTP should be $otpLength digits",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    BasicTextField(
        modifier = modifier,
        value = otpText,
        onValueChange = { newValue ->
            if (newValue.length <= otpLength) {
                onOtpModified.invoke(newValue, newValue.length == otpLength)
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = ImeAction.Done
        ),
        decorationBox = {

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                repeat(otpLength) { index ->

                    CharacterContainer(
                        index = index,
                        text = otpText,
                        shouldShowCursor = shouldShowCursor,
                        shouldCursorBlink = shouldCursorBlink,
                        focusedColor = focusedColor,
                        unfocusedColor = unfocusedColor
                    )
                }
            }

        }
    )
}


@Composable
private fun CharacterContainer(
    index: Int,
    text: String,
    shouldShowCursor: Boolean,
    shouldCursorBlink: Boolean,
    focusedColor: Color,
    unfocusedColor: Color
) {
    val isFocused: Boolean = text.length == index

    val character = when {
        index < text.length -> text[index].toString()
        else -> ""
    }

    val cursorVisible = remember { mutableStateOf(shouldShowCursor) }

    LaunchedEffect(key1 = isFocused) {
        if (isFocused && shouldShowCursor && shouldCursorBlink) {
            while (true) {
                delay(800)
                cursorVisible.value = !cursorVisible.value
            }
        }
    }

    Box(contentAlignment = Alignment.Center) {
        Text(
            modifier = Modifier
                .width(36.dp)
                .border(
                    width = when {
                        isFocused -> 2.dp
                        else -> 1.dp
                    },
                    color = when {
                        isFocused -> focusedColor
                        else -> unfocusedColor
                    },
                    shape = RoundedCornerShape(6.dp)
                )
                .padding(2.dp),
            text = character,
            style = MaterialTheme.typography.headlineLarge,
            color = if (isFocused) focusedColor else unfocusedColor,
            textAlign = TextAlign.Center
        )
        AnimatedVisibility(isFocused && cursorVisible.value) {
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .height(24.dp)
                    .width(2.dp)
                    .background(Color.Black)
            )
        }
    }
}

@Preview
@Composable
private fun OtpInputFieldPreview() {
    var otpText by remember { mutableStateOf("") }
    OtpInputField(
        otpText = otpText,
        onOtpModified = { newText, isFilled ->
            if (isFilled)
                otpText = newText
        },
        focusedColor = BorderDark,
        unfocusedColor = BorderLight
    )
}


@Composable
internal fun otpExample() {
    val viewModel = object : ViewModel() {
        var otpText by remember { mutableStateOf("") }
    }
    val focusRequester = remember { FocusRequester() }
    OtpInputField(
        modifier = Modifier.focusRequester(focusRequester),
        otpText = viewModel.otpText,
        otpLength = 6,
        onOtpModified = { otp: String, isComplete: Boolean ->
            viewModel.otpText = otp
            if (isComplete) {
                // Handle the OTP
            }
        },
        focusedColor = BorderDark,
        unfocusedColor = BorderLight,
        shouldShowCursor = false,
        shouldCursorBlink = false
    )

}