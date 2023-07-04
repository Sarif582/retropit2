package umbjm.ft.inf.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import umbjm.ft.inf.retrofit.data.AnimeQuotes




class AnimeAdapter(val data: List<AnimeQuotes>?) : RecyclerView.Adapter<AnimeAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_anime, parent, false)
        return MyHolder(v)

    }
    override fun getItemCount(): Int = data?.size?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position))
    }


    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: AnimeQuotes?) {
            itemView.findViewById<TextView>(R.id.character).text = get?.character
            itemView.findViewById<TextView>(R.id.anime).text = get?.anime
            itemView.findViewById<TextView>(R.id.quote).text = get?.quote

        }

    }
}