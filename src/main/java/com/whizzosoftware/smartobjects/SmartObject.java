/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects;

import com.whizzosoftware.smartobjects.resource.Resource;

import java.util.Collection;

public interface SmartObject {
    int getId();
    int getInstanceId();
    String getUrn();
    Collection<Resource> getResources();
    Resource getResource(int id, int instanceId);
    void setResourceValue(int resourceId, int instanceId, Object value);
}
