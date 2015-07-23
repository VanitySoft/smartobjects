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
 * The IPSO Illuminance object.
 *
 * From the spec: Should be used with an illuminance (light intensity) sensor to report an
 * illuminance measurement. It also provides resources for minimum/maximum measured values and
 * the minimum/maximum range that can be measured by the sensor. An example measurement unit is
 * Lux (ucum:lx).
 *
 * @author Dan Noguerol
 */
public class Illuminance extends AbstractSensor {
    public static final int ID = 3301;
    public static final String URN = "urn:oma:lwm2m:ext:3301";

    public Illuminance(int instanceId) throws InvalidResourceException {
        this(instanceId, null);
    }

    public Illuminance(int instanceId, Float value) throws InvalidResourceException {
        super(ID, instanceId, URN, value);
    }
}
