package com.eclipserunner.views.actions;
import guitypes.checkers.quals.*;

/**
 * Abstract action depending on launch group id
 * 
 * @author vachacz
 */
@UIType public abstract class AbstractLaunchAction extends BaseRunnerAction {

	private String launchGroupId;

	public AbstractLaunchAction(String launchGroupId) {
		this.launchGroupId = launchGroupId;
	}

	public String getLaunchGroupId() {
		return this.launchGroupId;
	}

}
