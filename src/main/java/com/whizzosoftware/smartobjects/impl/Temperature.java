/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.impl;

import com.whizzosoftware.smartobjects.resource.InvalidResourceException;

/**
 * The IPSO Temperature object.
 *
 * From the spec: Should be used with a temperature sensor to report a temperature measurement.
 * It also provides resources for minimum/maximum measured values and the minimum/maximum range
 * that can be measured by the temperature sensor. An example measurement unit is degrees
 * Celsius (ucum:Cel).
 *
 * @author Dan Noguerol
 */
public class Temperature extends AbstractSensor {
    public static final int ID = 3303;
    public static final String URN = "urn:oma:lwm2m:ext:3303";

    public Temperature(int instanceId) throws InvalidResourceException {
        this(instanceId, null);
    }

    public Temperature(int instanceId, Float value) throws InvalidResourceException {
        super(ID, instanceId, URN, value);
        setValue(value);
    }
}
