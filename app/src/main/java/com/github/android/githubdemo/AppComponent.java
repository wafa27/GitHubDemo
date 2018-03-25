package com.github.android.githubdemo;

import com.github.android.githubdemo.ui.PresenterModule;
import com.github.android.githubdemo.ui.main.MainFragment;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class, PresenterModule.class})
public interface AppComponent {
	void inject(MainFragment fragment);
}
