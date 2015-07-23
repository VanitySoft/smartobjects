/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.object.impl;

import com.whizzosoftware.smartobjects.resource.ResourceConstants;

public class GenericSensor extends AbstractSensor {
    public static final int ID = 3300;
    public static final String URN = "urn:oma:lwm2m:ext:3300";

    public GenericSensor(int instanceId) {
        this(instanceId, null);
    }

    public GenericSensor(int instanceId, Float value) {
        super(ID, instanceId, URN, value);
    }

    public void setApplicationType(String type) {
        setResourceValue(ResourceConstants.ApplicationType, 0, type);
    }

    public void setSensorType(String type) {
        setResourceValue(ResourceConstants.SensorType, 0, type);
    }
}
