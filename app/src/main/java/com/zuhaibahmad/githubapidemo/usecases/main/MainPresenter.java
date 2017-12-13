package com.zuhaibahmad.githubapidemo.usecases.main;

import android.util.Log;

import com.zuhaibahmad.githubapidemo.Constants;
import com.zuhaibahmad.githubapidemo.R;
import com.zuhaibahmad.githubapidemo.data.Contributor;
import com.zuhaibahmad.githubapidemo.models.AppDataManager;
import com.zuhaibahmad.githubapidemo.models.DataManager;
import com.zuhaibahmad.githubapidemo.utils.ContributorsAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Zuhaib Ahmad on 3/31/2017.
 * <p>
 * Presenter for main activity
 */

public class MainPresenter implements ContractMain.Presenter {

	private final ContractMain.View view;
	private final MainActivity activity;
	private final DataManager dataManager;

	private final ContributorsAdapter adapter;
	private final List<Contributor> contributors = new ArrayList<>();

	private final CompositeDisposable disposables = new CompositeDisposable();

	public MainPresenter(ContractMain.View view) {
		this.view = view;
		this.activity = (MainActivity) view;

		this.adapter = new ContributorsAdapter(contributors);
		this.dataManager = AppDataManager.getInstance();
	}

	@Override
	public void start() {
		disposables.add(dataManager
				.getContributors("google", "protobuf")
				.doOnSubscribe(disposable -> view.displayProgress(true))
				.doOnEvent((c, t) -> view.displayProgress(false))
				.doOnError(throwable -> view.displayMessage(activity.getString(R.string.error_msg)))
				.subscribe(contributors -> updateData(contributors)));
	}

	private void updateData(List<Contributor> contributors) {
		Log.e(Constants.TAG, "Contributors: " + contributors.toString());
		this.contributors.clear();
		this.contributors.addAll(contributors);
		this.adapter.notifyDataSetChanged();
	}

	@Override
	public ContributorsAdapter getAdapter() {
		return adapter;
	}

	@Override
	public void cleanUp(){
		disposables.clear();
	}
}
