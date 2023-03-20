@file:OptIn(ExperimentalTextApi::class)

package kr.hs.dgsw.bamboo.bamboo_android.core.component.textfield

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.hs.dgsw.bamboo.bamboo_android.core.ImageIcon
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.Body1
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.BorderGray
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.MainColor
import kr.hs.dgsw.bamboo.bamboo_android.core.theme.TextGray

sealed interface InputType {
    object Default : InputType
    object Focus : InputType
}

@Composable
fun MTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.body1,
    textColor: Color = Color.Black,
    hint: String = "",
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = true,
    maxLines: Int = 1,
) {
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))
    val focusRequester by remember { mutableStateOf(FocusRequester()) }

    var isFocused by remember { mutableStateOf(false) }

    var currentInputType: InputType by remember { mutableStateOf(if (isFocused) InputType.Focus else InputType.Default) }

    val cursorColor = when (currentInputType) {
        is InputType.Focus -> MainColor
        is InputType.Default -> Color.Gray
    }

    currentInputType = if (isFocused) InputType.Focus else InputType.Default

    Column {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier
                .background(
                    color = Color.Transparent,
                    shape = MaterialTheme.shapes.small
                )
                .focusRequester(focusRequester = focusRequester)
                .onFocusChanged { isFocused = it.isFocused },
            enabled = enabled,
            textStyle = mergedTextStyle,
            cursorBrush = SolidColor(cursorColor),
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            decorationBox = @Composable { innerTextField ->
                InputDecoration(
                    value = value,
                    inputType = currentInputType,
                    hint = hint,
                    innerTextField = innerTextField,
                    trailingIcon = trailingIcon,
                )
            }
        )
    }
}

@Composable
private fun InputDecoration(
    value: String,
    inputType: InputType,
    hint: String,
    innerTextField: @Composable () -> Unit,
    trailingIcon: @Composable (() -> Unit)? = null,
) {

    val inputColor = when (inputType) {
        is InputType.Focus -> MainColor
        is InputType.Default -> Color.Gray
    }

    Surface(
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(width = 1.dp, color = BorderGray),
        modifier = Modifier
            .height(44.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 14.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 5.dp)
            ) {
                if (value.isEmpty()) {
                    Body1(
                        text = hint,
                        textColor = TextGray,
                        modifier = Modifier
                    )
                }
                innerTextField()
            }

            trailingIcon?.let {
                CompositionLocalProvider(
                    LocalContentColor provides inputColor
                ) {
                    trailingIcon()
                }
            }
        }
    }
}

private fun Modifier.addFocusCleaner(focusManager: FocusManager, doOnClear: () -> Unit = {}): Modifier {
    return this.pointerInput(Unit) {
        detectTapGestures(onTap = {
            doOnClear()
            focusManager.clearFocus()
        })
    }
}

@Composable
@Preview(showBackground = true)
fun InputPreview() {

    val focusManager = LocalFocusManager.current

    Column(
        Modifier
            .background(color = MaterialTheme.colors.background)
            .padding(24.dp)
            .fillMaxSize()
            .addFocusCleaner(focusManager)
    ) {
        Spacer(modifier = Modifier.padding(20.dp))

        var testValue1 by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }

        MTextField(
            value = testValue1,
            onValueChange = { testValue1 = it },
            hint = "댓글을 입력하세요",
            keyboardActions = KeyboardActions(
                onDone = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    ImageIcon()
                }
            },
        )

        Spacer(modifier = Modifier.padding(20.dp))

        var testValue3 by remember { mutableStateOf("") }

        MTextField(
            value = testValue3,
            onValueChange = { testValue3 = it },
            hint = "이름을 입력해주세요.",
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
        )
    }
}
