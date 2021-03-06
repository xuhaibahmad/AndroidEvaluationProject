package com.zuhaibahmad.githubapidemo.usecases.main;

import com.zuhaibahmad.githubapidemo.BaseRobolectricTest;
import com.zuhaibahmad.githubapidemo.GitHubApiDemo;
import com.zuhaibahmad.githubapidemo.TestApplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.robolectric.RuntimeEnvironment;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by Zuhaib Ahmad on 3/31/2017.
 * <p>
 * Integration tests for Main Activity
 */
public class MainActivityRoboTest extends BaseRobolectricTest<MainActivity> {

	private ContractMain.View mView;
	private ContractMain.Presenter mPresenter;

	public MainActivityRoboTest() {
		super(MainActivity.class);
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();

		GitHubApiDemo app = (GitHubApiDemo) RuntimeEnvironment.application;

		mView = getActivity();
		mPresenter = mView.getPresenter();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void runtimeApplication_shouldBeTestApp() throws Exception {
		String actualName = RuntimeEnvironment.application.getClass().getName();
		String expectedName = TestApplication.class.getName();
		assertEquals(expectedName, actualName);
	}

	@Test
	public void testActivity_NotNull() {
		assertNotNull(getActivity());
		assertNotNull(mView);
		assertNotNull(mPresenter);
	}
}