package com.zuhaibahmad.githubapidemo.usecases.main;

import com.zuhaibahmad.githubapidemo.R;
import com.zuhaibahmad.githubapidemo.data.Contributor;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ContractMain.View {

	// @formatter:off
	@BindView(R.id.toolbar)				Toolbar 				toolbar;
	@BindView(R.id.container)			CoordinatorLayout 		container;
	@BindView(R.id.list)			    RecyclerView            contributorsList;
	@BindView(R.id.progress)            ProgressBar             progressBar;
	// @formatter:on

	private ContractMain.Presenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		presenter = new MainPresenter(this);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		setSupportActionBar(toolbar);

		setupUi();
	}

	private void setupUi() {
		contributorsList.setHasFixedSize(true);
		LinearLayoutManager layoutManager = new LinearLayoutManager(this);
		layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		contributorsList.setLayoutManager(layoutManager);
		contributorsList.setAdapter(presenter.getAdapter());
	}

	@Override
	public void displayProgress(boolean show) {
		progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
	}

	@Override
	protected void onResume() {
		super.onResume();
		presenter.start();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		presenter.cleanUp();
	}

	@Override
	public void displayMessage(String text) {
		Snackbar.make(container, text, Snackbar.LENGTH_LONG).show();
	}

	@Override
	public void setPresenter(ContractMain.Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public ContractMain.Presenter getPresenter() {
		return presenter;
	}
}
