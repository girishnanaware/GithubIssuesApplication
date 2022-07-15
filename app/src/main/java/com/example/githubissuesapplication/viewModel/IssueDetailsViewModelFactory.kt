package com.example.githubissuesapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubissuesapplication.repository.GitHubIssueRepository

class IssueDetailsViewModelFactory(private val repository: GitHubIssueRepository,private val url: String?):
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return IssueDetailsViewModel(repository,url) as T
    }
}