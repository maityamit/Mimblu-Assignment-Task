package mimbluassignmentbyamit.example.mimbluassignment.Symptoms

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mimbluassignmentbyamit.example.mimbluassignment.R


class SymptomsAdapter(private val context: Context, private val mList: List<SymptomsListModel>,var arrList : ArrayList<Int>,var buttonSubmit:Button) : RecyclerView.Adapter<SymptomsAdapter.ViewHolder>() {

    // create new views



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.symptoms_layout_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val symptomsClass = mList[position]

        holder.titleName.text = symptomsClass.title

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) arrList.add(symptomsClass.id)
            else arrList.remove(symptomsClass.id)

            if(arrList.size>0){
                buttonSubmit.isEnabled = true
                buttonSubmit.alpha = 1F
            }else{
                buttonSubmit.isEnabled = false
                buttonSubmit.alpha = 0.5F
            }

        }


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val titleName: TextView = itemView.findViewById(R.id.symptomsNametext)
        val checkBox: CheckBox = itemView.findViewById(R.id.symptomsCheckBox)
    }


}