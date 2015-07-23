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
 * The IPSO Light Control object.
 *
 * From the spec: Used to control a light source, such as a LED or other light. It allows a light
 * to be turned on or off and its dimmer setting to be control as a % between 0 and 100. An optional
 * colour setting enables a string to be used to indicate the desired colour.
 *
 * @author Dan Noguerol
 */
public class LightControl extends AbstractSmartObject {
    public static final int ID = 3311;
    public static final String URN = "urn:oma:lwm2m:ext:3311";

    public LightControl(int instanceId) {
        this(instanceId, null);
    }

    public LightControl(int instanceId, Boolean onOff) {
        super(ID, instanceId, URN);
        setOnOff(onOff);
    }

    public void setOnOff(Boolean value) {
        setResourceValue(ResourceConstants.OnOff, 0, value);
    }

    public void setDimmer(Integer value) {
        setResourceValue(ResourceConstants.Dimmer, 0, value);
    }

    /**
     * Sets the colour of the light.
     *
     * @param value A string representing a value in some colour space. Defined by the units resource.
     */
    public void setColour(String value) {
        setResourceValue(ResourceConstants.Colour, 0, value);
    }

    public void setUnits(String value) {
        setResourceValue(ResourceConstants.Units, 0, value);
    }

    public void setOnTime(Integer value) {
        setResourceValue(ResourceConstants.OnTime, 0, value);
    }

    public void setCumulativeReactivePower(Float value) {
        setResourceValue(ResourceConstants.CumulativeReactivePower, 0, value);
    }

    public void setPowerFactor(Float value) {
        setResourceValue(ResourceConstants.PowerFactor, 0, value);
    }
}
