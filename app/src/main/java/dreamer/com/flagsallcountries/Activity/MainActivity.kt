package dreamer.com.flagsallcountries.Activity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import dreamer.com.flagsallcountries.Model.CountryModel
import dreamer.com.flagsallcountries.CountryRecyclerViewAdapter
import dreamer.com.flagsallcountries.R

class MainActivity : AppCompatActivity() {

    lateinit var countryRecyclerView: androidx.recyclerview.widget.RecyclerView
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countryRecyclerView = findViewById(R.id.countryRecyclerView)

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        if(isNetworkConnected(this))
        {
            mainActivityViewModel.getCountriesFromAPIAndStore()

        }
        else
        {
            Toast.makeText(this,"No internet found. Showing cached list in the view",Toast.LENGTH_LONG).show()
        }

        mainActivityViewModel.getAllCountryList().observe(this, Observer<List<CountryModel>> { countryList ->
            Log.e(MainActivity::class.java.simpleName,countryList.toString())
            setUpCountryRecyclerView(countryList!!)
        })
    }

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }

    fun setUpCountryRecyclerView(countries : List<CountryModel>)
    {
        val countryRecyclerViewAdapter = CountryRecyclerViewAdapter(this, countries)
        countryRecyclerView.adapter = countryRecyclerViewAdapter
        countryRecyclerView.layoutManager = androidx.recyclerview.widget.GridLayoutManager(this, 2)
        countryRecyclerView.setHasFixedSize(true)

    }

}
