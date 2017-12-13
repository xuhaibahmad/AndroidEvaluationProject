package com.zuhaibahmad.githubapidemo.usecases.main;

import com.zuhaibahmad.githubapidemo.GitHubApiDemo;
import com.zuhaibahmad.githubapidemo.R;

/**
 * Created by Zuhaib Ahmad on 3/31/2017.
 * <p>
 * Presenter for main activity
 */

public class MainPresenter implements ContractMain.Presenter {

	private final ContractMain.View mView;
	private final MainActivity mActivity;
	private final GitHubApiDemo mApplication;

	public MainPresenter(ContractMain.View view) {
		mView = view;
		mActivity = (MainActivity) mView;

		mApplication = (GitHubApiDemo) mActivity.getApplicationContext();
	}

	@Override
	public void start() {
		GitHubApiDemo.checkPermissions(mActivity);
	}

	@Override
	public void onAction() {
		mView.displayMessage(mActivity.getString(R.string.placeholder_action_message));
	}

}
