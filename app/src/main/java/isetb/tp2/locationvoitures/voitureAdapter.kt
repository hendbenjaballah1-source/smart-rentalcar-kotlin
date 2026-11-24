package isetb.tp2.locationvoitures

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class voitureAdapter(
    private val voitures:List<voiture>,
    private val onDetailClick: (voiture) -> Unit

):RecyclerView.Adapter<voitureAdapter.voitureViewHolder>(){
    class voitureViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imgCar)
        val btn = view.findViewById<Button>(R.id.btnId)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): voitureViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_voiture, parent, false)
        return voitureViewHolder(view)
    }

    override fun onBindViewHolder(holder: voitureViewHolder, position: Int) {
        val voiture=voitures[position]
        holder.image.setImageResource(voiture.image)
        holder.btn.setOnClickListener {
            onDetailClick(voiture)
        }
    }

    override fun getItemCount(): Int {
        return voitures.size
    }

}