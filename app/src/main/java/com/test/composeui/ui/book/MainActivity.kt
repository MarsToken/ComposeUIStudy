package com.test.composeui.ui.book

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import com.test.composeui.R
import com.test.composeui.ui.theme.ComposeUITheme

// 3.1主题设置
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent(parent = null,
            // content:@Compose () -> Unit
            content = {
                ComposeUITheme(true) {
                    Surface(
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text(text = "HelloWord!",
                            /**
                             * 颜色的使用，MaterialTheme为ComposeUITheme里定义的一个单例类的对象，里面存放一些常量
                             * 引用链：color = MaterialTheme.colors.primary
                             * -> ComposeUITheme.colors
                             * -> DarkColorPalette or LightColorPalette
                             * -> primary（Colors里定义的一个color）
                             */
                            color = MaterialTheme.colors.primary,
                            /**
                             * 排版，字体风格的使用,MaterialTheme为ComposeUITheme里定义的一个单例类的对象，里面存放一些常量
                             * 引用链：style = MaterialTheme.typography.caption
                             * -> ComposeUITheme.typography
                             * // typography里定义的一个TextStyle，所有的默认值在 Typography
                             * -> caption: TextStyle = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            letterSpacing = 0.4.sp
                            )
                             */
                            style = MaterialTheme.typography.caption
                        )
                    }
                }
            })
    }

}

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

/**
 * TODO 为什么首字母要大写？
 * Preview参数
 * https://juejin.cn/post/6948390146043543560
 *  val name: String = "", // 此预览的显示名称允许在面板中识别它
    val group: String = "", // 此预览面板的左上方的preview分组，默认是 all
    @IntRange(from = 1) val apiLevel: Int = -1,为什么意义何在？
    val widthDp: Int = -1,
    val heightDp: Int = -1,
    val locale: String = "",// 当前用户对区域设置的偏好，对应于区域设置资源限定符-即语言
    // https://developer.android.com/reference/kotlin/androidx/compose/ui/tooling/preview/Preview 里超链接有对Locale的说明
    // http://www.loc.gov/standards/iso639-2/php/code_list.php // ISO 639-1 Code 官方超链接的link
    // 规则比较麻烦，只要记住：zh 中文， en 英文
    @FloatRange(from = 0.01) val fontScale: Float = 1f, // 用户对字体缩放因子的偏好，相对于基本密度缩放
    val showSystemUi: Boolean = false, // 如果为 true，将显示设备的状态栏和操作栏
    val showBackground: Boolean = false, // 如果为真，@Composable将使用默认背景颜色
    val backgroundColor: Long = 0,// ARGB Long，而不是 Color 值 注意 showBackground为 true 此值才生效
    @UiMode val uiMode: Int = 0, // ui模式的位掩码按照android.content.res.Configuration.uiMode
    // 设置深色模式还是浅色模式等 我们可以看到很多的入参。这些入参都是我们可以配置的参数
    @Device val device: String = Devices.DEFAULT // 设备字符串，指示要在预览中使用的设备

    tips：1.使用时，最好关掉预览，否则，会卡顿。
 */
@Preview(
    name = "测试预览",
    group = "测试分组",
    showBackground = true,
    widthDp = 100,
    heightDp = 50,
    locale = "zh",
    fontScale = 1f,
    showSystemUi = true,
    backgroundColor = 0x000000
)
@Composable
fun TextTestPreview() {
    TestTest()
    // ImageViewTest()
}

@Composable
fun ImageViewTest() {
    Image(
        painter = painterResource(id = R.drawable.a1),
        contentDescription = ""
    )
}

@Preview
@Composable
fun ImageViewPreview() {
     // ImageViewTest()
}
