package com.github.android.githubdemo;

import android.app.Application;

public class App extends Application {

	private static AppComponent appComponent;

	public static AppComponent component() {
		return appComponent;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		appComponent = DaggerAppComponent.builder()
										 .appModule(new AppModule(this))
										 .build();
	}

}

