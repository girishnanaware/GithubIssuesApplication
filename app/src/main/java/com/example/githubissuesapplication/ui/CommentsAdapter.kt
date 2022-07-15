package com.example.githubissuesapplication.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.githubissuesapplication.R
import com.example.githubissuesapplication.models.comments.Comments

class CommentsAdapter(private val context: Context,
                      private val commentsList: List<Comments>):
    RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.issue_details_list_item, parent, false)
        return CommentsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        val comments = commentsList[position]
        holder.tvComments.text=comments.body
    }

    override fun getItemCount(): Int {
        return commentsList.size
    }

    inner class CommentsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        val tvComments = itemView.findViewById<TextView>(R.id.tvComments)!!
    }
}