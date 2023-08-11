package mimbluassignmentbyamit.example.mimbluassignment.Symptoms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mimbluassignmentbyamit.example.mimbluassignment.R
import mimbluassignmentbyamit.example.mimbluassignment.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SymptomsActivity : AppCompatActivity() {
    lateinit var recyclerview: RecyclerView
    lateinit var buttonSubmit: Button

    var arrList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptoms)
        recyclerview = findViewById<RecyclerView>(R.id.symptoms_list_layout)
        buttonSubmit = findViewById<Button>(R.id.symptoms_select_button)
        recyclerview.layoutManager = LinearLayoutManager(applicationContext)


        apiCallandFetch()
        buttonSubmit.setOnClickListener {
            var intent = Intent(this, DummyActivity::class.java)
            intent.putExtra("key",arrList)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
    }

    private fun apiCallandFetch(){

        val destinationService  = ServiceBuilder.buildService(ApiService::class.java)
        val requestCallLeetCode =destinationService.getApiResponse()
        //make network call asynchronously
        requestCallLeetCode.enqueue(object : Callback<SymptomsMode>{
            override fun onResponse(call: Call<SymptomsMode>, response: Response<SymptomsMode>) {
                if (response.isSuccessful){
                    val symptomsList  = response.body()!!

                    var contestOnly = symptomsList.list

                    recyclerview.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(applicationContext)
                        adapter = SymptomsAdapter(applicationContext,contestOnly,arrList,buttonSubmit)
                    }

                }else{
                    Toast.makeText(applicationContext, "Response Get Failed", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<SymptomsMode>, t: Throwable) {
                Toast.makeText(applicationContext, "Failure + ${t.toString()}", Toast.LENGTH_SHORT).show()
            }
        })

    }

}