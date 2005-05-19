/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - Initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.server.core.tests.model;

import junit.framework.Test;
import junit.framework.TestCase;

import org.eclipse.wst.server.core.internal.IModuleListener;
import org.eclipse.wst.server.core.tests.OrderedTestSuite;
import org.eclipse.wst.server.core.tests.impl.TestModuleListener;

public class ModuleListenerTestCase extends TestCase {
	protected static IModuleListener listener;

	public static Test suite() {
		return new OrderedTestSuite(ModuleListenerTestCase.class, "ModuleListenerTestCase");
	}

	public void test00CreateListener() throws Exception {
		listener = new TestModuleListener();
	}
	
	public void test01ModuleChanged() throws Exception {
		listener.moduleChanged(null);
	}
}