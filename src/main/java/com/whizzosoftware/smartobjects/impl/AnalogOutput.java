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
 * The IPSO Analog Output object.
 *
 * From the spec: A generic object that can be used with any kind of analog output interface.
 *
 * @author Dan Noguerol
 */
public class AnalogOutput extends AbstractSmartObject {
    public static final int ID = 3203;
    public static final String URN = "urn:oma:lwm2m:ext:3203";

    public AnalogOutput(int instanceId) throws InvalidResourceException {
        this(instanceId, null);
    }

    public AnalogOutput(int instanceId, Float value) throws InvalidResourceException {
        super(ID, instanceId, URN);
        setOutputCurrentValue(value);
    }

    public void setOutputCurrentValue(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.AnalogOutputCurrentValue, 0, value);
    }

    public void setMinRangeValue(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.MinRangeValue, 0, value);
    }

    public void setMaxRangeValue(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.MaxRangeValue, 0, value);
    }

    public void setApplicationType(String type) throws InvalidResourceException {
        setResourceValue(ResourceConstants.ApplicationType, 0, type);
    }
}
