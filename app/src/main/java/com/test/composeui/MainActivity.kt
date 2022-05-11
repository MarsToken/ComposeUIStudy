package com.test.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.test.composeui.ui.theme.ComposeUITheme

/**
 * lesson2
 *
 * Coil 图片加载库 (Coroutine Image Loader)
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ComposeUITheme {
//                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
//                    Image(painter = painterResource(id = R.mipmap.ic_launcher),
//                        contentDescription = "")
//                }
//            }
            Image(
                painter = painterResource(id = R.mipmap.ic_launcher),
                contentDescription = ""
            )
            Image(
                rememberImagePainter("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg1.doubanio.com%2Fview%2Fnote%2Fl%2Fpublic%2Fp82460877.jpg&refer=http%3A%2F%2Fimg1.doubanio.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1653668312&t=9b2b65100384b4d2e439532607f2601f"),
                contentDescription = ""
            )
            // Accompanist https://github.com/google/accompanist Chris Banes 对 Coil 的 ComposeUI 的支持
            // 比如对 Picasso Glide Coil，最终移除了对这几个图片加载库的支持
            // Pager的支持
            // Compose 作曲， Accompanist 伴奏
            // Text() drawText() https://rengwuxian.com/ui-1-3/
            // Image() 底层 canvas.drawBitmap

            // Layout-Compose

            /**
             * 2-3 传统Layout的Compose平替
             * FrameLayout - Box
             * LinearLayout - Column/Row
             * RelativeLayout - Box + Modifier(位置)
             * ConstraintLayout -> MotionLayout（？） - Jetpack
             * ScrollView - Modifier.verticalScroll 比如 Column(Modifier.verticalScroll)
             * RecyclerView-Jetpack - LazyColumn+items,LazyRow+items
             * ViewPager-Jetpack - Pager(在 Accompanist)
             */
            val names = listOf("java", "kotlin", "swift")
            LazyColumn {
                items(names) { name ->
                    Box {
                        Text(name)
                    }
                }
            }
            /**
             * 2-4
             * modifier：顺序越往前，作用范围越大！！！！！！
             * Modifier两个特点：从内边距说起
             * 内外边距的本质就是为了隔离背景
             * 背景：Row(Modifier.background(Color.Red))
             * 内边距：无法隔离背景色，外边距可以隔离背景色
             * 内边距：Row(Modifier.padding(8.dp)) 或
             * 外边距：Row(Modifier.background(Color.Red))
             */
            Row(Modifier.padding(8.dp)) {
                Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "image")

            }
            showText()
            /**
             * 2-5从 Button 到 MD
             * 依赖关系
            composeOptions {
            kotlinCompilerExtensionVersion compose_version
            }
             * compose.runtime:数据结构，转换机制，最底层的定义
             * compose.ui:绘制，测量...基本控件的基本操作 Layout布局
             * compose.animation:动画
             * compose.foundation:根基，相对完整的UI体系，比如Row,Column,非强依赖，没有也可以自定义，有了更方便
             * compose.material(3):漂亮的UI风格，可以不用，比如 Button Floating Action Button，波纹效果
             * 从上到下传递依赖，所以只需要写一个material依赖即可
             * 特列：
             * compose.ui.ui-tooling和 ui-tooling-preview:预览功能
             * material-icons-core,material-icons-extended :矢量图
             * 包依赖原则：
             * 1.写代码，依赖material(3)就够了；可能跳过 material 依赖 foundation 就够了
             * 2.如果需要 ui-tooling,需要单独依赖
             * 3.如果需要 material-icons-extended，必须专门列出来
             */

        }
    }
}

/**
 * 2-1
 */
fun test(block: @Composable () -> Unit) {
    
}

/**
 * 2-5
 *
 */
@Preview
@Composable
fun showButton() {
    Row(Modifier.padding(8.dp)) {
        Button(onClick = {
            println("button is click")
        }) {

        }
    }
}

/**
 * 2-4
 * 文本，特别注意点击事件作用范围
 */
@Preview
@Composable
fun showText() {
    Row(Modifier.padding(16.dp)) {
        // 通用组件的设置用modifier，专项组件的设置用函数参数
        Text(
            text = "文本内容3",
            // 顺序越往前，作用范围越大
            Modifier
                .padding(8.dp)
                .background(Color.Yellow)
                .padding(8.dp)
                .clickable { // clickable的顺序 确定点击区域的位置，此处内外边距均点击无效
                    println("click")
                },
            fontSize = 16.sp,
            color = Color.Red
        )
    }
}

/**
 * 2-4
 * 1. 为图片绘制圆形
 *  Modifier.clip(CircleShape)
 * 2.size width height
 * layout_height:默认为 wrap_content
 * match_parent:fillMaxWidth/Height/Size
 */
@Preview
@Composable
fun showShape() {
    Row(Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(id = R.drawable.a1),
            contentDescription = "image",
            Modifier
                .clip(CircleShape)
                .size(128.dp)
        )
    }
}

/**
 * 2-4
 * 特别注意第二个参数：shape
 */
@Preview
@Composable
fun showBackground() {
    Row(Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(id = R.drawable.a1),
            contentDescription = "image",
            // 为背景绘制圆角
            Modifier
                .background(Color.Red, RoundedCornerShape(8.dp))
                .padding(8.dp)
        )
    }
}

/**
 * 2-4
 * 边距结论：background+padding = 内边距 padding = 内边距
 * padding+background = 外边距
 */
@Preview(showBackground = false)
@Composable
fun showMarginAndPadding() {
    Row(
        Modifier
            .background(Color.Red)
            .padding(8.dp)
    ) { // 内边距，无法隔离背景色
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "image")
        // 设置外边距
        Text(
            text = "文本内容1",
            Modifier
                .padding(8.dp)
                .background(Color.Green)
        ) // 外边距，可以隔离背景色
        // modifier 设置内边距
        Text(
            text = "文本内容2",
            Modifier
                .background(Color.Green)
                .padding(8.dp)
        )
        // modifier 对顺序是敏感的，且不会叠加任何重复api-先设置外边距再设置背景再设置内边距
        Text(
            text = "文本内容3",
            Modifier
                .padding(8.dp)
                .background(Color.Yellow)
                .padding(8.dp)
        )
    }
    Row {
        // 内边距
        Text(text = "文本内容4", Modifier.padding(8.dp))
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeUITheme {
        Greeting("Android")
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = ""
        )
        Image(
            rememberImagePainter("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg1.doubanio.com%2Fview%2Fnote%2Fl%2Fpublic%2Fp82460877.jpg&refer=http%3A%2F%2Fimg1.doubanio.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1653668312&t=9b2b65100384b4d2e439532607f2601f"),
            contentDescription = ""
        )
    }
}