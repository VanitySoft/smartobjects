/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.impl;

import com.whizzosoftware.smartobjects.AbstractSmartObject;
import com.whizzosoftware.smartobjects.resource.ResourceConstants;

/**
 * The IPSO Digital Output object.
 *
 * From the spec: A generic object that can be used with any kind of digital output interface.
 *
 * @author Dan Noguerol
 */
public class DigitalOutput extends AbstractSmartObject {
    public static final int ID = 3201;
    public static final String URN = "urn:oma:lwm2m:ext:3201";

    public DigitalOutput(int instanceId) {
        this(instanceId, null);
    }

    public DigitalOutput(int instanceId, Boolean state) {
        super(ID, instanceId, URN);
        setState(state);
    }

    public void setState(Boolean state) {
        setResourceValue(ResourceConstants.DigitalOutputState, 0, state);
    }

    public void setPolarity(Boolean value) {
        setResourceValue(ResourceConstants.DigitalOutputPolarity, 0, value);
    }

    public void setApplicationType(String type) {
        setResourceValue(ResourceConstants.ApplicationType, 0, type);
    }
}
