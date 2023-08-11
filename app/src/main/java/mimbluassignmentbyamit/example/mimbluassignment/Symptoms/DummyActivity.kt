package mimbluassignmentbyamit.example.mimbluassignment.Symptoms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import mimbluassignmentbyamit.example.mimbluassignment.R

class DummyActivity : AppCompatActivity() {
    lateinit var textView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dummy)
        textView = findViewById<TextView>(R.id.selected_ids)
        val extras = intent.extras
        var arrList = extras?.getIntegerArrayList("key")
        var str:String=""
        for(ele in arrList!!){
            str+=(ele.toString())
            str+=" "
        }
        textView.text = "[ $str ]"
    }
}