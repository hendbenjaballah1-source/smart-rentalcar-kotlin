package isetb.tp2.locationvoitures

data class voiture(
    val nom: String,
    val image: Int,
    val description: String,
    val prix: Int,
    val id: Int = 0
)