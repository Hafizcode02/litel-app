package hafizcaniago.my.id.litelapp.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import hafizcaniago.my.id.litelapp.R
import hafizcaniago.my.id.litelapp.adapter.HotelAdapter
import hafizcaniago.my.id.litelapp.data.Hotel
import hafizcaniago.my.id.litelapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val listHotels = ArrayList<Hotel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listHotels.addAll(getHotels())
        showRecyclerList()

        binding.btnToProfile.setOnClickListener {
            val moveActivity = Intent(applicationContext, ProfileActivity::class.java)
            startActivity(moveActivity);
        }
    }

    private fun showRecyclerList() {
        binding.rvHotels.layoutManager = LinearLayoutManager(this)
        val hotelsAdapter = HotelAdapter(listHotels)
        binding.rvHotels.adapter = hotelsAdapter
        binding.rvHotels.setHasFixedSize(true)
    }

    @SuppressLint("Recycle")
    private fun getHotels(): ArrayList<Hotel> {
        val name = resources.getStringArray(R.array.hotel_name)
        val image = resources.obtainTypedArray(R.array.hotel_image)
        val starRating = resources.getStringArray(R.array.hotel_star_rating)
        val address = resources.getStringArray(R.array.hotel_address)
        val price = resources.getStringArray(R.array.hotel_price)
        val description = resources.getStringArray(R.array.hotel_description)

        val listHotel = ArrayList<Hotel>()
        for (i in name.indices) {
            val hotel = Hotel(
                name[i],
                image.getResourceId(i, -1),
                starRating[i],
                address[i],
                price[i],
                description[i]
            )
            listHotel.add(hotel)
        }

        return listHotel
    }


}