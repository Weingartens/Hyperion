package com.zt.innertube.network.dto.browse

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
internal data class ApiSubscriptions(
    override val contents: Contents<JsonElement>
) : ApiBrowse()

internal typealias ApiSubscriptionsContinuation = ApiBrowseContinuation<JsonElement>