package ua.edu.lntu.cw3.data

import ua.edu.lntu.cw3.R
import ua.edu.lntu.cw3.model.GalleryItem

class Datasource {
    fun loadGallery() : List<GalleryItem> {
        return listOf<GalleryItem> (
            GalleryItem(R.string.gallery_item1, R.drawable.image1),
            GalleryItem(R.string.gallery_item2, R.drawable.image2),
            GalleryItem(R.string.gallery_item3, R.drawable.image3),
        )
    }
}