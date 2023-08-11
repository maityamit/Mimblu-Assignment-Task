package mimbluassignmentbyamit.example.mimbluassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import mimbluassignmentbyamit.example.mimbluassignment.Price.PlanActivity
import mimbluassignmentbyamit.example.mimbluassignment.Symptoms.SymptomsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.page_01).setOnClickListener {
            startActivity(Intent(this, SymptomsActivity::class.java))
        }
        findViewById<TextView>(R.id.page_02).setOnClickListener {
            startActivity(Intent(this, PlanActivity::class.java))
        }

    }
}