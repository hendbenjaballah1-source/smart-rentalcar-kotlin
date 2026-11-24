package isetb.tp2.locationvoitures

import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("reservations")
    fun getReservations(): Call<List<Reservation1>>

    @GET("reservations/{id}")
    fun getReservationById(@Path("id") id: Int): Call<Reservation1>

    @POST("reservations")
    fun addReservation(@Body reservation: Reservation1): Call<Reservation1>

    @PUT("reservations/{id}")
    fun updateReservation(@Path("id") id: Int, @Body reservation: Reservation1): Call<Void>

    @DELETE("reservations/{id}")
    fun deleteReservation(@Path("id") id: Int): Call<Void>
}