package mimbluassignmentbyamit.example.mimbluassignment.Price


data class PlanModel(
    val copyrighths: String,
    val list: ArrayList<PlanListModel>
)

class PlanListModel(
    var duration: String,
    var description: String,
    var video_description: String,
    var currency_code: String,
    var total_price: String,
    var discounted_price: String
)