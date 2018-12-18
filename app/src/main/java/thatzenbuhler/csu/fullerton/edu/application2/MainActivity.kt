package thatzenbuhler.csu.fullerton.edu.application2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO: get this to work fam
        val jsondata = URL("http://api.openweathermap.org/data/2.5/weather?q=Fullerton,us&APPID=215f8ff3eab42cf87ccf1a8784c50456").readText()

        //TODO: initialize Moshi to process json

    }
}
