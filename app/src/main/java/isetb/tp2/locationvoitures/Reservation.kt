package isetb.tp2.locationvoitures

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Reservation : AppCompatActivity() {

    private val reservations = mutableListOf<Reservation1>()
    private lateinit var adapter: ReservationAdapter

    private val BASE_URL = "http://10.0.2.2:3000/"

    private val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        val rv = findViewById<RecyclerView>(R.id.rvRes)
        adapter = ReservationAdapter(reservations)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
    }

    private fun loadReservations() {
        api.getReservations().enqueue(object : Callback<List<Reservation1>> {
            override fun onResponse(
                call: Call<List<Reservation1>>,
                response: Response<List<Reservation1>>
            ) {
                if (response.isSuccessful) {
                    reservations.clear()
                    reservations.addAll(response.body() ?: emptyList())
                    adapter.notifyDataSetChanged()
                } else {
                    Toast.makeText(
                        this@Reservation,
                        "Erreur : ${response.code()}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Reservation1>>, t: Throwable) {
                Toast.makeText(
                    this@Reservation,
                    "Erreur : ${t.message}",
                    Toast.LENGTH_LONG
                ).show()
                Log.e("API", "loadReservations", t)
            }
        })
    }


    override fun onResume() {
        super.onResume()
        loadReservations()
    }
}