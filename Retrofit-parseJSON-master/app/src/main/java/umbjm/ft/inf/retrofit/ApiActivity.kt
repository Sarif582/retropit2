package umbjm.ft.inf.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import umbjm.ft.inf.retrofit.data.ApiPublik
import umbjm.ft.inf.retrofit.data.ResultUsers
import umbjm.ft.inf.retrofit.databinding.ActivityMainBinding

class ApiActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NetworkConfig().getService3()
            .getApi()
            .enqueue(object : Callback<List<ApiPublik>> {
                override fun onFailure(call: Call<List<ApiPublik>>, t: Throwable) {
                    Toast.makeText(this@ApiActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
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
