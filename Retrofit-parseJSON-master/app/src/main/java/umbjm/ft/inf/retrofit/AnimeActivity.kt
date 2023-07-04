package umbjm.ft.inf.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import umbjm.ft.inf.retrofit.data.AnimeQuotes
import umbjm.ft.inf.retrofit.data.ResultUsers
import umbjm.ft.inf.retrofit.databinding.ActivityMainBinding

class AnimeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NetworkConfig().getService1()
            .getAnime()
            .enqueue(object : Callback<List<AnimeQuotes>> {
                override fun onFailure(call: Call<List<AnimeQuotes>>, t: Throwable) {
                    Toast.makeText(this@AnimeActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<List<AnimeQuotes>>,
                    response: Response<List<AnimeQuotes>>
                ) {
                    binding.rvAnime.adapter = AnimeAdapter(response.body())
                }
            })
    }
}