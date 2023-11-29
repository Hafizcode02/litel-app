package hafizcaniago.my.id.litelapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hotel(
    val name: String,
    val image: Int,
    val starRatings: String,
    val address: String,
    val price: String,
    val description: String
) : Parcelable