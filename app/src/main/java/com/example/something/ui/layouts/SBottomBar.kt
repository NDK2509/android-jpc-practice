package com.example.something.ui.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.something.R
import com.example.something.ui.theme.DEFAULT_PADDING
import com.example.something.ui.theme.PrimaryColor
import com.example.something.ui.theme.SecondaryColor

data class BottomBarItemProps(
    val icon: Painter,
    val route: String,
)

@Composable
fun BottomBarItem(
    props: BottomBarItemProps,
    onClick: () -> Unit = {},
    isActive: Boolean = true,
) {
    IconButton(
        modifier = Modifier
            .padding(6.dp)
            .background(
                if (isActive) PrimaryColor else Color.Transparent,
                shape = RoundedCornerShape(100)
            ),
        onClick = onClick,
    ) {
        Icon(
            props.icon,
            "BottomBar Icons",
            tint = if (isActive) SecondaryColor else PrimaryColor,
        )
    }
}

@Composable
fun SBottomBar(
    navController: NavController,
    items: List<BottomBarItemProps>,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Find the current index based on the route
    val currentIndex = items.indexOfFirst { it.route == currentRoute }.let { index ->
        if (index == -1) 0 else index
    }


    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = DEFAULT_PADDING)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .background(
                    SecondaryColor,
                    shape = RoundedCornerShape(100)
                )
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            items.forEachIndexed { idx, item ->
                BottomBarItem(
                    item,
                    onClick = {
                        navController.navigate(route = item.route)
                    },
                    isActive = idx == currentIndex,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    SBottomBar(
        navController = rememberNavController(),
        items = listOf(
            BottomBarItemProps(
                icon = painterResource(R.drawable.ic_notes), route = "home"
            ),
            BottomBarItemProps(
                icon = painterResource(R.drawable.ic_arrow_back), route = "home"
            ),
            BottomBarItemProps(
                icon = painterResource(R.drawable.ic_arrow_back), route = "home"
            ),
        )
    )
}