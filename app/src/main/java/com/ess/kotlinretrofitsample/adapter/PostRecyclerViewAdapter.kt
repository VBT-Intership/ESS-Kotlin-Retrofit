package com.ess.kotlinretrofitsample.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ess.kotlinretrofitsample.model.PostModel

class PostRecyclerViewAdapter(private val postList: ArrayList<PostModel>) : RecyclerView.Adapter<PostRecyclerViewAdapter.RowHolder>() {

    class RowHolder(view: View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return postList.count()
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        TODO("Not yet implemented")
    }
}