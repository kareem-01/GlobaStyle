package com.example.ui.alcoach_ui.otp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OtpComponent(
    codeLength: Int = 6,
    modifier: Modifier = Modifier,
) {
    val otpValue = remember { mutableStateOf("") }
//    val focusRequesters = List(codeLength) { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current

    BasicTextField(
        value = otpValue.value,
        onValueChange = {
            if (it.length <= codeLength) {
                otpValue.value = it
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        decorationBox = {
            Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                repeat(codeLength) { index ->
                    val otpChar = when {
                        index >= otpValue.value.length -> ""
                        else -> otpValue.value[index].toString()
                    }
                    val isFocused = index == otpValue.value.length
                    Text(
                        modifier = Modifier
                            .width(40.dp)
                            .border(
                                if (isFocused) 2.dp else
                                    1.dp,
                                if (isFocused) primary else stroke,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(2.dp),
                        text = otpChar,
                        color = textColor,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    )


//    LaunchedEffect(true) {
//        focusRequesters.first().requestFocus()
//    }
}


@Preview
@Composable
private fun Preview() {
    OtpComponent()
}