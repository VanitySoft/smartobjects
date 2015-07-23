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
 * The IPSO Load Control object.
 *
 * From the spec: Used for demand-response load control and other load control in automation
 * applications (not limited to power).
 *
 * @author Dan Noguerol
 */
public class LoadControl extends AbstractSmartObject {
    public static final int ID = 3310;
    public static final String URN = "urn:oma:lwm2m:ext:3310";

    public LoadControl(int instanceId) {
        this(instanceId, null, null, null);
    }

    public LoadControl(int instanceId, String eventIdentifier, Long startTime, Integer durationInMinutes) {
        super(ID, instanceId, URN);
        setEventIdentifier(eventIdentifier);
        setStartTime(startTime);
        setDurationInMinutes(durationInMinutes);
    }

    public void setEventIdentifier(String value) {
        setResourceValue(ResourceConstants.EventIdentifier, 0, value);
    }

    public void setStartTime(long value) {
        setResourceValue(ResourceConstants.StartTime, 0, value);
    }

    public void setDurationInMinutes(Integer value) {
        setResourceValue(ResourceConstants.DurationInMin, 0, value);
    }

    public void setCriticalityLevel(Integer value) {
        setResourceValue(ResourceConstants.CriticalityLevel, 0, value);
    }

    public void setAvgLoadAdjPct(Integer value) {
        setResourceValue(ResourceConstants.AvgLoadAdjPct, 0, value);
    }

    public void setDutyCycle(Integer value) {
        setResourceValue(ResourceConstants.DutyCycle, 0, value);
    }
}
