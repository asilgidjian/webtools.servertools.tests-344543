/**********************************************************************
 * Copyright (c) 2004 IBM Corporation and others.
 * All rights reserved. � This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 �*
 * Contributors:
 *    IBM - Initial API and implementation
 **********************************************************************/

package org.eclipse.jst.server.tomcat.tests.performance.tomcat50;

import java.io.File;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jst.server.tomcat.core.ITomcatRuntimeWorkingCopy;
import org.eclipse.wst.server.core.IRuntimeWorkingCopy;
import org.eclipse.wst.server.core.ServerCore;
import org.eclipse.wst.server.tests.performance.common.AbstractGetDelegateTestCase;

public class GetDelegateTestCase extends AbstractGetDelegateTestCase
{
  public static Test suite()
  {
    return new TestSuite(GetDelegateTestCase.class, "GetDelegateTestCase");
  }

  protected IRuntimeWorkingCopy createRuntime(String runtimeTypeId, String runtimeTypeLocaiton) throws CoreException
  {
    IRuntimeWorkingCopy runtimeCopy = ServerCore.getRuntimeType(runtimeTypeId).createRuntime(runtimeTypeId);
    runtimeCopy.setLocation(new Path(runtimeTypeLocaiton));
    runtimeCopy.setLocked(false);
    runtimeCopy.setTestEnvironment(true);
    IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
    ((ITomcatRuntimeWorkingCopy)runtimeCopy.getWorkingCopyDelegate()).setVMInstall(vmInstall.getVMInstallType().getId(), vmInstall.getId());
    runtimeCopy.save(null);
    return runtimeCopy;
  }

  protected String getRuntimeTypeId()
  {
    return "org.eclipse.jst.server.tomcat.50.runtime";
  }

  protected String getRuntimeTypeLocation()
  {
    String location = System.getProperty("org.eclipse.jst.server.tomcat.50");
    assertNotNull(location);
    assertTrue((new File(location)).exists());
    return location;
  }

  protected String getServerTypeId()
  {
    return "org.eclipse.jst.server.tomcat.50";
  }
}