package com.eclipserunner.views.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;

import guitypes.checkers.quals.*;
/**
 * @author vachacz
 */
@UIType
public class CollapseAllAction extends Action {

	private TreeViewer viewer;

	public CollapseAllAction(TreeViewer viewer) {
		this.viewer = viewer;
	}

	@Override
	public void run() {
		viewer.collapseAll();
	}
}
