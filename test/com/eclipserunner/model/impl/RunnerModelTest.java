package com.eclipserunner.model.impl;

import static com.eclipserunner.matchers.RunnerMatchers.anyLaunchConfigurationCotegory;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Set;

import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewSite;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.eclipserunner.model.ICategoryNode;
import com.eclipserunner.model.ILaunchNode;
import com.eclipserunner.model.IModelChangeListener;

public class RunnerModelTest {

	@Mock
	private IViewPart viewPartMock;

	@Mock
	private IViewSite viewSiteMock;

	@Mock
	private IModelChangeListener modelListenerMock;

	@Mock
	private ILaunchNode launchConfigurationMock;

	@Mock
	private ICategoryNode launchConfigurationCategoryMock;

	@Mock
	private Set<ICategoryNode> launchConfigurationSetMock;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);

		when(viewPartMock.getViewSite()).thenReturn(viewSiteMock);
		when(launchConfigurationSetMock.iterator()).thenReturn(new ArrayList<ICategoryNode>().iterator());
	}

	@Test
	public void testAddLaunchConfigurationCategory() {
		RunnerModel runnerModel = new RunnerModel();

		// setup
		runnerModel.addModelChangeListener(modelListenerMock);
		runnerModel.setLaunchConfigurationCategories(launchConfigurationSetMock);

		// test
		ICategoryNode testCategoryNode = new CategoryNode("test");
		runnerModel.addCategoryNode(testCategoryNode);

		verify(launchConfigurationSetMock).add(anyLaunchConfigurationCotegory());
		verify(modelListenerMock).modelChanged();
	}

	@Test
	public void testAddUncategorizedLaunchConfiguration() {
		RunnerModel runnerModel = new RunnerModel();

		// setup
		runnerModel.addModelChangeListener(modelListenerMock);
		runnerModel.setLaunchConfigurationCategories(launchConfigurationSetMock);

		// test
		runnerModel.addLaunchNode(launchConfigurationMock);

		verify(modelListenerMock).modelChanged();
	}

	@Test
	public void testRemoveLaunchConfiguration() {
		RunnerModel runnerModel = new RunnerModel();

		// setup
		runnerModel.addModelChangeListener(modelListenerMock);
		runnerModel.setLaunchConfigurationCategories(launchConfigurationSetMock);

		// test
		runnerModel.removeLaunchNode(launchConfigurationMock);

		verify(modelListenerMock).modelChanged();
	}

	@Test
	public void testRemoveLaunchConfigurationCategory() {
		RunnerModel runnerModel = new RunnerModel();

		// setup
		runnerModel.addModelChangeListener(modelListenerMock);
		runnerModel.setLaunchConfigurationCategories(launchConfigurationSetMock);

		// test
		runnerModel.removeCategoryNode(launchConfigurationCategoryMock);

		verify(launchConfigurationSetMock).remove(anyLaunchConfigurationCotegory());
		verify(modelListenerMock).modelChanged();
	}

}
