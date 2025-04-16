import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.segundoparcial.buscador.BuscadorUI
import com.example.segundoparcial.navigation.Screens
import com.example.segundoparcial.librodetail.LibroDetailUI
import com.example.segundoparcial.listamegusta.ListaMeGustaUI

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.BuscadorScreen.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        composable(Screens.BuscadorScreen.route) {
            BuscadorUI(
                onClick = {
                    navController.navigate(Screens.BookDetailScreen.route)
                },
                onClick2 = {
                    navController.navigate(Screens.ListaMeGustaScreen.route)
                }
            )
        }
        composable(Screens.BookDetailScreen.route) {
            LibroDetailUI(
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screens.ListaMeGustaScreen.route) {
            ListaMeGustaUI(
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }
}