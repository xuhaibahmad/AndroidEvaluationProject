package com.zuhaibahmad.githubapidemo.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zuhaibahmad.githubapidemo.R;
import com.zuhaibahmad.githubapidemo.data.Contributor;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zuhaib on 12/13/2017.
 */

public class ContributorsAdapter extends RecyclerView.Adapter<ContributorsAdapter.ViewHolder>{


	private final List<Contributor> items;

	private Context mContext;

	public ContributorsAdapter(List<Contributor> items) {
		this.items = items;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		this.mContext = parent.getContext();
		View view = LayoutInflater.from(mContext).inflate(R.layout.contributor_item, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {

		final Contributor r = items.get(position);

		// Add image URL
		Picasso.with(mContext)
				.load(r.avatar_url)
				.fit()
				.centerCrop()
				.into(holder.avatarImageView);
		holder.nameTextView.setText(getTextOrEmpty(r.login));
		holder.commitsTextView.setText(getTextOrEmpty(String.valueOf(r.contributions)));

	}

	@NonNull
	private String getTextOrEmpty(String text) {
		return TextUtils.isEmpty(text) ? "-" : text;
	}

	@Override
	public int getItemCount() {
		return items.size();
	}

	class ViewHolder extends RecyclerView.ViewHolder {

		// @formatter:off
		@BindView(R.id.avatar)					ImageView 		avatarImageView;
		@BindView(R.id.name)					TextView 		nameTextView;
		@BindView(R.id.commits)				TextView 		commitsTextView;
		// @formatter:on

		ViewHolder(View view) {
			super(view);
			ButterKnife.bind(this, view);
		}
	}

}
