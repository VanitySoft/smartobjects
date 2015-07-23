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

/**
 * The IPSO Accelerometer object.
 *
 * From the spec: Used to present a 1-3 axis accelerometer.
 *
 * @author Dan Noguerol
 */
public class Accelerometer extends AbstractSmartObject {
    public static final int ID = 3313;
    public static final String URN = "urn:oma:lwm2m:ext:3313";

    public Accelerometer(int instanceId) {
        this(instanceId, null);
    }

    public Accelerometer(int instanceId, Float xValue) {
        super(ID, instanceId, URN);
        setXValue(xValue);
    }

    public void setXValue(Float value) {
        setResourceValue(ResourceConstants.XValue, 0, value);
    }

    public void setYValue(Float value) {
        setResourceValue(ResourceConstants.YValue, 0, value);
    }

    public void setZValue(Float value) {
        setResourceValue(ResourceConstants.ZValue, 0, value);
    }

    public void setUnits(String value) {
        setResourceValue(ResourceConstants.Units, 0, value);
    }

    public void setMinRangeValue(Float value) {
        setResourceValue(ResourceConstants.MinRangeValue, 0, value);
    }

    public void setMaxRangeValue(Float value) {
        setResourceValue(ResourceConstants.MaxRangeValue, 0, value);
    }
}
