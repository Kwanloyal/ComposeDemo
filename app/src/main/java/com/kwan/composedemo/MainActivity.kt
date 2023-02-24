package com.kwan.composedemo

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWorld()
        }
    }

    @Composable
    private fun HelloWorld() {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
//               text = "Hello World!",
                stringResource(R.string.hello_world, 2),
                modifier = Modifier
                    .background(Color.Black)
                    .width(100.dp)
                    .padding(20.dp)
                    .clickable {
                        Toast
                            .makeText(this@MainActivity, "Hello World!", Toast.LENGTH_SHORT)
                            .show()
                    },
                color = Color.White,
                fontSize = 30.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.W400,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center
            )
            Divider(color = Color.Black)
            Text(text = "Hello World3", color = Color.Blue)
            ListMessage(messageList = listOf("text1", "text2", "text3", "text4", "text5", "text6", "text7", "text8", "text9", "text10"))
        }
    }

    @Composable
    private fun ListMessage(messageList: List<String>) {
        Column(
            modifier = Modifier
                .size(100.dp)
                .background(Color.LightGray)
                .verticalScroll(rememberScrollState())
        ) {
            messageList.forEach { message ->
                Text(text = message)
            }
        }
    }

}