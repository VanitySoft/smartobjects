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
 * The IPSO Digital Input object.
 *
 * From the spec: A generic object that can be used with any kind of digital input interface.
 *
 * @author Dan Noguerol
 */
public class DigitalInput extends AbstractSmartObject {
    public static final int ID = 3200;
    public static final String URN = "urn:oma:lwm2m:ext:3200";

    public DigitalInput(int instanceId) throws InvalidResourceException {
        this(instanceId, null);
    }

    public DigitalInput(int instanceId, Boolean value) throws InvalidResourceException {
        super(ID, instanceId, URN);
        setState(value);
    }

    public void setState(Boolean value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.DigitalInputState, 0, value);
    }

    public void setCounter(Integer value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.DigitalInputCounter, 0, value);
    }

    public void setPolarity(Boolean value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.DigitalInputPolarity, 0, value);
    }

    public void setDebouncePeriodInMs(Integer value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.DigitalInputDebouncePeriodInMs, 0, value);
    }

    public void setInputEdgeSelection(Integer value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.DigitalInputEdgeSelection, 0, value);
    }

    public void setCounterReset() throws InvalidResourceException {
        setResourceValue(ResourceConstants.DigitalInputCounterReset, 0, null);
    }

    public void setApplicationType(String value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.ApplicationType, 0, value);
    }

    public void setSensorType(String value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.SensorType, 0, value);
    }
}
