package com.eclipserunner.views.actions;

import org.checkerframework.checker.guieffect.qual.*;
/**
 * @author tonyq
 */
@UIType
public class ToggleRunModeAction extends BaseRunnerAction {

	private final String preferenceProperty;

	public ToggleRunModeAction(String preferenceProperty) {
		this.preferenceProperty = preferenceProperty;
		boolean active = getPreferenceStore().getBoolean(preferenceProperty);
		setChecked(active);
	}

	@Override
	public void run() {
		getPreferenceStore().setValue(preferenceProperty, isChecked());
	}

}
