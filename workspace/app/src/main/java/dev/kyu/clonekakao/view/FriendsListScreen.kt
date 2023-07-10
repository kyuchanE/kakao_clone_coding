package dev.kyu.clonekakao.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.kyu.clonekakao.utils.L

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun FriendsListScreen() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "친구")
                },
                actions = {
                    IconButton(onClick = {
                        L.d("TopBar Click 1")
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "Share",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = {
                        L.d("TopBar Click 2")
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "Share",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = {
                        L.d("TopBar Click 3")
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "Share",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = {
                        L.d("TopBar Click 4")
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "Share",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Black),
            )
        }
    ) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .background(Color.Gray)
        ) {
            val sections = listOf("A", "B", "C", "D", "E", "F", "G")

            LazyColumn(
                reverseLayout = false,
                contentPadding = PaddingValues(6.dp)
            ) {
//            sections.forEach { section ->
//                stickyHeader{
//                    Text(
//                        "Section $section",
//                        Modifier
//                            .fillMaxWidth()
//                            .background(Color.LightGray)
//                            .padding(8.dp)
//                    )
//                }
//                items(10) {
//                    Text(text = "Item $it from the section $section")
//                }
//            }

                items(items = sections) {item ->
                    Text(text = "Item section $item")
                }
            }
        }
    }

}

