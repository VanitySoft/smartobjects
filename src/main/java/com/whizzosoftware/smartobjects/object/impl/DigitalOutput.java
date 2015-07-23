/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.object.impl;

import com.whizzosoftware.smartobjects.object.AbstractSmartObject;
import com.whizzosoftware.smartobjects.resource.ResourceConstants;

public class DigitalOutput extends AbstractSmartObject {
    public static final int ID = 3201;
    public static final String URN = "urn:oma:lwm2m:ext:3201";

    public DigitalOutput(int instanceId) {
        this(instanceId, null);
    }

    public DigitalOutput(int instanceId, Boolean state) {
        super(ID, instanceId, URN);
        setState(state);
    }

    public void setState(Boolean state) {
        setResourceValue(ResourceConstants.DigitalOutputState, 0, state);
    }

    public void setPolarity(Boolean value) {
        setResourceValue(ResourceConstants.DigitalOutputPolarity, 0, value);
    }
}
