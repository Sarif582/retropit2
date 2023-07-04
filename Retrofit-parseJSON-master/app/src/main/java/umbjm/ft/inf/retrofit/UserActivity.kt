package umbjm.ft.inf.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import android.widget.Toast
import retrofit2.Response
import umbjm.ft.inf.retrofit.data.ResultUsers
import umbjm.ft.inf.retrofit.databinding.ActivityMainBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NetworkConfig().getService()
            .getUsers()
            .enqueue(object : Callback<List<ResultUsers>> {
                override fun onFailure(call: Call<List<ResultUsers>>, t: Throwable) {
                    Toast.makeText(this@UserActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<List<ResultUsers>>,
                    response: Response<List<ResultUsers>>
                ) {
                    binding.rvUser.adapter = UsersAdapter(response.body())
                }
            })
    }
}
