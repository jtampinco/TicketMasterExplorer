package com.jtampinco.ticketmasterexplorer.data.remote.util

import com.jtampinco.ticketmasterexplorer.data.remote.model.ImagesDto

fun findGoodQualityImage(imageList: List<ImagesDto>): String {
    for (image in imageList) {
        if (image.width > 500) {
            return image.url
        }
    }
    return ""
}