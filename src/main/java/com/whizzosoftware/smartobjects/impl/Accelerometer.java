/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.impl;

import com.whizzosoftware.smartobjects.AbstractSmartObject;
import com.whizzosoftware.smartobjects.resource.InvalidResourceException;
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

    public Accelerometer(int instanceId) throws InvalidResourceException {
        this(instanceId, null);
    }

    public Accelerometer(int instanceId, Float xValue) throws InvalidResourceException {
        super(ID, instanceId, URN);
        setXValue(xValue);
    }

    public void setXValue(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.XValue, 0, value);
    }

    public void setYValue(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.YValue, 0, value);
    }

    public void setZValue(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.ZValue, 0, value);
    }

    public void setUnits(String value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.Units, 0, value);
    }

    public void setMinRangeValue(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.MinRangeValue, 0, value);
    }

    public void setMaxRangeValue(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.MaxRangeValue, 0, value);
    }
}
