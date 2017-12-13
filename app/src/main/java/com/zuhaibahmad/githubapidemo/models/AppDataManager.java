package com.zuhaibahmad.githubapidemo.models;

import com.zuhaibahmad.githubapidemo.data.Contributor;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Zuhaib on 12/13/2017.
 */

public class AppDataManager implements DataManager {

	@Override
	public Single<List<Contributor>> getContributors(String user, String repo){

	}

}
