package com.github.android.githubdemo.api;

import android.support.annotation.NonNull;

import com.github.android.githubdemo.model.RepoList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by wafa on 08/04/2017.
 */

public class ApiHelper {

    @NonNull
    private final GitHubAPI client;

    public ApiHelper(@NonNull GitHubAPI client) {
        this.client = client;
    }


    public void getGitHubRepos(Callback<List<RepoList>> gitHubReposCallBack) {
        Call<List<RepoList>> call = client.fetchRepos();
        call.enqueue(gitHubReposCallBack);

    }
}
