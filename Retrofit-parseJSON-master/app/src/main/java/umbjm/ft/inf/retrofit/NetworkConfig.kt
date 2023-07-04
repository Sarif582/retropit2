package umbjm.ft.inf.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import umbjm.ft.inf.retrofit.data.AnimeQuotes

import umbjm.ft.inf.retrofit.data.ApiPublik
import umbjm.ft.inf.retrofit.data.PicsumPhotos
import umbjm.ft.inf.retrofit.data.ResultUsers

class NetworkConfig {
    // set interceptor
    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return  okHttpClient
    }
    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRetrofit1() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://animechan.xyz/api/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRetrofit2() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://picsum.photos/v2/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getRetrofit3() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.publicapis.org/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getService() = getRetrofit().create(Users::class.java)
    fun getService1() = getRetrofit1().create(Anime::class.java)
    fun getService2() = getRetrofit2().create(Pic::class.java)
    fun getService3() = getRetrofit3().create(Api::class.java)
}
interface Users {
    @GET("users")
    fun getUsers(): Call<List<ResultUsers>>
}
interface Anime {
    @GET("quotes")
    fun getAnime(): Call<List<AnimeQuotes>>
}

interface Pic {
    @GET("list")
    fun getPic(): Call<List<PicsumPhotos>>
}

interface Api {
    @GET("entries")
    fun getApi(): Call<List<ApiPublik>>
}