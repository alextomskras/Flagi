package dreamer.com.flagsallcountries.Retrofit

import retrofit2.Call
import retrofit2.http.GET
import dreamer.com.flagsallcountries.Model.CountryModel

interface RestApi {

    @GET("all")
    fun getAllCountries() : Call<List<CountryModel>>
}