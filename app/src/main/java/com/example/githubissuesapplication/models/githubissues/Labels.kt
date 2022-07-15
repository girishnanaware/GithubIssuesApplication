package com.example.githubissuesapplication.models.githubissues

import com.google.gson.annotations.SerializedName


data class Labels (

  @SerializedName("id"          ) var id          : Double?     = null,
  @SerializedName("node_id"     ) var nodeId      : String?  = null,
  @SerializedName("url"         ) var url         : String?  = null,
  @SerializedName("name"        ) var name        : String?  = null,
  @SerializedName("color"       ) var color       : String?  = null,
  @SerializedName("default"     ) var default     : Boolean? = null,
  @SerializedName("description" ) var description : String?  = null

)