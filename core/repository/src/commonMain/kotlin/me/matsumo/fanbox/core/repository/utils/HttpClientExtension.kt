package me.matsumo.fanbox.core.repository.utils

import io.github.aakira.napier.Napier
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.request

suspend inline fun <reified T> HttpResponse.parse(
    allowRange: IntRange = 200..299,
    f: ((T?) -> (Unit)) = {},
): T? {
    val requestUrl = request.url
    val isOK = this.status.value in allowRange

    if (isOK) {
        Napier.d("[SUCCESS] Ktor Request: $requestUrl")
    } else {
        Napier.d("[FAILED] Ktor Request: $requestUrl")
        Napier.d("[RESPONSE] ${this.bodyAsText().replace("\n", "")}")
    }

    return (if (isOK) this.body<T>() else null).also(f)
}

fun HttpResponse.isSuccess(allowRange: IntRange = 200..299): Boolean {
    return (this.status.value in allowRange)
}

fun HttpResponse.requireSuccess(allowRange: IntRange = 200..299): HttpResponse {
    if (!isSuccess(allowRange)) error("Request failed: ${this.status.value}")
    return this
}
