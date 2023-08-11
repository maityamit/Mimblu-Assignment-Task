package mimbluassignmentbyamit.example.mimbluassignment.Price

import android.media.Image.Plane
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mimbluassignmentbyamit.example.mimbluassignment.R
import mimbluassignmentbyamit.example.mimbluassignment.ServiceBuilder
import mimbluassignmentbyamit.example.mimbluassignment.Symptoms.ApiService
import mimbluassignmentbyamit.example.mimbluassignment.Symptoms.SymptomsAdapter
import mimbluassignmentbyamit.example.mimbluassignment.Symptoms.SymptomsMode
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanActivity : AppCompatActivity() {
    lateinit var recyclerview: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan)

        recyclerview = findViewById<RecyclerView>(R.id.plan_recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
        apiCallandFetch()
    }

    private fun apiCallandFetch(){

        val destinationService  = ServiceBuilder.buildService(PlanAPIService::class.java)
        val requestCallLeetCode =destinationService.getApiResponse()
        //make network call asynchronously
        requestCallLeetCode.enqueue(object : Callback<PlanModel> {
            override fun onResponse(call: Call<PlanModel>, response: Response<PlanModel>) {
                if (response.isSuccessful){
                    val symptomsList  = response.body()!!
                    var contestOnly = symptomsList.list

                    recyclerview.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.HORIZONTAL,false)
                        adapter = PlanAdapter(applicationContext,contestOnly)
                    }

                }else{
                    Toast.makeText(applicationContext, "Response Get Failed", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<PlanModel>, t: Throwable) {
                Toast.makeText(applicationContext, "Failure + ${t.toString()}", Toast.LENGTH_SHORT).show()
            }
        })

    }

}