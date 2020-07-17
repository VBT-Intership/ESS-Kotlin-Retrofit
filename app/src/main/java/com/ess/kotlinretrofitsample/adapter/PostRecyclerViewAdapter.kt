package com.ess.kotlinretrofitsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ess.kotlinretrofitsample.R
import com.ess.kotlinretrofitsample.model.PostModel
import kotlinx.android.synthetic.main.post_view_layout.view.*

class PostRecyclerViewAdapter(private val postList: ArrayList<PostModel>) : RecyclerView.Adapter<PostRecyclerViewAdapter.RowHolder>() {

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
    }
}