package umbjm.ft.inf.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import umbjm.ft.inf.retrofit.data.AnimeQuotes
import umbjm.ft.inf.retrofit.data.ApiPublik
import umbjm.ft.inf.retrofit.data.PicsumPhotos
import umbjm.ft.inf.retrofit.databinding.ActivityMainBinding

class PicsumActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NetworkConfig().getService2()
            .getPic()
            .enqueue(object : Callback<List<PicsumPhotos>> {
                override fun onFailure(call: Call<List<PicsumPhotos>>, t: Throwable) {
                    Toast.makeText(this@PicsumActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<List<PicsumPhotos>>,
                    response: Response<List<PicsumPhotos>>
                ) {
                    binding.rvPic.adapter = PicAdapter(response.body())
                }
            })
    }
}