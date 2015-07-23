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
 * The IPSO Presence object.
 *
 * From the spec: Should be used with a presence sensor to report presence detection. It also
 * provides resources to manage a counter, the type of sensor used (e.g. the technology of the
 * probe), and configuration for the delay between busy and clear detection state.
 *
 * @author Dan Noguerol
 */
public class Presence extends AbstractSmartObject {
    public static final int ID = 3302;
    public static final String URN = "urn:oma:lwm2m:ext:3302";

    public Presence(int instanceId) throws InvalidResourceException {
        this(instanceId, null);
    }

    public Presence(int instanceId, Boolean value) throws InvalidResourceException {
        super(ID, instanceId, URN);
        setDigitalInputState(value);
    }

    public void setDigitalInputState(Boolean value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.DigitalInputState, 0, value);
    }

    public void setDigitalInputCounter(Integer value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.DigitalInputCounter, 0, value);
    }

    public void setBusyToClearDelay(Integer value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.BusyToClearDelay, 0, value);
    }

    public void setClearToBusyDelay(Integer value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.ClearToBusyDelay, 0, value);
    }
}
