/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.impl;

import com.whizzosoftware.smartobjects.resource.InvalidResourceException;
import com.whizzosoftware.smartobjects.resource.ResourceConstants;

/**
 * The IPSO Generic Sensor object.
 *
 * From the spec: Allows the description of a generic sensor. It is based on the description of
 * a value and measurement units according to the UCUM specification. Thus, any type of value
 * defined within the UCUM specification can be reported using this object.
 *
 * @author Dan Noguerol
 */
public class GenericSensor extends AbstractSensor {
    public static final int ID = 3300;
    public static final String URN = "urn:oma:lwm2m:ext:3300";

    public GenericSensor(int instanceId) throws InvalidResourceException {
        this(instanceId, null);
    }

    public GenericSensor(int instanceId, Float value) throws InvalidResourceException {
        super(ID, instanceId, URN, value);
    }

    public void setApplicationType(String type) throws InvalidResourceException {
        setResourceValue(ResourceConstants.ApplicationType, 0, type);
    }

    public void setSensorType(String type) throws InvalidResourceException {
        setResourceValue(ResourceConstants.SensorType, 0, type);
    }
}
