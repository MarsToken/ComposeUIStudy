package com.test.composeui.ui.book.chapter3

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.test.composeui.ui.theme.ComposeUITheme

class Chapter3_3_Edittext : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUITheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TestTextField(this)
                }
            }
        }
    }
}

/**
 * 3-3 TextField
 *
 * Created by WangMaoBo.
 * Date: 2022/8/29
 */

@Preview(group = "测试TextField", name = "测试TextField基本用法")
@Composable
fun TestTextFieldPreview() {
    // TestTextField()
    TestOutlinedTextField()
}

/**
 * value - 要在文本字段中显示的输入文本
onValueChange - 输入服务更新文本时触发的回调。更新的文本作为回调的参数出现
modifier - 此文本字段的修饰符
enabled - 控制TextField的启用状态。当为false时，文本字段将不可编辑也不可聚焦，文本字段的输入将不可选择，视觉上文本字段将出现在禁用的 UI 状态
readOnly - 控制TextField的可编辑状态。如果为true ，则无法修改文本字段，但是，用户可以将其聚焦并从中复制文本。只读文本字段通常用于显示用户无法编辑的预填表单
注意：enabled ,readOnly都设置时，取全集
true,true:可全选，不可编辑
false，xxx：不可编辑不可全选，置灰
true,false:正常

textStyle - 应用于输入文本的样式。默认textStyle使用主题定义的LocalTextStyle
label -
placeholder - 当文本字段处于焦点且输入文本为空时显示的可选占位符。内部文本的默认文本样式是Typography.subtitle1，类似于 hint
leadingIcon - 显示在文本字段容器开头的可选前导图标
trailingIcon - 在文本字段容器末尾显示的可选尾随图标
isError - 指示文本字段的当前值是否错误。如果设置为true，默认情况下标签、底部指示符和尾随图标、顶部label均将以错误颜色显示
visualTransformation - 转换输入值的视觉表示 例如，您可以使用androidx.compose.ui.text.input.PasswordVisualTransformation创建密码文本字段(字段...表示)。默认情况下不应用视觉变换
keyboardOptions - 包含诸如KeyboardType和ImeAction配置的软件键盘选项，相当于EditText的inputType,四个参数，注意：只是设置了默认的输入形式，用户完全可以修改！！！
keyboardActions - 当输入服务发出 IME 操作时，会调用相应的回调。请注意，此 IME 操作可能与您在KeyboardOptions.imeAction（即keyboardOptions第四个参数）中指定的不同。
singleLine - 设置为 true 时，此文本字段变为单个水平滚动文本字段，而不是换行成多行。将通知键盘不要将返回键显示为ImeAction 。请注意， maxLines参数将被忽略，因为 maxLines 属性将自动设置为 1。
maxLines - 以最大可见线数表示的最大高度。应该等于或大于 1。请注意，此参数将被忽略，如果singleLine设置为 true，则 maxLines 将设置为 1。
interactionSource - 表示此 TextField 的Interaction流的MutableInteractionSource 。如果您想观察Interaction并自定义此 TextField 在不同Interaction中的外观/行为，您可以创建并传入您自己记住的MutableInteractionSource 。
shape - 文本字段容器的形状
colors - TextFieldColors将用于解析文本、内容（包括标签、占位符、前导和尾随图标、指示线）的颜色以及此文本字段在不同状态下的背景。请参阅TextFieldDefaults.textFieldColors
 */
@Composable
fun TestTextField(context: Context? = null) {
    val text = remember {
        mutableStateOf("")
    }
    val interactionSource = remember { MutableInteractionSource() }
    // interactionSource的用法，观察者监听状态，根据此标记动态展示UI，这个监听的是Press
    val isPressed by interactionSource.collectIsPressedAsState()
    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        label = { Text(text = "测试") },
        readOnly = false,
        enabled = true,
        textStyle = TextStyle(color = if (isPressed) {
            MaterialTheme.colors.primary
        } else {
            MaterialTheme.colors.background
        } ),
        placeholder = {
            Text(text = "请输入文本")
        },
//        leadingIcon = {
//            Icon(painter = painterResource(id = R.mipmap.ic_launcher), contentDescription = "")
//        },
//        trailingIcon = {
//            Icon(painter = painterResource(id = R.mipmap.ic_launcher_round), contentDescription = "")
//        },
        isError = true,
        // visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Characters,
            keyboardType = KeyboardType.Email,
            autoCorrect = false, // TODO 到底什么含义，有待确认,好像是无效的
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(onSearch = {
            context?.apply {
                Toast.makeText(this, text.value, Toast.LENGTH_SHORT).show()
            }
        }),
        interactionSource = interactionSource,
        shape = if (isPressed) {
            MaterialTheme.shapes.small
        } else {
            MaterialTheme.shapes.large
        }
    )
}

@Composable
fun TestOutlinedTextField() {
    val text = remember {
        mutableStateOf("这是默认文本")
    }
    OutlinedTextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        label = { Text(text = "测试") }
    )
}

@Preview(group = "测试BasicTextField基本用法")
@Composable
fun TestBasicTextFieldPreview() {
    TestBasicTextField()
}

/**
 * 无法设置label
 */
@Composable
fun TestBasicTextField() {
    val text = remember {
        mutableStateOf("这是默认文本")
    }
    BasicTextField(
        value = text.value,
        onValueChange = {
            text.value = it
        }
    )
}
