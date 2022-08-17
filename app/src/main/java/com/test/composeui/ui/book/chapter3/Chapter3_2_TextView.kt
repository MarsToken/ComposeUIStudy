package com.test.composeui.ui.book

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.test.composeui.R

/**
 * 3-2 文本详解
 *
 * Created by WangMaoBo.
 * Date: 2022/8/17
 */

/**
 * 3.2
 * @Composable
 * fun Text(
 * text: String,    modifier: Modifier = Modifier, // 修饰符
 * color: Color = Color.Unspecified, // 文本颜色
 * fontSize: TextUnit = TextUnit.Unspecified, // 字号大小
 * fontStyle: FontStyle? = null, // 字体样式：斜体
 * fontWeight: FontWeight? = null, // 字体粗细
 * fontFamily: FontFamily? = null, // 字体
 * letterSpacing: TextUnit = TextUnit.Unspecified, // 字符间距
 * textDecoration: TextDecoration? = null, // 要在文字上绘制的装饰（例如下划线）
 * textAlign: TextAlign? = null, // 文本在段落中的对齐方式
 * lineHeight: TextUnit = TextUnit.Unspecified, // 行高
 * overflow: TextOverflow = TextOverflow.Clip, // 视觉溢出应如何处理
 * softWrap: Boolean = true, // 文本是否应在换行符处中断
 * maxLines: Int = Int.MAX_VALUE, // 最大行数
 * onTextLayout: (TextLayoutResult) -> Unit = {}, // 计算新的文本布局时执行的回调
 * style: TextStyle = LocalTextStyle.current // 文本的样式配置，例如颜色、字体、行高等)
 */
@Composable
fun TestTest() {
    Text(
        stringResource(id = R.string.str_text_introduce),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun TextTestPreview() {
    TestTest()
}