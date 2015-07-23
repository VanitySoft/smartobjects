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
 * The IPSO Set Point object.
 *
 * From the spec: Should be used to set a desired value to a controller, such as a thermostat.
 * This object enables a setpoint to be expressed units defined in the UCUM specification, to
 * match an associated sensor or measurement value. A special resource is added to set the colour
 * of an object.
 *
 * @author Dan Noguerol
 */
public class SetPoint extends AbstractSmartObject {
    public static final int ID = 3308;
    public static final String URN = "urn:oma:lwm2m:ext:3308";

    public SetPoint(int instanceId) throws InvalidResourceException {
        this(instanceId, null);
    }

    public SetPoint(int instanceId, Float value) throws InvalidResourceException {
        super(ID, instanceId, URN);
        setValue(value);
    }

    public void setValue(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.SetPointValue, 0, value);
    }

    public void setColour(String value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.Colour, 0, value);
    }

    public void setUnits(String units) throws InvalidResourceException {
        setResourceValue(ResourceConstants.Units, 0, units);
    }

    public void setApplicationType(String type) throws InvalidResourceException {
        setResourceValue(ResourceConstants.ApplicationType, 0, type);
    }
}
