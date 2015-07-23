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

public class DigitalInput extends AbstractSmartObject {
    public static final int ID = 3200;
    public static final String URN = "urn:oma:lwm2m:ext:3200";

    public DigitalInput(int instanceId) {
        this(instanceId, null);
    }

    public DigitalInput(int instanceId, Boolean value) {
        super(ID, instanceId, URN);
        setState(value);
    }

    public void setState(Boolean value) {
        setResourceValue(ResourceConstants.DigitalInputState, 0, value);
    }

    public void setCounter(Integer value) {
        setResourceValue(ResourceConstants.DigitalInputCounter, 0, value);
    }

    public void setPolarity(Boolean value) {
        setResourceValue(ResourceConstants.DigitalInputPolarity, 0, value);
    }

    public void setDebouncePeriod(Integer value) {
        setResourceValue(ResourceConstants.DigitalInputDebouncePeriod, 0, value);
    }

    public void setInputEdgeSelection(Integer value) {
        setResourceValue(ResourceConstants.DigitalInputEdgeSelection, 0, value);
    }

    public void setCounterReset() {
        setResourceValue(ResourceConstants.DigitalInputCounterReset, 0, null);
    }

    public void setApplicationType(String value) {
        setResourceValue(ResourceConstants.ApplicationType, 0, value);
    }

    public void setSensorType(String value) {
        setResourceValue(ResourceConstants.SensorType, 0, value);
    }
}
