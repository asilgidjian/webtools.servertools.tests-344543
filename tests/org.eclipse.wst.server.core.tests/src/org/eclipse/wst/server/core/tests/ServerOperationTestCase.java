/*******************************************************************************
 * Copyright (c) 2005, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - Initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.server.core.tests;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.wst.server.core.IServer;
import junit.framework.TestCase;

public class ServerOperationTestCase extends TestCase {
	protected static IServer.IOperationListener listener;

	protected IServer.IOperationListener getListener() {
		if (listener == null) {
			listener = new IServer.IOperationListener() {
				public void done(IStatus result) {
					// ignore
				}
			};
		}
		return listener;
	}
	
	public void testCreate() throws Exception {
		getListener();
	}

	public void testDone() throws Exception {
		getListener().done(null);
	}
}