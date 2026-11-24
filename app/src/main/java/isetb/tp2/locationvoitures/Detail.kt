package isetb.tp2.locationvoitures

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Calendar

class Detail : AppCompatActivity() {
    private var vehiculeId: Int = -1

    private lateinit var image: ImageView
    private lateinit var modele: TextView
    private lateinit var prix: TextView
    private lateinit var description: TextView
    private lateinit var dateDebut: EditText
    private lateinit var dateFin: EditText
    private lateinit var btnReserver: Button

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
        setContentView(R.layout.activity_detail)

        image = findViewById(R.id.imgDetail)
        modele = findViewById(R.id.idModele)
        prix = findViewById(R.id.prixJour)
        description = findViewById(R.id.idDescription)
        dateDebut = findViewById(R.id.dateDebut)
        dateFin = findViewById(R.id.dateFin)
        btnReserver = findViewById(R.id.btnRes)

        // On reçoit l'id et les informations de la voiture cliquée
        vehiculeId = intent.getIntExtra("id", -1)
        if (vehiculeId == -1) {
            Toast.makeText(this, "Id introuvable", Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        modele.text = intent.getStringExtra("nom")
        description.text = intent.getStringExtra("description")
        prix.text = "${intent.getIntExtra("prix", 0)} DT / jour"
        image.setImageResource(intent.getIntExtra("image", 0))

        dateDebut.setOnClickListener { choisirDate(dateDebut) }
        dateFin.setOnClickListener { choisirDate(dateFin) }

        btnReserver.setOnClickListener {
            addReservation()
        }
    }

    private fun choisirDate(champ: EditText) {
        val cal = Calendar.getInstance()
        DatePickerDialog(
            this,
            { _, annee, mois, jour ->
                champ.setText(String.format("%04d-%02d-%02d", annee, mois + 1, jour))
            },
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun addReservation() {
        val dateD = dateDebut.text.toString().trim()
        val dateF = dateFin.text.toString().trim()

        if (dateD.isEmpty() || dateF.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir les dates", Toast.LENGTH_SHORT).show()
            return
        }

        val reservation = Reservation1(
            dateDebut = dateD,
            dateFin = dateF,
            clientId = 1,
            vehiculeId = vehiculeId
        )

        api.addReservation(reservation).enqueue(object : Callback<Reservation1> {
            override fun onResponse(call: Call<Reservation1>, response: Response<Reservation1>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@Detail, "Réservation ajoutée", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@Detail, Reservation::class.java))
                } else {
                    Toast.makeText(
                        this@Detail,
                        "Erreur : ${response.code()}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<Reservation1>, t: Throwable) {
                Toast.makeText(this@Detail, "Erreur : ${t.message}", Toast.LENGTH_LONG).show()
                Log.e("API", "addReservation", t)
            }
        })
    }
}