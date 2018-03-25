package com.github.android.githubdemo.ui;


import android.support.annotation.NonNull;

import com.github.android.githubdemo.api.ApiHelper;
import com.github.android.githubdemo.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

	@Provides
	public MainPresenter provideMainPresenter(@NonNull ApiHelper apiHelper) {
		return new MainPresenter(apiHelper);
	}
}
