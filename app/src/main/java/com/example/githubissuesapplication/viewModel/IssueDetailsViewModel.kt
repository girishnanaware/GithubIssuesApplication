package com.example.githubissuesapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubissuesapplication.models.comments.Comments
import com.example.githubissuesapplication.repository.GitHubIssueRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IssueDetailsViewModel(
    private val repository: GitHubIssueRepository,
    private val url: String?
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCommentsList(url)
        }
    }

    val comments: LiveData<List<Comments>>
        get() = repository.commentsIssues

}