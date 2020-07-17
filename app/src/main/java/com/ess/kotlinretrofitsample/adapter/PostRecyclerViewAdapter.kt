package com.ess.kotlinretrofitsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ess.kotlinretrofitsample.R
import com.ess.kotlinretrofitsample.model.PostModel
import kotlinx.android.synthetic.main.post_view_layout.view.*

class PostRecyclerViewAdapter(private val postList: ArrayList<PostModel>) : RecyclerView.Adapter<PostRecyclerViewAdapter.RowHolder>() {

    private val images: Array<String> = arrayOf("https://www.dreamofholiday.com/userFiles/bolgeler/950205793_1588435982.jpg",
        "https://www.costacruises.com/content/dam/costa/inventory-assets/ports/IST/ist-istanbul-port-2.jpg.image.750.563.low.jpg",
        "https://im.haberturk.com/2019/08/30/ver1567226646/2517777_810x458.jpg",
        "https://pix10.agoda.net/geo/city/14932/1_14932_02.jpg?s=1920x822,",
        "https://i2.milimaj.com/i/milliyet/75/750x0/5e99617855428118b85feb1f")

    class RowHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(postModel: PostModel){
            itemView.post_text_view.text = postModel.title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_view_layout,parent,false)

        return RowHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(postList[position])

        var imagePosition = position % 5

        holder.itemView.apply {
            Glide.with(this).load(images[imagePosition]).into(post_image_view)
        }
    }
}