package com.test.composeui.ui.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.test.composeui.ui.theme.ComposeUITheme

// 3.1主题设置
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent(parent = null,
            // content:@Compose () -> Unit
            content = {
                ComposeUITheme(true) {
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
            })
    }

}

@Composable
fun test() {

}