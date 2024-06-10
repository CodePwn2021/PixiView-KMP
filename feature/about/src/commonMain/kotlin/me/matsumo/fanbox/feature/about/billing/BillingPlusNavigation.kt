package me.matsumo.fanbox.feature.about.billing

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import me.matsumo.fanbox.core.ui.component.sheet.bottomSheet
import me.matsumo.fanbox.core.ui.extensition.navigateWithLog

const val BillingPlusRoute = "billingPlus"

fun NavController.navigateToBillingPlus() {
    this.navigateWithLog(BillingPlusRoute)
}

fun NavGraphBuilder.billingPlusBottomSheet(
    terminate: () -> Unit,
) {
    bottomSheet(BillingPlusRoute) {
        BillingPlusRoute(
            modifier = Modifier.fillMaxSize(),
            terminate = terminate,
        )
    }
}
