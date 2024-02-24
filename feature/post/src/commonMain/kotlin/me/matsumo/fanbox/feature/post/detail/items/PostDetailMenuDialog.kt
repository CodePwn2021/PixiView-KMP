package me.matsumo.fanbox.feature.post.detail.items

import androidx.compose.runtime.Composable
import me.matsumo.fanbox.core.ui.MR
import me.matsumo.fanbox.core.ui.view.Action
import me.matsumo.fanbox.core.ui.view.ActionSheet

@Composable
internal fun PostDetailMenuDialog(
    isVisible: Boolean,
    onClickOpenBrowser: () -> Unit,
    onClickAllDownload: () -> Unit,
    onDismissRequest: () -> Unit,
) {
    val actions = listOf(
        Action(
            text = MR.strings.post_detail_open_browser,
            onClick = onClickOpenBrowser,
        ),
        Action(
            text = MR.strings.post_image_all_download,
            onClick = onClickAllDownload,
        ),
    )

    ActionSheet(
        isVisible = isVisible,
        actions = actions,
        onDismissRequest = onDismissRequest,
    )
}
