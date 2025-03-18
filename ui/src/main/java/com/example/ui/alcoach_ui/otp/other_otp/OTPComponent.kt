package com.example.ui.alcoach_ui.otp.other_otp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.alcoach_ui.otp.primary
import com.example.ui.alcoach_ui.otp.stroke
import com.example.ui.alcoach_ui.otp.textColor

@Composable
fun OtpComponent(
    codeLength: Int = 6,
    modifier: Modifier = Modifier,
    onUpdateOtpValuesByIndex: (Int, String) -> Unit,
    otpValues: List<String> = List(codeLength) { "" },
) {
    val focusRequesters = List(codeLength) { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        otpValues.forEachIndexed { index, value ->

            OutlinedTextField(
                modifier = Modifier
                    .weight(1f)
                    .focusRequester(focusRequesters[index])
                    .onKeyEvent { keyEvent: KeyEvent ->
                        if (keyEvent.key == Key.Backspace) {
                            if (otpValues[index].isEmpty() && index > 0) {
                                onUpdateOtpValuesByIndex(index, "")
                                focusRequesters[index - 1].requestFocus()
                            } else {
                                onUpdateOtpValuesByIndex(index, "")
                            }
                            true
                        } else {
                            false
                        }
                    },
                value = value,
                onValueChange = { newValue ->
                    if (newValue.length == codeLength) {
                        for (i in otpValues.indices) {
                            onUpdateOtpValuesByIndex(
                                i,
                                if (i < newValue.length && newValue[i].isDigit()) newValue[i].toString() else ""
                            )
                        }

                        keyboardController?.hide()
//                        onOtpInputComplete() // you should validate the otp values first for, if it is only digits or isNotEmpty
                    } else if (newValue.length <= 1) {
                        onUpdateOtpValuesByIndex(index, newValue)
                        if (newValue.isNotEmpty()) {
                            if (index < codeLength - 1) {
                                focusRequesters[index + 1].requestFocus()
                            } else {
                                keyboardController?.hide()
//                                focusManager.clearFocus()
//                                onOtpInputComplete()
                            }
                        }
                    } else {
                        if (index < codeLength - 1) focusRequesters[index + 1].requestFocus()
                    }

                }
            )


        }
    }
    LaunchedEffect(Unit) {
        focusRequesters.first().requestFocus()
    }

}


@Preview
@Composable
private fun Preview() {
    OtpComponent(codeLength = 6, onUpdateOtpValuesByIndex = { _, _ -> })
}