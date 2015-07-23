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
 * The IPSO Actuation object.
 *
 * From the spec: Dedicated to remote actuation such as ON/OFF action or dimming. A
 * multi-state output can also be described as a string. This is useful to send pilot wire orders
 * for instance. It also provides a resource to reflect the time that the device has been
 * switched on.
 *
 * @author Dan Noguerol
 */
public class Actuation extends AbstractSmartObject {
    public static final int ID = 3306;
    public static final String URN = "urn:oma:lwm2m:ext:3306";

    public Actuation(int instanceId) throws InvalidResourceException {
        this(instanceId, null);
    }

    public Actuation(int instanceId, Boolean onOff) throws InvalidResourceException {
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

    public void setMultiStateOutput(String value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.MultiStateOutput, 0, value);
    }

    public void setApplicationType(String value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.ApplicationType, 0, value);
    }
}
