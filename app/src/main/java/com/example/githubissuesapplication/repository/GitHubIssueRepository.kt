package com.example.githubissuesapplication.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.example.githubissuesapplication.api.NetworkServiceInterface
import com.example.githubissuesapplication.models.comments.Comments
import com.example.githubissuesapplication.models.githubissues.GithubIssues
import com.example.githubissuesapplication.utils.NetworkUtils

class GitHubIssueRepository(
    private val networkServiceInterface: NetworkServiceInterface,
    private val applicationContext: Context
) {

    private val githubIssuesLiveData = MutableLiveData<List<GithubIssues>>()

    val githubIssues: LiveData<List<GithubIssues>>
        get() = githubIssuesLiveData


    private val commentsLiveData = MutableLiveData<List<Comments>>()

    val commentsIssues: LiveData<List<Comments>>
        get() = commentsLiveData

    suspend fun getIssuesList() {
        if (NetworkUtils.isInternetAvailable(applicationContext)) {
            val result = networkServiceInterface.getGithubIssues()
            if (result.body() != null) {
                githubIssuesLiveData.postValue(result.body())
            }
        }
    }

    suspend fun getCommentsList(url:String?) {
        if (NetworkUtils.isInternetAvailable(applicationContext)) {
            val result = networkServiceInterface.getIssueComments(url)
            if (result.body() != null) {
                commentsLiveData.postValue(result.body())
            }
        }
    }
}