package com.github.android.githubdemo.ui.main;

import android.support.annotation.NonNull;

import com.github.android.githubdemo.model.RepoList;

import java.util.List;

/**
 * Created by wafa on 08/04/2017.
 */

interface MainView {
    void populateReposView(@NonNull List<RepoList> repos);

    void setError(String message);
}
