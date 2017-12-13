package com.zuhaibahmad.githubapidemo;

import android.Manifest;
import android.app.Application;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;

import com.zuhaibahmad.githubapidemo.utils.Utils;

import java.util.Arrays;

/**
 * Created by Zuhaib Ahmad on 3/28/2017.
 * <p>
 * Custom application class to handle global application state
 */

@SuppressWarnings("unchecked")
public class GitHubApiDemo extends Application {

	static {
		AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		setupGlobalExceptionHandler();                              // Global exception handling
	}

	/**
	 * Sets up a global exception handler that logs the stacktrace to a log file
	 */
	private void setupGlobalExceptionHandler() {
		// Set up global exception handler
		Thread.setDefaultUncaughtExceptionHandler((thread, e) -> {
			if(Utils.hasPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
				Utils.appendLog(Log.getStackTraceString(e), Constants.LOG_FILE_NAME);
			}
			Log.e(Constants.TAG, "ERROR! " + e.toString(), e);
		});
	}

}
