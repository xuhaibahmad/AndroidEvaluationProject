package com.zuhaibahmad.githubapidemo.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Zuhaib on 12/13/2017.
 */

public class Contributor {
	@SerializedName("login")
	public String login;
	@SerializedName("id")
	public int id;
	@SerializedName("avatar_url")
	public String avatar_url;
	@SerializedName("gravatar_id")
	public String gravatar_id;
	@SerializedName("url")
	public String url;
	@SerializedName("html_url")
	public String html_url;
	@SerializedName("followers_url")
	public String followers_url;
	@SerializedName("following_url")
	public String following_url;
	@SerializedName("gists_url")
	public String gists_url;
	@SerializedName("starred_url")
	public String starred_url;
	@SerializedName("subscriptions_url")
	public String subscriptions_url;
	@SerializedName("organizations_url")
	public String organizations_url;
	@SerializedName("repos_url")
	public String repos_url;
	@SerializedName("events_url")
	public String events_url;
	@SerializedName("received_events_url")
	public String received_events_url;
	@SerializedName("type")
	public String type;
	@SerializedName("site_admin")
	public boolean site_admin;
	@SerializedName("contributions")
	public int contributions;

	public String getLogin() {
		return login;
	}

	public int getId() {
		return id;
	}

	public String getAvatarUrl() {
		return avatar_url;
	}

	public String getGravatarId() {
		return gravatar_id;
	}

	public String getUrl() {
		return url;
	}

	public String getHtmlUrl() {
		return html_url;
	}

	public String getFollowersUrl() {
		return followers_url;
	}

	public String getFollowingUrl() {
		return following_url;
	}

	public String getGistsUrl() {
		return gists_url;
	}

	public String getStarredUrl() {
		return starred_url;
	}

	public String getSubscriptionsUrl() {
		return subscriptions_url;
	}

	public String getOrganizationsUrl() {
		return organizations_url;
	}

	public String getReposUrl() {
		return repos_url;
	}

	public String getEventsUrl() {
		return events_url;
	}

	public String getReceivedEventsUrl() {
		return received_events_url;
	}

	public String getType() {
		return type;
	}

	public boolean isSiteAdmin() {
		return site_admin;
	}

	public int getContributions() {
		return contributions;
	}

	@Override
	public String toString() {
		return "Contributor{" +
		       "login='" + login + '\'' +
		       ", avatar_url='" + avatar_url + '\'' +
		       ", contributions=" + contributions +
		       '}';
	}
}
