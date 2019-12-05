package arellano.christian.volley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   // val textView = findViewById<TextView>(R.id.text)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val queue = Volley.newRequestQueue(this)
        val url = "http://www.google.com"

        val strinRequest = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener{ response ->
                Log.d( "Respuesta", "${response.substring(0,500)}")
                mostrarRespuesta.text = "Respuesta es: ${response.substring(0,500)}"
        },
            Response.ErrorListener { error ->
             mostrarRespuesta.text = "Error: ${error.message}"
                Log.d( "Error", "${error.message}")
            })

        queue.add(strinRequest)
    }




}
