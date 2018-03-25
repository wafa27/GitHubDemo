package com.github.android.githubdemo.ui.main;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.android.githubdemo.api.ApiHelper;
import com.github.android.githubdemo.model.RepoList;
import com.github.android.githubdemo.ui.base.Presenter;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wafa on 08/04/2017.
 */

public class MainPresenter implements Presenter<MainView> {

    @Nullable private MainView view;
    private ApiHelper apiHelper;

    @Inject
    public MainPresenter(@NonNull ApiHelper apiHelper){
        this.apiHelper = apiHelper;
    }


    @Override
    public void setView(@Nullable MainView view) {
        this.view = view;
    }

    void getGitHubRepos() {
        apiHelper.getGitHubRepos(new GitHubReposCallBack());
    }

    private class GitHubReposCallBack implements Callback<List<RepoList>>  {
        @Override
        public void onResponse(Call<List<RepoList>> call, Response<List<RepoList>> response) {
            List<RepoList> listRepos = response.body();

            if (!listRepos.isEmpty()) {
                if (view != null) {
                    view.populateReposView(listRepos);
                }
            }
    }

        @Override
        public void onFailure(Call<List<RepoList>> call, Throwable t) {
            if (view != null) {
                view.setError(t.getMessage());
            }
        }
    }
}
