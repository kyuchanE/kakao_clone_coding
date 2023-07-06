package dev.kyu.clonekakao.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.kyu.clonekakao.R
import dev.kyu.clonekakao.model.MainBottomNavItem
import dev.kyu.clonekakao.ui.theme.CloneKakaoTheme

class MainActivity : ComponentActivity() {

    companion object {
        const val FRIENDS = "FRIENDS"
        const val CHATTING = "CHATTING"
        const val OPEN_CHATTING = "OPEN_CHATTING"
        const val SHOPPING = "SHOPPING"
        const val SETTING = "SETTING"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CloneKakaoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreenView()
                }
            }
        }
    }

}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = MainBottomNavItem.Friends.screenRoute
    ) {
        composable(MainBottomNavItem.Friends.screenRoute) {
            FriendsListScreen()
        }
        composable(MainBottomNavItem.Chatting.screenRoute) {
            ChattingListScreen()
        }
        composable(MainBottomNavItem.OpenChatting.screenRoute) {
            OpenChattingScreen()
        }
        composable(MainBottomNavItem.Shopping.screenRoute) {
            ShoppingScreen()
        }
        composable(MainBottomNavItem.Settings.screenRoute) {
            SettingScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenView() {

    val navController = rememberNavController()

    val items = listOf(
        MainBottomNavItem.Friends,
        MainBottomNavItem.Chatting,
        MainBottomNavItem.OpenChatting,
        MainBottomNavItem.Shopping,
        MainBottomNavItem.Settings
    )

    Scaffold(
        bottomBar = {
            BottomNavigation{
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.icon),
                                contentDescription = stringResource(id = screen.title),
                                modifier = Modifier
                                    .width(26.dp)
                                    .height(26.dp)
                            )
                        },
                        selectedContentColor = MaterialTheme.colorScheme.primary,
                        unselectedContentColor = Color.Gray,
                        selected = currentDestination?.hierarchy?.any { it.route == screen.screenRoute } == true,
                        alwaysShowLabel = true,
                        onClick = {
                            navController.navigate(screen.screenRoute) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            NavigationGraph(navController = navController)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun FriendsListScreen() {
    Box(
       modifier = Modifier
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

@Composable
fun ChattingListScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        Text(
            text = stringResource(id = R.string.str_friends_list),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun OpenChattingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(
            text = stringResource(id = R.string.str_friends_list),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun ShoppingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(
            text = stringResource(id = R.string.str_friends_list),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun SettingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = stringResource(id = R.string.str_friends_list),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}