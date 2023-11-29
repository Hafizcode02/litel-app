package hafizcaniago.my.id.litelapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hafizcaniago.my.id.litelapp.data.Hotel
import hafizcaniago.my.id.litelapp.databinding.HotelsItemBinding
import hafizcaniago.my.id.litelapp.view.DetailActivity

class HotelAdapter(private val listHotel: ArrayList<Hotel>) :
    RecyclerView.Adapter<HotelAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: HotelsItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = HotelsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, image, starRatings, address, price) = listHotel[position]
        holder.binding.hotelImg.setImageResource(image)
        holder.binding.hotelName.text = name
        holder.binding.hotelStarsAndRating.text = starRatings
        holder.binding.hotelAddress.text = address
        holder.binding.hotelPrice.text = price

        holder.itemView.setOnClickListener {
            val moveToDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            moveToDetail.putExtra("hotels_data", listHotel[holder.adapterPosition])
            holder.itemView.context.startActivity(moveToDetail)
        }
    }

    override fun getItemCount(): Int {
        return listHotel.size
    }
}