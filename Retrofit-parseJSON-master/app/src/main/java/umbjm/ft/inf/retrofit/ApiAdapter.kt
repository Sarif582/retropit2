package umbjm.ft.inf.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import umbjm.ft.inf.retrofit.data.ApiPublik
import umbjm.ft.inf.retrofit.data.ResultUsers


class ApiAdapter(val data: List<ApiPublik>?) : RecyclerView.Adapter<ApiAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_api, parent, false)
        return MyHolder(v)

    }
    override fun getItemCount(): Int = data?.size?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position))
    }


    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: ApiPublik?) {
            itemView.findViewById<TextView>(R.id.description).text = get?.description
            itemView.findViewById<TextView>(R.id.Category).text = get?.category
            itemView.findViewById<TextView>(R.id.Https).text = get?.hTTPS.toString()
            itemView.findViewById<TextView>(R.id.author).text=get?.auth
            itemView.findViewById<TextView>(R.id.Api).text=get?.aPI
            itemView.findViewById<TextView>(R.id.Cors).text=get?.cors
            itemView.findViewById<TextView>(R.id.Link).text=get?.link

        }

    }
}