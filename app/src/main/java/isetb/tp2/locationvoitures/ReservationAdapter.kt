package isetb.tp2.locationvoitures

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReservationAdapter(private val reservations: List<Reservation1>) :
    RecyclerView.Adapter<ReservationAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imgCar)
        val dateDebut: TextView = view.findViewById(R.id.dateDebut)
        val dateFin: TextView = view.findViewById(R.id.dateFin)
        val EtatRes: TextView = view.findViewById(R.id.EtatRes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_reservation, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val r = reservations[position]
        holder.img.setImageResource(R.drawable.image1)
        holder.dateDebut.text = "Début : ${r.dateDebut}"
        holder.dateFin.text = "Fin : ${r.dateFin}"
        holder.EtatRes.text= when (r.EtatRes) {
            "ACCEPTEE" -> "Acceptée"
            "REFUSEE" -> "Refusée"
            else -> "En attente"
        }
    }

    override fun getItemCount(): Int = reservations.size
}