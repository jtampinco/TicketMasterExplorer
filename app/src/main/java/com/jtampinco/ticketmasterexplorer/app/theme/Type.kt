package com.jtampinco.ticketmasterexplorer.app.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.jtampinco.ticketmasterexplorer.R

private val robotoFontFamily = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.roboto_black,
            weight = FontWeight.Black,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.roboto_black_italic,
            weight = FontWeight.Black,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.roboto_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.roboto_bold_italic,
            weight = FontWeight.Bold,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.roboto_light,
            weight = FontWeight.Light,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.roboto_light_italic,
            weight = FontWeight.Light,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.roboto_medium,
            weight = FontWeight.Medium,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.roboto_medium_italic,
            weight = FontWeight.Medium,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.roboto_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.roboto_italic,
            weight = FontWeight.Normal,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.roboto_thin,
            weight = FontWeight.Thin,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.roboto_thin_italic,
            weight = FontWeight.Thin,
            style = FontStyle.Italic
        )
    )
)


val typography = Typography().let {
    Typography(
        h1 = it.h1.copy(fontFamily = robotoFontFamily),
        h2 = it.h2.copy(fontFamily = robotoFontFamily),
        h3 = it.h3.copy(fontFamily = robotoFontFamily),
        h4 = it.h4.copy(fontFamily = robotoFontFamily),
        h5 = it.h5.copy(fontFamily = robotoFontFamily),
        h6 = it.h6.copy(fontFamily = robotoFontFamily),
        subtitle1 = it.subtitle1.copy(fontFamily = robotoFontFamily),
        subtitle2 = it.subtitle2.copy(fontFamily = robotoFontFamily),
        body1 = it.body1.copy(fontFamily = robotoFontFamily),
        body2 = it.body2.copy(fontFamily = robotoFontFamily),
        button = it.button.copy(fontFamily = robotoFontFamily),
        caption = it.caption.copy(fontFamily = robotoFontFamily),
        overline = it.overline.copy(fontFamily = robotoFontFamily)
    )
}


