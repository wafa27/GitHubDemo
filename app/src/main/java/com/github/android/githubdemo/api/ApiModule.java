package com.github.android.githubdemo.api;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.github.android.githubdemo.api.GitHubAPI.BASE_URL;

@Module
public class ApiModule {

	@NonNull
	protected Retrofit getRetrofit(@NonNull String baseUrl, @NonNull OkHttpClient okHttpClient) {
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
				.create();

		return new Retrofit.Builder().baseUrl(baseUrl)
									 .client(okHttpClient)
									 .addConverterFactory(GsonConverterFactory.create(gson))
									 .build();
	}

	@Provides
	@NonNull
	public ApiHelper provideApiHelper(@NonNull GitHubAPI client) {
		return new ApiHelper(client);
	}

	@Provides
	@Singleton
	@NonNull
	public OkHttpClient provideOkHttpClient() {
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
		return builder.build();
	}

	@Provides
	@Singleton
	@NonNull
	public Retrofit provideRetrofit(@NonNull OkHttpClient okHttpClient) {
		return getRetrofit(BASE_URL, okHttpClient);
	}

	@Provides
	@Singleton
	@NonNull
	public GitHubAPI provideClient(@NonNull Retrofit retrofit) {
		return retrofit.create(GitHubAPI.class);
	}
}
