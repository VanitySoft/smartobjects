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
 * The IPSO Humidity object.
 *
 * From the spec: Should be used with a humidity sensor to report humidity measurement. It also
 * provides resources for minimum/maximum measured values and the minimum/maximum range that
 * can be measured by the humidity sensor. An example measurement is relative humidity as a
 * percentage (ucum:%).
 *
 * @author Dan Noguerol
 */
public class Humidity extends AbstractSensor {
    public static final int ID = 3304;
    public static final String URN = "urn:oma:lwm2m:ext:3304";

    public Humidity(int instanceId) throws InvalidResourceException {
        this(instanceId, null);
    }

    public Humidity(int instanceId, Float value) throws InvalidResourceException {
        super(ID, instanceId, URN, value);
    }
}
