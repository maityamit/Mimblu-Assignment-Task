package mimbluassignmentbyamit.example.mimbluassignment.Price

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mimbluassignmentbyamit.example.mimbluassignment.R
import mimbluassignmentbyamit.example.mimbluassignment.Symptoms.SymptomsListModel

class PlanAdapter(private val context: Context, private val mList: List<PlanListModel>) : RecyclerView.Adapter<PlanAdapter.ViewHolder>() {

    // create new views


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.plan_layout, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val symptomsClass = mList[position]

        holder.plan_days.text = "${symptomsClass.duration} Days"

        holder.plan_curr.text = symptomsClass.currency_code
        holder.plan_discounted.text = symptomsClass.discounted_price
        holder.plan_total.text = symptomsClass.total_price

        holder.plan_discounted.paintFlags = holder.plan_discounted.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG


        val index = symptomsClass.description.indexOf('\n')
        val result = if (index != -1) {
            symptomsClass.description.substring(0, index)
        } else {
            symptomsClass.description
        }

        val index2 = symptomsClass.video_description.indexOf('\n')
        val result2 = if (index2 != -1) {
            symptomsClass.video_description.substring(0, index2)
        } else {
            symptomsClass.video_description
        }

        holder.plan_voice.text = result
        holder.plan_desc.text = result2

        val intA = symptomsClass.discounted_price.toInt()
        val intB = symptomsClass.total_price.toInt()
        val subStraction = intA - intB

        holder.plan_offer.text = subStraction.toString()



    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val plan_days: TextView = itemView.findViewById(R.id.plan_days)
        val plan_voice: TextView = itemView.findViewById(R.id.plan_voice)
        val plan_desc: TextView = itemView.findViewById(R.id.plan_desc)
        val plan_curr: TextView = itemView.findViewById(R.id.plan_curr)
        val plan_discounted: TextView = itemView.findViewById(R.id.plan_discounted)
        val plan_total: TextView = itemView.findViewById(R.id.plan_total)
        val plan_offer: TextView = itemView.findViewById(R.id.plan_offer)
    }


}