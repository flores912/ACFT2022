package jose.flores.acft

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import jose.flores.acft.bottom_navigation.BottomBarScreen
import jose.flores.acft.bottom_navigation.BottomBarScreen.*
//todo:organize screen route objects
@Composable
fun BottomNavGraph(navController:NavHostController){

   NavHost(
      navController = navController,
      startDestination = Home.route,
   ){
      composable(
         route = Home.route
      ){
         HomeScreen(navController)
      }
      composable(
         route = Calculator.route
      ){
         CalculatorScreen()
      }
      composable(
         route = Statistics.route
      ){
         StatisticsScreen()
      }
      composable("event_details"){
         EventDetails()
      }
   }
}