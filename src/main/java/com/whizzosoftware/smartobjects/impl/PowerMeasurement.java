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
 * The IPSO Power Measurment object.
 *
 * From the spec: Should be used with a power measurement sensor to report a power measurement.
 * It also provides resources for minimum/maximum measured values and the minimum/maximum range
 * for both active and reactive power. It also provides resources for cumulative energy,
 * calibration and the power factor.
 *
 * @author Dan Noguerol
 */
public class PowerMeasurement extends AbstractSmartObject {
    public static final int ID = 3305;
    public static final String URN = "urn:oma:lwm2m:ext:3305";

    public PowerMeasurement(int instanceId) throws InvalidResourceException {
        this(instanceId, null);
    }

    public PowerMeasurement(int instanceId, Float instantaneousActivePower) throws InvalidResourceException {
        super(ID, instanceId, URN);
        setInstantaneousActivePower(instantaneousActivePower);
    }

    public void setInstantaneousActivePower(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.InstantaneousActivePower, 0, value);
    }

    public void setMinMeasuredActivePower(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.MinMeasuredActivePower, 0, value);
    }

    public void setMaxMeasuredActivePower(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.MaxMeasuredActivePower, 0, value);
    }

    public void setMinRangeActivePower(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.MinRangeActivePower, 0, value);
    }

    public void setMaxRangeActivePower(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.MaxRangeActivePower, 0, value);
    }

    public void setCumulativeActivePower(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.CumulativeActivePower, 0, value);
    }

    public void setActivePowerCalibration(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.ActivePowerCalibration, 0, value);
    }

    public void setInstantaneousReactivePower(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.InstantaneousReactivePower, 0, value);
    }

    public void setMinMeasuredReactivePower(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.MinMeasuredReactivePower, 0, value);
    }

    public void setMaxMeasuredReactivePower(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.MaxMeasuredReactivePower, 0, value);
    }

    public void setMinRangeReactivePower(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.MinRangeReactivePower, 0, value);
    }

    public void setMaxRangeReactivePower(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.MaxRangeReactivePower, 0, value);
    }

    public void setCumulativeReactivePower(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.CumulativeReactivePower, 0, value);
    }

    public void setPowerFactor(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.PowerFactor, 0, value);
    }

    public void setCurrentCalibration(Float value) throws InvalidResourceException {
        setResourceValue(ResourceConstants.CurrentCalibration, 0, value);
    }
}
