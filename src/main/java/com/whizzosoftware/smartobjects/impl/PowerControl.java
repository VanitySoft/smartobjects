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
 * The IPSO Power Control object.
 *
 * From the spec: Used to control a power source, such as a Smart Plug. It allows a power relay
 * to be turned on or off and its dimmer setting to be control as a % between 0 and 100.
 *
 * @author Dan Noguerol
 */
public class PowerControl extends AbstractSmartObject {
    public static final int ID = 3312;
    public static final String URN = "urn:oma:lwm2m:ext:3312";

    public PowerControl(int instanceId) throws InvalidResourceException {
        this(instanceId, null);
    }

    public PowerControl(int instanceId, Boolean onOff) throws InvalidResourceException {
        super(ID, instanceId, URN);
        setOnOff(onOff);
    }

    public void setOnOff(Boolean value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.OnOff, 0, value);
    }

    public void setDimmer(Integer value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.Dimmer, 0, value);
    }

    public void setOnTime(Integer value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.OnTime, 0, value);
    }

    public void setCumulativeReactivePower(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.CumulativeReactivePower, 0, value);
    }

    public void setPowerFactor(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.PowerFactor, 0, value);
    }
}
