package com.zuhaibahmad.githubapidemo.network;

import com.zuhaibahmad.githubapidemo.data.Contributor;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Zuhaib on 12/13/2017.
 */

public interface GitHubClient {

	@GET("/repos/{user}/{repo}/contributors?page={page}&?access_token=fff")
	Single<List<Contributor>> getRepo(
			@Path("user") String user,
			@Path("repo") String repo,
			@Path("page") String page
	);
}