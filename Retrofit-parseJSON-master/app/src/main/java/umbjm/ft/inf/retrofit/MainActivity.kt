package umbjm.ft.inf.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import android.widget.Toast
import retrofit2.Response
import umbjm.ft.inf.retrofit.data.ApiPublik
import umbjm.ft.inf.retrofit.data.PicsumPhotos
import umbjm.ft.inf.retrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//            NetworkConfig().getService()
//            .getUsers()
//            .enqueue(object : Callback<List<ResultUsers>> {
//                override fun onFailure(call: Call<List<ResultUsers>>, t: Throwable) {
//                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
//                }
//
//                override fun onResponse(
//                    call: Call<List<ResultUsers>>,
//                    response: Response<List<ResultUsers>>
//                ) {
//                    binding.rvUser.adapter = UsersAdapter(response.body())
//                }
//            })
//            NetworkConfig().getService1()
//            .getAnime()
//            .enqueue(object : Callback<List<AnimeQuotes>> {
//                override fun onFailure(call: Call<List<AnimeQuotes>>, t: Throwable) {
//                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
//                }
//
//                override fun onResponse(
//                    call: Call<List<AnimeQuotes>>,
//                    response: Response<List<AnimeQuotes>>
//                ) {
//                    binding.rvAnime.adapter = AnimeAdapter(response.body())
//                }
//            })
            NetworkConfig().getService2()
            .getPic()
            .enqueue(object : Callback<List<PicsumPhotos>> {
                override fun onFailure(call: Call<List<PicsumPhotos>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<List<PicsumPhotos>>,
                    response: Response<List<PicsumPhotos>>
                ) {
                    binding.rvPic.adapter = PicAdapter(response.body())
                }
            })
            NetworkConfig().getService3()
            .getApi()
            .enqueue(object : Callback<List<ApiPublik>> {
                override fun onFailure(call: Call<List<ApiPublik>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<List<ApiPublik>>,
                    response: Response<List<ApiPublik>>
                ) {
                    binding.rvApi.adapter = ApiAdapter(response.body())
                }
            })
    }
}
