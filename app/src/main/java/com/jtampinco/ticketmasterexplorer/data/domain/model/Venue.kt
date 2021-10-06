package com.jtampinco.ticketmasterexplorer.data.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Venue(
    val id: String,
    val name: String,
    val image: String?,
    val url: String?,
) : Parcelable