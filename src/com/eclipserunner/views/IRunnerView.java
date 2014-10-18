package com.eclipserunner.views;

import org.checkerframework.checker.guieffect.qual.*;
public interface IRunnerView {

	public void refresh();
	@UIEffect public void setTreeMode(TreeMode mode);
	
}
