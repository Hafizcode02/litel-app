package hafizcaniago.my.id.litelapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hafizcaniago.my.id.litelapp.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
            super.onBackPressed()
        }
    }
}