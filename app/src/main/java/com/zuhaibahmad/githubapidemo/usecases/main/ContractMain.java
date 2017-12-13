package com.zuhaibahmad.githubapidemo.usecases.main;

import com.zuhaibahmad.githubapidemo.data.Contributor;
import com.zuhaibahmad.githubapidemo.usecases.BasePresenter;
import com.zuhaibahmad.githubapidemo.usecases.BaseView;
import com.zuhaibahmad.githubapidemo.utils.ContributorsAdapter;

import java.util.List;

/**
 * Created by Zuhaib Ahmad on 3/31/2017.
 * <p>
 * Contract for main activity and its presenter
 */

public interface ContractMain {
	interface View extends BaseView<Presenter> {
		void displayMessage(String text);
		void displayProgress(boolean show);
	}

	interface Presenter extends BasePresenter {
		ContributorsAdapter getAdapter();

		void cleanUp();
	}
}
