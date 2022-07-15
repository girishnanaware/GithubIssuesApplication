package com.example.githubissuesapplication.api

import com.example.githubissuesapplication.models.comments.Comments
import com.example.githubissuesapplication.models.githubissues.GithubIssues
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface NetworkServiceInterface {

    @GET("/repos/square/okhttp/issues")
    suspend fun getGithubIssues() : Response<List<GithubIssues>>

    @GET
    suspend fun getIssueComments(@Url url:String?) : Response<List<Comments>>
}