package com.test.composeui.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * book 3-1 主题
 */

/**
    class Colors(    primary: Color, // 应用程序主要颜色
    primaryVariant: Color,  // 主要变体颜色，用于区分使用主要颜色的应用程序的两个元素，例如顶部应用程序栏和系统栏
    secondary: Color, // 辅助颜色，用于浮动操作按钮、选择控件、复选框和单选按钮等
    secondaryVariant: Color, // 辅助变体颜色，用于区分使用辅助颜色的应用程序的两个元素
    background: Color, // 背景颜色
    surface: Color, // 表面颜色，用于组件的表面，例如Card、menu
    error: Color, // 错误颜色，用于指示组件（例如文本字段）中的错误
    onPrimary: Color, // 用于显示在原色顶部的文本和图标的颜色
    onSecondary: Color, // 用于显示在辅助颜色顶部的文本和图标的颜色
    onBackground: Color, // 用于显示在背景颜色顶部的文本和图标的颜色
    onSurface: Color, // 用于显示在表面颜色顶部的文本和图标的颜色
    onError: Color, // 用于显示在错误颜色顶部的文本和图标的颜色
    isLight: Boolean // 是否为浅色模式)
 */
private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

/**
 * 创建项目时自动生成
 */
@Composable
fun ComposeUITheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    // 常量，供其他地方调用，之所以单独拿出来，是因为要考虑黑夜模式和白天模式两种 注意作用域
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    /**
     * 定义颜色类型,它是个函数，里面有默认值
     */
    MaterialTheme(
        /**
         * mutableStateOf,他是一个可感知的State，包含各种color，他没有状态，保存色值的类
         * 色值自定义：Color(0xFFFFFF)
         */
        colors = colors,
        /**
         * 字体排版，即字体样式，它内部存放了很多个TextStyle（类似于TextView的各种属性）
         */
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
