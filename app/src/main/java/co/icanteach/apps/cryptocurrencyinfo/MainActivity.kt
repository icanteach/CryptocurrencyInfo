package co.icanteach.apps.cryptocurrencyinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.icanteach.apps.cryptocurrencyinfo.designsystem.AppTheme
import co.icanteach.apps.cryptocurrencyinfo.presentation.listing.CoinListingScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "CoinListingScreen"
                    ) {
                        composable(
                            route = "CoinListingScreen"
                        ) {
                            CoinListingScreen(navController)
                        }
                    }
                }
            }
        }
    }
}