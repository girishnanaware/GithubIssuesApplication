package com.example.githubissuesapplication.ui

import android.app.Application
import com.example.githubissuesapplication.api.NetworkService
import com.example.githubissuesapplication.api.NetworkServiceInterface
import com.example.githubissuesapplication.repository.GitHubIssueRepository

class GithubIssueApplication : Application() {

    lateinit var gitHubIssueRepository: GitHubIssueRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val gitHubIssueService = NetworkService.getInstance().create(NetworkServiceInterface::class.java)
        gitHubIssueRepository = GitHubIssueRepository(gitHubIssueService, applicationContext)
    }
}