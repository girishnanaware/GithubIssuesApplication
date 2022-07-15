package com.example.githubissuesapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.githubissuesapplication.R
import com.example.githubissuesapplication.models.githubissues.GithubIssues
import com.example.githubissuesapplication.viewModel.HomeViewModel
import com.example.githubissuesapplication.viewModel.HomeViewModelFactory
import com.example.githubissuesapplication.viewModel.IssueDetailsViewModel
import com.example.githubissuesapplication.viewModel.IssueDetailsViewModelFactory
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_issue_details.*
import kotlinx.android.synthetic.main.activity_issue_details.recyclerView

class IssueDetailsActivity : AppCompatActivity() {

    private lateinit var issueDetailsViewModel: IssueDetailsViewModel
    private  lateinit var adapter: CommentsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issue_details)

        val repository = (application as GithubIssueApplication).gitHubIssueRepository

        val gson = Gson()
        val githubIssues = gson.fromJson(intent.getStringExtra("githubIssue"), GithubIssues::class.java)
        tvIssueDesc.setText(githubIssues.body)

        issueDetailsViewModel= ViewModelProvider(this, IssueDetailsViewModelFactory(repository,githubIssues.commentsUrl)).get(IssueDetailsViewModel::class.java)

        issueDetailsViewModel.comments.observe(this)
        {
            adapter=CommentsAdapter(this,it)
            recyclerView.adapter=adapter
        }
    }
}