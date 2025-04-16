import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.segundoparcial.buscador.BuscadorUI
import com.example.segundoparcial.navigation.Screens
import com.example.segundoparcial.buscador.LibroGustadosUI

@Composable
fun AppNavigation() {
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
            BuscadorUI()
        }

        composable(Screens.LibroGustadosUI.route) {
            LibroGustadosUI(
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }
}