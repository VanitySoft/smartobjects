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
 * The IPSO Analog Input object.
 *
 * From the spec: A generic object that can be used with any kind of analog input interface.
 *
 * @author Dan Noguerol
 */
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

    public void setInputCurrentValue(Float value) {
        setResourceValue(ResourceConstants.AnalogInputCurrentValue, 0, value);
    }

    public void setMinMeasuredValue(Float value) {
        setResourceValue(ResourceConstants.MinMeasuredValue, 0, value);
    }

    public void setMaxMeasuredValue(Float value) {
        setResourceValue(ResourceConstants.MaxMeasuredValue, 0, value);
    }

    public void setMinRangeValue(Float value) {
        setResourceValue(ResourceConstants.MinRangeValue, 0, value);
    }

    public void setMaxRangeValue(Float value) {
        setResourceValue(ResourceConstants.MaxRangeValue, 0, value);
    }

    public void setApplicationType(String type) {
        setResourceValue(ResourceConstants.ApplicationType, 0, type);
    }

    public void setSensorType(String type) {
        setResourceValue(ResourceConstants.SensorType, 0, type);
    }
}
