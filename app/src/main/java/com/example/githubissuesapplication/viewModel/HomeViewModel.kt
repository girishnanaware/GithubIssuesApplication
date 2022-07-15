package com.example.githubissuesapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubissuesapplication.models.githubissues.GithubIssues
import com.example.githubissuesapplication.repository.GitHubIssueRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: GitHubIssueRepository):ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getIssuesList()
        }
    }

    val githubIssues: LiveData<List<GithubIssues>>
        get() = repository.githubIssues

}