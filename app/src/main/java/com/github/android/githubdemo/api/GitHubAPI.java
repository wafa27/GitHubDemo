package com.github.android.githubdemo.api;

import com.github.android.githubdemo.model.RepoList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by wafan on 8/21/2016.
 */

public interface GitHubAPI {
    public static String BASE_URL = "https://api.github.com";

    @GET("/repositories")
    Call<List<RepoList>> fetchRepos();
}
