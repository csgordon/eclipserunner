package com.eclipserunner.model;
import org.checkerframework.checker.guieffect.qual.*;
/**
 * Filter node indicate if an object provided to filter methods should be skipped
 *
 * @author vachacz
 */
public interface INodeFilter {

	boolean filter(ILaunchNode launchNode);
	boolean filter(ICategoryNode categoryNode);

}
