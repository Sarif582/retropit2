package umbjm.ft.inf.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import umbjm.ft.inf.retrofit.data.ResultUsers


class UsersAdapter(val data: List<ResultUsers>?) : RecyclerView.Adapter<UsersAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return MyHolder(v)

    }
    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position))
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: ResultUsers?) {
            itemView.findViewById<TextView>(R.id.nama).text = get?.name
            itemView.findViewById<TextView>(R.id.email).text = get?.email
            itemView.findViewById<TextView>(R.id.notelp).text = get?.phone

            val address =
                "${get?.address?.street}, ${get?.address?.city}, ${get?.address?.suite}, ${get?.address?.zipcode}"
            itemView.findViewById<TextView>(R.id.alamat).text = address
        }

    }
}