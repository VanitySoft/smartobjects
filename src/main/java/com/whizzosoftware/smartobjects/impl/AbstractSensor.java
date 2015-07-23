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

public class AbstractSensor extends AbstractSmartObject {
    public AbstractSensor(int id, int instanceId, String urn, Float value) throws InvalidResourceException {
        super(id, instanceId, urn);
        setValue(value);
    }

    public void setValue(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.SensorValue, 0, value);
    }

    public void setUnits(String units) throws InvalidResourceException {
        setResourceValue(ResourceConstants.Units, 0, units);
    }

    public void setMinMeasuredValue(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.MinMeasuredValue, 0, value);
    }

    public void setMaxMeasuredValue(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.MaxMeasuredValue, 0, value);
    }

    public void setMinRangeValue(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.MinRangeValue, 0, value);
    }

    public void setMaxRangeValue(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.MaxRangeValue, 0, value);
    }
}
