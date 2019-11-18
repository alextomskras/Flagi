package dreamer.com.flagsallcountries

import android.app.Application
import androidx.room.Room
import dreamer.com.flagsallcountries.DB.CountryDatabase

class RoomViewModelKotlinSampleApplication : Application() {

    companion object {
        var database: CountryDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database =  Room.databaseBuilder(applicationContext, CountryDatabase::class.java, "country_db").fallbackToDestructiveMigration().build()
    }
}