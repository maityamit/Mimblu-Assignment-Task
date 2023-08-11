package mimbluassignmentbyamit.example.mimbluassignment.Symptoms

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("mimblu-yii2-1552/api/user/symptoms/")
    fun getApiResponse(): Call<SymptomsMode>
}