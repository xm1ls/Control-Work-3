package ua.edu.lntu.cw3.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class GalleryItem(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
)
