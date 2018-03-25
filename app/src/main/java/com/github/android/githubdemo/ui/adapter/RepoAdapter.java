package com.github.android.githubdemo.ui.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.android.githubdemo.R;
import com.github.android.githubdemo.model.RepoList;

import java.util.List;

/**
 * Created by wafa on 24.03.18.
 */

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {

    private List<RepoList> repoList;
    private Context context;


    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgRepoOwner;
        TextView repoName;
        ConstraintLayout parentLayout;

        ViewHolder(View v) {
            super(v);
            imgRepoOwner = (ImageView) v.findViewById(R.id.imgRepoOwner);
            repoName = (TextView) v.findViewById(R.id.tvRepoName);
            parentLayout = (ConstraintLayout) v.findViewById(R.id.parentLayout);
        }
    }


    public RepoAdapter(List<RepoList> repoList , Context context) {
        this.repoList = repoList;
        this.context = context;
    }


    @Override
    public RepoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_repository, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.repoName.setText(repoList.get(position).getFullName());

        Glide.with(context).load(repoList.get(position).getOwner().getAvatarUrl()).into(holder.imgRepoOwner);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,repoList.get(holder.getAdapterPosition()).getDescription(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }
}
