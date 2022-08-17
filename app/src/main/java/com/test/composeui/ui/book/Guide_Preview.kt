package com.test.composeui.ui.book

import android.content.res.Configuration
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.test.composeui.R

/**
 * 导引 - Preview预览详解
 * 优势：预览效果可以发生在任何kt文件里
 * Created by WangMaoBo.
 * Date: 2022/8/17
 */

/**
 * TODO 为什么首字母要大写？
 *
 * Preview参数:可对照着xml里的Split预览模式查看
 * 详解说明：https://juejin.cn/post/6948390146043543560
 * 参数说明：
 *   val name: String = "", // 此预览的显示名称允许在面板中识别它
 *   val group: String = "", // 此预览面板的左上方的preview分组，默认是 all
 *   @IntRange(from = 1) val apiLevel: Int = -1,渲染带注释的 @ Composable时使用的 API 级别 不常用，一般是为了区分不同api有不同的UI效果
 *   val widthDp: Int = -1,
 *   val heightDp: Int = -1,
 *   val locale: String = "",// 当前用户对区域设置的偏好，对应于区域设置资源限定符-即语言
 *   // https://developer.android.com/reference/kotlin/androidx/compose/ui/tooling/preview/Preview 里超链接有对Locale的说明
 *   // http://www.loc.gov/standards/iso639-2/php/code_list.php // ISO 639-1 Code 官方超链接的link
 *   // 规则比较麻烦，只要记住：zh 中文， en 英文
 *   @FloatRange(from = 0.01) val fontScale: Float = 1f, // 用户对字体缩放因子的偏好，相对于基本密度缩放
 *  val showSystemUi: Boolean = false, // 如果为 true，将显示设备的状态栏和操作栏
 *  val showBackground: Boolean = false, // 如果为真，@Composable将使用默认背景颜色
 *  val backgroundColor: Long = 0,// ARGB Long，而不是 Color 值 注意 showBackground为 true 此值才生效
 *  @UiMode val uiMode: Int = 0, // ui模式的位掩码按照android.content.res.Configuration.uiMode 设置深色模式还是浅色模式等
 *  // uiMode : https://developer.android.google.cn/reference/kotlin/android/content/res/Configuration?hl=ch
 *  // 设置深色模式还是浅色模式等 我们可以看到很多的入参。这些入参都是我们可以配置的参数
 *   @Device val device: String = Devices.DEFAULT // 设备字符串，指示要在预览中使用的设备 查看设备中的可用设备 [Devices]
 *  // 有各种真实设备的样式，包括平板电脑
 *
 * tips：1.使用时，最好关掉预览，否则，会卡顿。
 *
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
    backgroundColor = 0x000000,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    apiLevel = 31,
    device = Devices.NEXUS_10
)
@Composable
fun TestPreview() {
    Text(
        stringResource(id = R.string.str_text_introduce),
        fontWeight = FontWeight.Bold
    )
}
