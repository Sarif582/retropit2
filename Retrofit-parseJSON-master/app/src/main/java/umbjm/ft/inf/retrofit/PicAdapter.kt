package umbjm.ft.inf.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import umbjm.ft.inf.retrofit.data.PicsumPhotos


class PicAdapter(val data: List<PicsumPhotos>?) : RecyclerView.Adapter<PicAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_pic, parent, false)
        return MyHolder(v)

    }
    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position))
    }


    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: PicsumPhotos?) {
            itemView.findViewById<TextView>(R.id.author).text = get?.author
            itemView.findViewById<TextView>(R.id.width).text = get?.width.toString()
            itemView.findViewById<TextView>(R.id.height).text = get?.height.toString()
            itemView.findViewById<TextView>(R.id.url).text = get?.url
            itemView.findViewById<TextView>(R.id.download_url).text = get?.downloadUrl

        }

    }
}