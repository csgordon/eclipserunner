package com.eclipserunner.model;

import java.util.List;

import org.checkerframework.checker.guieffect.qual.*;
/**
 * @author vachacz
 */
@UIType public interface INodeSelection {

	boolean allNodesHaveSameType();
	boolean hasExactlyOneNode();

	boolean firstNodeHasType(Class<?> clazz);
	<T> T getFirstNodeAs(Class<T> clazz);
	
	<T> List<T> getSelectedNodesByType(Class<T> clazz);

}
