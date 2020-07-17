package com.ess.kotlinretrofitsample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ess.kotlinretrofitsample.R
import com.ess.kotlinretrofitsample.adapter.PostRecyclerViewAdapter
import com.ess.kotlinretrofitsample.model.PostModel
import com.ess.kotlinretrofitsample.services.PostAPI
import com.ess.kotlinretrofitsample.utils.Constants
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private var postModels : ArrayList<PostModel>? = null
    private var postRecyclerViewAdapter: PostRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        loadData()
    }

    private fun loadData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(PostAPI::class.java)
        val call = service.getPosts()

        call.enqueue(object : Callback<List<PostModel>> {
            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                if(response.isSuccessful){
                    response.body()?.let {
                        postModels = ArrayList(it)

                        postModels?.let {
                            postRecyclerViewAdapter = PostRecyclerViewAdapter(it)
                            recyclerView.adapter = postRecyclerViewAdapter
                        }
                    }
                }
            }

        })
    }
}