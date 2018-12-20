package thatzenbuhler.csu.fullerton.edu.application2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.beust.klaxon.Klaxon
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Uses Volley to send a request for weather data as a string, in JSON format
        val queue = Volley.newRequestQueue(this)
        val url = "https://api.openweathermap.org/data/2.5/weather?q=Fullerton,us&APPID=215f8ff3eab42cf87ccf1a8784c50456"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                processData(response)
            },
            Response.ErrorListener { temp.text = "Can't connect!" })
        queue.add(stringRequest)
    }

    fun processData(response: String){
        // Uses Klaxon to automatically parse the JSON and fill the WeatherData dataclass
        val data = Klaxon()
            .parse<WeatherData>(response)
        val result : WeatherData = data!!

        // Update text fields to reflect data
        description.text = result.weather[0].description.capitalize()
        temp.text = (((result.main.temp - 273.15) * 9/5) + 32).toString() + " °F"
        humidity.text = result.main.humidity.toString() + "%"
        wind.text = result.wind.deg.toString() + "° at " + result.wind.speed.toString() + " m/s"
    }
}
