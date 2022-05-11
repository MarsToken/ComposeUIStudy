package com.test.composeui.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Lesson3 : AppCompatActivity() {
    @SuppressLint("UnrememberedMutableState", "CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /**
             * 3-1 自定义Composable -- 自定义界面组件 （首字母大写）
             * Compose 的编译器插件（Compiler Plugin）
             * 1.面向切面编程（AOP）
             * Annotation Processor 注解处理器，字节码处理
             *
             * 编译器插件-Compose注解原理？
             * @Composable - 识别符
             * "加了@Composable注解的函数 -- composable函数"
             *
             * 3-2
             * 刷新包括：组合（composition）、布局、绘制
             * 组合过程：拼凑出界面实际内容的过程
             *
             */
            var content by mutableStateOf("text")
            Row {
                Text(text = content)
            }
            lifecycleScope.launch(Dispatchers.Main) {
                delay(3000)
                content = "tom"
                println("after delay,text is $content")
            }

        }
    }
}

@Preview
@Composable
fun testMutableStateOf() {

}