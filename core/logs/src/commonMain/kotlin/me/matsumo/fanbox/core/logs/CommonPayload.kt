package me.matsumo.fanbox.core.logs

import kotlinx.serialization.json.JsonObjectBuilder
import kotlinx.serialization.json.put

// This class is automatically generated by generate-log-classes.
data class CommonPayload(
    // ユーザー識別用の UUID
    // データ削除でリセットされる
    val pixiviewId: String,
    // ユーザーエージェント
    // ex) caios.android.fanbox/11; Android/28; SOV36; KDDI; f608ac4c29
    val userAgent: String,
    // FanboxViewer+ ユーザーか
    val isPlus: Boolean,
    // 開発者モードか
    val isDeveloper: Boolean,
    // テスターか
    val isTester: Boolean,
    // アプリケーション VersionCode (212700131 のような数値)
    val applicationVersionCode: Long,
    // アプリケーション VersionName (21.27.0.13 のような文字列)
    val applicationVersionName: String,
    // プラットフォーム (android, ios)
    val platform: String,
    // プラットフォームバージョン (12(32))
    val platformVersion: String,
    // デバイス名 (SOV36, iPhone 12 Pro)
    val device: String,
    // デバイスの ABI (arm64-v8a, x86)
    val deviceAbis: String,
    // タイムゾーン(Asia/Tokyoなど)
    val timeZone: String
) {
    fun applyToJsonObject(builder: JsonObjectBuilder) = builder.apply {
        put("pixiview_id", pixiviewId)
        put("user_agent", userAgent)
        put("is_plus", isPlus)
        put("is_developer", isDeveloper)
        put("is_tester", isTester)
        put("application_version_code", applicationVersionCode)
        put("application_version_name", applicationVersionName)
        put("platform", platform)
        put("platform_version", platformVersion)
        put("device", device)
        put("device_abis", deviceAbis)
        put("time_zone", timeZone)
    }
}
