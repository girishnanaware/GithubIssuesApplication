package com.example.githubissuesapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubissuesapplication.repository.GitHubIssueRepository

class HomeViewModelFactory(private val repository: GitHubIssueRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}