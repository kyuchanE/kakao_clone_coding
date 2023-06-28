package dev.kyu.clonekakao.model

import dev.kyu.clonekakao.R
import dev.kyu.clonekakao.view.MainActivity

sealed class MainBottomNavItem(
    val title: Int,
    val icon: Int,
    val screenRoute: String
) {
    object Friends: MainBottomNavItem(R.string.str_friends_list, R.drawable.baseline_people_alt_24, MainActivity.FRIENDS)
    object Chatting: MainBottomNavItem(R.string.str_chatting, R.drawable.baseline_chat_bubble_24, MainActivity.CHATTING)
    object OpenChatting: MainBottomNavItem(R.string.str_open_chatting, R.drawable.baseline_chat_24, MainActivity.OPEN_CHATTING)
    object Shopping: MainBottomNavItem(R.string.str_shopping, R.drawable.baseline_shopping_bag_24, MainActivity.SHOPPING)
    object Settings: MainBottomNavItem(R.string.str_setting, R.drawable.baseline_more_horiz_24, MainActivity.SETTING)
}
