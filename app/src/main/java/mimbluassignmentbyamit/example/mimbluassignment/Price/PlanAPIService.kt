package mimbluassignmentbyamit.example.mimbluassignment.Price

import mimbluassignmentbyamit.example.mimbluassignment.Symptoms.SymptomsMode
import retrofit2.Call
import retrofit2.http.GET

interface PlanAPIService {
    @GET("mimblu-yii2-1552/api/plan/all/")
    fun getApiResponse(): Call<PlanModel>
}