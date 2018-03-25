package com.github.android.githubdemo;

import com.github.android.githubdemo.api.ApiModule;
import com.github.android.githubdemo.ui.PresenterModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module(includes = {ApiModule.class, PresenterModule.class})
public class AppModule {

	private final App app;

	public AppModule(App app) {
		this.app = app;
	}

	@Provides
	@Singleton
	public App provideApp() {
		return app;
	}

}

