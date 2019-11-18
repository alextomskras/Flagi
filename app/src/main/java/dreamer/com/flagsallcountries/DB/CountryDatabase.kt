package dreamer.com.flagsallcountries.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import dreamer.com.flagsallcountries.Model.CountryModel

@Database(entities = [(CountryModel::class)], version = 1)
abstract class CountryDatabase :RoomDatabase(){

    abstract fun countryDao() : CountryDao
}


