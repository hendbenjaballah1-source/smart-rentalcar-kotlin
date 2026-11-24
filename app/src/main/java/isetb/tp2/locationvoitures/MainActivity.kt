package isetb.tp2.locationvoitures

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSeConnecter = findViewById<Button>(R.id.btnSeConnecter)
        val btnSinscrire = findViewById<Button>(R.id.btnSinscrire)
        val btnReservations = findViewById<Button>(R.id.btnReservations)

        val recycler1 = findViewById<RecyclerView>(R.id.recycler1)
        val recycler2 = findViewById<RecyclerView>(R.id.recycler2)

        val liste1 = listOf(
            voiture("Lamborghini Revuelto", R.drawable.image1,
                "Supercar hybride noire, 2 places, plus de 1000 ch. Performance et style extrêmes.", 2500, 1),
            voiture("Tesla Roadster", R.drawable.image2,
                "Cabriolet sportif 100 % électrique, accélération fulgurante et design futuriste.", 1200, 2),
            voiture("BMW X5 M", R.drawable.image3,
                "SUV sportif et spacieux, 5 places, idéal pour la famille comme pour la route.", 600, 3),
            voiture("Audi RS5 Sportback", R.drawable.image4,
                "Berline sportive 4 portes, transmission intégrale Quattro, confort et puissance.", 450, 4),
            voiture("Mercedes-AMG G 63", R.drawable.image5,
                "4x4 de luxe iconique, robuste en tout terrain et très élégant en ville.", 900, 5)
        )

        val liste2 = listOf(
            voiture("Bentley Continental GT", R.drawable.image6,
                "Coupé grand tourisme de luxe, intérieur cuir raffiné, parfait pour les longs trajets.", 1100, 6),
            voiture("Rolls-Royce Ghost", R.drawable.image7,
                "Berline de prestige, silence de roulement exceptionnel, confort inégalé.", 1500, 7),
            voiture("Ferrari 812 Superfast", R.drawable.image8,
                "Grand tourisme V12 rouge bordeaux, sonorité unique et performances de haut niveau.", 2200, 8),
            voiture("Volkswagen Golf GTI", R.drawable.image9,
                "Compacte sportive grise, agile, économique et agréable au quotidien.", 250, 9),
            voiture("Bugatti Chiron", R.drawable.image10,
                "Hypercar blanche, l'une des voitures les plus rapides au monde. Réservation limitée.", 5000, 10)
        )

        fun ouvrirDetail(v: voiture) {
            val intent = Intent(this, Detail::class.java)
            intent.putExtra("id", v.id)
            intent.putExtra("nom", v.nom)
            intent.putExtra("image", v.image)
            intent.putExtra("description", v.description)
            intent.putExtra("prix", v.prix)
            startActivity(intent)
        }

        recycler1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val adapter1 = voitureAdapter(liste1) { v -> ouvrirDetail(v) }
        val adapter2 = voitureAdapter(liste2) { v -> ouvrirDetail(v) }

        recycler1.adapter = adapter1
        recycler2.adapter = adapter2

        btnSeConnecter.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }

        btnSinscrire.setOnClickListener {
            startActivity(Intent(this, CreerCompte::class.java))
        }

        btnReservations.setOnClickListener {
            startActivity(Intent(this, Reservation::class.java))
        }
    }
}