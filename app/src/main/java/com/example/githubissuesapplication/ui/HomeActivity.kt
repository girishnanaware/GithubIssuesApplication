package com.example.githubissuesapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.githubissuesapplication.R
import com.example.githubissuesapplication.viewModel.HomeViewModel
import com.example.githubissuesapplication.viewModel.HomeViewModelFactory
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var homeViewModel:HomeViewModel
    private  lateinit var adapter: IssuesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val repository = (application as GithubIssueApplication).gitHubIssueRepository

        homeViewModel=ViewModelProvider(this,HomeViewModelFactory(repository)).get(HomeViewModel::class.java)

        homeViewModel.githubIssues.observe(this) {
            adapter=IssuesAdapter(this,it)
            recyclerView.adapter=adapter
        }
    }
}