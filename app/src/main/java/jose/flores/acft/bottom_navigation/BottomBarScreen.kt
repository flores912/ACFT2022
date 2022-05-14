package jose.flores.acft.bottom_navigation

import jose.flores.acft.R

sealed class BottomBarScreen(
    val title:String,
    val icon:Int,
    val  route:String
    ) {
    object Home: BottomBarScreen(
        title =  "Home",
        icon = R.drawable.ic_baseline_home_24,
        route = "home"
    )
    object Calculator: BottomBarScreen(
        title = "Calculator",
        icon = R.drawable.ic_baseline_calculate_24,
        route = "calculator"
    )
    object Statistics: BottomBarScreen(title = "Statistics",
        icon = R.drawable.ic_baseline_bar_chart_24,
        route = "statistics")

}
