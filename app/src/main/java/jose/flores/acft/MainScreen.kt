package jose.flores.acft

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import jose.flores.acft.bottom_navigation.BottomBarScreen

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

    Scaffold(
        bottomBar = {
            BottomBar(
        navController = navController,
                bottomBarState = bottomBarState

    )}) {
        BottomNavGraph(navController = navController)
    }
}
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BottomBar(navController: NavHostController, bottomBarState: MutableState<Boolean>){
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Calculator,
        BottomBarScreen.Statistics,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    // Control BottomBar
    when (navBackStackEntry?.destination?.route) {
        "home" -> {
            // Show BottomBar
            bottomBarState.value = true
        }
        "calculator" -> {
            // Show BottomBar
            bottomBarState.value = true
        }
        "statistics" -> {
            // Show BottomBar
            bottomBarState.value = true
        }
        "event_details" -> {
            // Hide BottomBar
            bottomBarState.value = false
        }
    }
    //TODO:CUSTOMIZE BOTTOM NAV HERE
    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        content ={BottomNavigation {
            screens.forEach{screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
        }

    )

}
@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(painter = painterResource(id = screen.icon), contentDescription ="Navigation Icon" )
        },
        selected = currentDestination?.hierarchy?.any{
            it.route == screen.route
        } == true,
        onClick =  {
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled)
    )
}