package me.matsumo.fanbox.feature.welcome.login

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.RouteBuilder

const val WelcomeLoginRoute = "welcomeLogin"

fun Navigator.navigateToWelcomeLogin() {
    this.navigate(WelcomeLoginRoute)
}

fun RouteBuilder.welcomeLoginScreen(
    navigateToLoginScreen: () -> Unit,
    navigateToWelcomePermission: () -> Unit,
) {
    scene(WelcomeLoginRoute) {
        WelcomeLoginScreen(
            modifier = Modifier.fillMaxSize(),
            navigateToLoginScreen = navigateToLoginScreen,
            navigateToWelcomePermission = navigateToWelcomePermission,
        )
    }
}
