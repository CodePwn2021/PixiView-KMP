package me.matsumo.fanbox.core.logs.category

import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

// This class is automatically generated by generate-log-classes.
sealed class WelcomeLog : LogCategory {

    class FirstOpen internal constructor() : WelcomeLog() {
        override val properties: JsonObject = buildJsonObject {
            put("event_category", "welcome")
            put("event_name", "first_open")
        }
    }

    class LoggedIn internal constructor() : WelcomeLog() {
        override val properties: JsonObject = buildJsonObject {
            put("event_category", "welcome")
            put("event_name", "logged_in")
        }
    }

    class LoggedOut internal constructor() : WelcomeLog() {
        override val properties: JsonObject = buildJsonObject {
            put("event_category", "welcome")
            put("event_name", "logged_out")
        }
    }

    class CompletedOnboarding internal constructor(
        private val startAt: String,
        private val endAt: String,
        private val neededTime: Long
    ) : WelcomeLog() {
        override val properties: JsonObject = buildJsonObject {
            put("event_category", "welcome")
            put("event_name", "completed_onboarding")
            put("start_at", startAt)
            put("end_at", endAt)
            put("needed_time", neededTime)
        }
    }

    companion object {
        // アプリを初めて開いたときのログ
        fun firstOpen() = FirstOpen()

        // ログインしたときのログ
        fun loggedIn() = LoggedIn()

        // ログアウトしたときのログ
        fun loggedOut() = LoggedOut()

        // オンボーディングを完了したときのログ
        fun completedOnboarding(
            startAt: String,
            endAt: String,
            neededTime: Long
        ) = CompletedOnboarding(startAt, endAt, neededTime)
    }
}
