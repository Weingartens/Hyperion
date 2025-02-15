package com.zt.innertube.domain.model

import androidx.compose.runtime.Immutable
import com.zt.innertube.network.dto.ApiImageSource
import com.zt.innertube.network.dto.browse.ChannelTab

@Immutable
data class DomainChannel(
    val id: String,
    val name: String,
    val description: String?,
    val subscriberText: String?,
    val avatar: String,
    val banner: ApiImageSource?,
    val tabs: List<ChannelTab>
) {
    val shareUrl = "https://www.youtube.com/channel/$id"
}

@Immutable
data class DomainChannelPartial(
    val id: String,
    val name: String? = null,
    val avatarUrl: String? = null,
    val subscriptionsText: String? = null,
    val videoCountText: String? = null
) : Entity