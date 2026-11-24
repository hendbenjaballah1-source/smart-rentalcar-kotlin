package isetb.tp2.locationvoitures

data class Reservation1(
    var id: Int? = null,
    var dateDebut: String,
    var dateFin: String,
    var EtatRes: String = "EN_ATTENTE",
    var clientId: Int,
    var vehiculeId: Int
)
