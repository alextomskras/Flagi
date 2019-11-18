package dreamer.com.flagsallcountries.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Countries")
data class CountryModel (

        @PrimaryKey
        var name : String,
        var capital : String,
        var region: String,
        var subregion: String,
        var population : Int,
        var flag:String

)
