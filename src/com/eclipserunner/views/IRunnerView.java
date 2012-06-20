package com.eclipserunner.views;

import guitypes.checkers.quals.*;
public interface IRunnerView {

	public void refresh();
	@UIEffect public void setTreeMode(TreeMode mode);
	
}
