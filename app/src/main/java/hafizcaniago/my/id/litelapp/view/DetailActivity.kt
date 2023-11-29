package hafizcaniago.my.id.litelapp.view

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hafizcaniago.my.id.litelapp.data.Hotel
import hafizcaniago.my.id.litelapp.databinding.ActivityDetailBinding


@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hotel = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("hotels_data", Hotel::class.java)
        } else {
            intent.getParcelableExtra("hotels_data")
        }

        if (hotel != null) {
            binding.hotelNameDetail.text = hotel.name
            binding.imageDetail.setImageResource(hotel.image)
            binding.hotelAddressDetail.text = hotel.address
            binding.hotelPriceDetail.text = hotel.price
            binding.hotelStarsAndRatingDetail.text = hotel.starRatings
            binding.descriptionVal.text = hotel.description
        }

        binding.btnShare?.setOnClickListener {
            val phoneNumber = "08123456789"
            val sms = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:${phoneNumber}"))
            sms.putExtra("sms_body", "${hotel?.name} is recommended")
            startActivity(sms)
        }

        binding.btnBack.setOnClickListener {
            finish()
            super.onBackPressed()
        }
    }
}