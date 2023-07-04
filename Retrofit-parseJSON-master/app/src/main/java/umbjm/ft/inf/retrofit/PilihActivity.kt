package umbjm.ft.inf.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class PilihActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih)

        // Mengatur onClickListener untuk setiap tombol
        findViewById<View>(R.id.p_user).setOnClickListener(this)
        findViewById<View>(R.id.p_anime).setOnClickListener(this)
      findViewById<View>(R.id.p_pic).setOnClickListener(this)
      findViewById<View>(R.id.p_api).setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.p_user -> {
                // Tombol USER diklik, lakukan tindakan yang diperlukan
                // Contoh: Pindah ke aktivitas Pengguna (UserActivity)
                val intent = Intent(this, UserActivity::class.java)
                startActivity(intent)
            }
            R.id.p_anime -> {
                // Tombol ANIME diklik, lakukan tindakan yang diperlukan
                // Contoh: Pindah ke aktivitas Anime (AnimeActivity)
                val intent = Intent(this, AnimeActivity::class.java)
                startActivity(intent)
            }
           R.id.p_pic -> {
//                // Tombol PICSUM diklik, lakukan tindakan yang diperlukan
//                // Contoh: Pindah ke aktivitas Picsum (PicsumActivity)
               val intent = Intent(this, PicsumActivity::class.java)
              startActivity(intent)
           }
           R.id.p_api -> {
//                // Tombol API diklik, lakukan tindakan yang diperlukan
//                // Contoh: Pindah ke aktivitas API (ApiActivity)
                val intent = Intent(this, ApiActivity::class.java)
             startActivity(intent)
           }
        }
    }
}
