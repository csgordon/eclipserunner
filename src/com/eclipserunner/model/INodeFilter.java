package com.eclipserunner.model;
import guitypes.checkers.quals.*;
/**
 * Filter node indicate if an object provided to filter methods should be skipped
 *
 * @author vachacz
 */
public interface INodeFilter {

	boolean filter(ILaunchNode launchNode);
	boolean filter(ICategoryNode categoryNode);

}
