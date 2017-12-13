package com.zuhaibahmad.template;

import android.Manifest;

/**
 * Created by Zuhaib Ahmad on 3/28/2017.
 * <p>
 * Constants used throughout application
 */

@SuppressWarnings({"WeakerAccess", "ArraysAsListWithZeroOrOneArgument", "unused"})
public final class Constants {

	// @formatter:off
	public static final String TAG 								= GitHubApiDemo.class.getSimpleName();
	public static final String PREFERENCES_NAME					= TAG + ".prefs";
	public static final String LOG_FILE_NAME                    = TAG + "-Log.txt";
	public static final String DIRECTORY_NAME                   = TAG + " Log";

	public static final String API_ENDPOINT						= "https://api.github.com";
	public static final String REPO_ENDPOINT					= "/repos/google/protobuf/";
	public static final String CONTRIBUTORS_ENDPOINT			= "contributors?page=1&?access_token=fff";

	// List of permissions required for this app
	public static final String[] PERMISSIONS = {
			Manifest.permission.INTERNET
	};

	public static final int REQUEST_PERMISSION_ALL				= 0;
	// @formatter:on

	private Constants() {
		// Exists only to defeat instantiation
	}
}
