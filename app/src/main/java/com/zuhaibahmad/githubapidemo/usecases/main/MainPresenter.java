package com.zuhaibahmad.githubapidemo.usecases.main;

import android.util.Log;

import com.zuhaibahmad.githubapidemo.Constants;
import com.zuhaibahmad.githubapidemo.GitHubApiDemo;
import com.zuhaibahmad.githubapidemo.R;
import com.zuhaibahmad.githubapidemo.models.AppDataManager;
import com.zuhaibahmad.githubapidemo.models.DataManager;

/**
 * Created by Zuhaib Ahmad on 3/31/2017.
 * <p>
 * Presenter for main activity
 */

public class MainPresenter implements ContractMain.Presenter {

	private final ContractMain.View view;
	private final MainActivity activity;
	private final DataManager dataManager;

	public MainPresenter(ContractMain.View view) {
		this.view = view;
		this.activity = (MainActivity) view;

		this.dataManager = AppDataManager.getInstance();
	}

	@Override
	public void start() {
		dataManager
				.getContributors("google", "protobuf")
				.subscribe(contributors -> Log.e(Constants.TAG, contributors.toString()));
	}

}
