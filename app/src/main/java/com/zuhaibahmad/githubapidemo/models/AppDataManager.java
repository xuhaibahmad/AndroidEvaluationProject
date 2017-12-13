package com.zuhaibahmad.githubapidemo.models;

import com.zuhaibahmad.githubapidemo.Constants;
import com.zuhaibahmad.githubapidemo.data.Contributor;
import com.zuhaibahmad.githubapidemo.network.GitHubClient;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zuhaib on 12/13/2017.
 */

public class AppDataManager implements DataManager {

	private static AppDataManager INSTANCE;
	private final GitHubClient apiClient;

	public static AppDataManager getInstance() {
		if (INSTANCE == null) INSTANCE = new AppDataManager();
		return INSTANCE;
	}

	private AppDataManager() {
		apiClient = new Retrofit.Builder()
				.baseUrl(Constants.API_BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.client(new OkHttpClient.Builder().build())
				.build()
				.create(GitHubClient.class);
	}

	@Override
	public Single<List<Contributor>> getContributors(String user, String repo) {
		return apiClient
				.getRepo(user, repo)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread());
	}

}
