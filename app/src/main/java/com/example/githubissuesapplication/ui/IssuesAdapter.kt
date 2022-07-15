package com.example.githubissuesapplication.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubissuesapplication.databinding.IssueListItemBinding
import com.example.githubissuesapplication.models.githubissues.GithubIssues
import com.example.githubissuesapplication.viewModel.HomeViewModel
import com.google.gson.Gson


class IssuesAdapter(
    private val context: Context,
    private val githubIssuesList: List<GithubIssues>
) : RecyclerView.Adapter<IssuesAdapter.IssueViewHolder>() {

    private lateinit var binding: IssueListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        binding = IssueListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IssueViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        val githubIssue = githubIssuesList[position]
        holder.itemView.setOnClickListener{
            var intent=Intent(context,IssueDetailsActivity::class.java)
            val gson = Gson()
            val githubIssueJson = gson.toJson(githubIssue)
            intent.putExtra("githubIssue",githubIssueJson);
            context.startActivity(intent)
        }
        holder.bind(githubIssue)
    }

    override fun getItemCount(): Int {
        return githubIssuesList.size
    }

    inner class IssueViewHolder(
        private val binding: IssueListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(githubIssues: GithubIssues) {
            binding.githubIssue = githubIssues
        }
    }
}