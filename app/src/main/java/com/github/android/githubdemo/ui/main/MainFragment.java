package com.github.android.githubdemo.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.github.android.githubdemo.App;
import com.github.android.githubdemo.R;
import com.github.android.githubdemo.model.RepoList;
import com.github.android.githubdemo.ui.adapter.RepoAdapter;
import com.github.android.githubdemo.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by wafa on 08/04/2017.
 */

public class MainFragment extends BaseFragment implements MainView {
    @Inject MainPresenter presenter;

    Button btnFetch;

    private RecyclerView rvRepos;
    public RecyclerView.LayoutManager layoutManager;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.component().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        btnFetch = (Button)view.findViewById(R.id.btnFetch);
        rvRepos = (RecyclerView) view.findViewById(R.id.rvRepos);

        layoutManager = new LinearLayoutManager(this.getContext());
        rvRepos.setLayoutManager(layoutManager);

        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchGitHubRepos();
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.setView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.setView(null);
    }


    void fetchGitHubRepos() {
        presenter.getGitHubRepos();
    }

    @Override
    public void populateReposView(@NonNull List<RepoList> repos) {
        RecyclerView.Adapter repoAdapter = new RepoAdapter(repos, this.getContext());
        rvRepos.setAdapter(repoAdapter);
    }

    @Override
    public void setError(String message) {
        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
    }
}
