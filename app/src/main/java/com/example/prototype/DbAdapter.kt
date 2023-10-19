package com.example.prototype
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DbAdapter(var list:ArrayList<FirebaseData>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.row_language,parent, false )

        return itemHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as itemHolder).bind(list[position].country!!,list[position].language!!,list[position].no!!.toInt())

    }
    class itemHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind( country:String, language:String,no:Int)
        {

            val txtid: TextView = itemView.findViewById(R.id.view1)
            val txtcountry: TextView = itemView.findViewById(R.id.country)
            val txtlng: TextView = itemView.findViewById(R.id.langView)

            txtid.text = no.toString()
            txtcountry.text = country
            txtlng.text = language
        }
    }
}