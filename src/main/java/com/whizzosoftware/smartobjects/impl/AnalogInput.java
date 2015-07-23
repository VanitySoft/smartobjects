/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.impl;

import com.whizzosoftware.smartobjects.AbstractSmartObject;
import com.whizzosoftware.smartobjects.resource.ResourceConstants;

public class AnalogInput extends AbstractSmartObject {
    public static final int ID = 3202;
    public static final String URN = "urn:oma:lwm2m:ext:3202";

    public AnalogInput(int instanceId) {
        this(instanceId, null);
    }

    public AnalogInput(int instanceId, Float initialValue) {
        super(ID, instanceId, URN);
        setResourceValue(ResourceConstants.AnalogInputCurrentValue, instanceId, initialValue);
    }
}
