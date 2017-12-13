package com.zuhaibahmad.githubapidemo.models;

import com.zuhaibahmad.githubapidemo.data.Contributor;

/**
 * Created by Zuhaib on 12/13/2017.
 */

public interface DataManager {
	public Single<List<Contributor>> getContributors(String user, String repo);
}
