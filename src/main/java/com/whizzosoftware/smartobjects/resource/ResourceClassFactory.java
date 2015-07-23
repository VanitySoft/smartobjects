/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.resource;

import com.whizzosoftware.smartobjects.AccessType;
import com.whizzosoftware.smartobjects.resource.validate.FloatRangeValidator;
import com.whizzosoftware.smartobjects.resource.validate.IntegerRangeValidator;

import java.util.HashMap;
import java.util.Map;

public class ResourceClassFactory {
    static private Map<Integer,ResourceClass> classMap = new HashMap<Integer,ResourceClass>();

    static {
        classMap.put(ResourceConstants.AnalogInputCurrentValue, new ResourceClass(ResourceConstants.AnalogInputCurrentValue, AccessType.ReadOnly, ResourceType.Float, new FloatRangeValidator(0, 100)));
        classMap.put(ResourceConstants.AnalogOutputCurrentValue, new ResourceClass(ResourceConstants.AnalogOutputCurrentValue, AccessType.ReadOnly, ResourceType.Float, new FloatRangeValidator(0, 100)));
        classMap.put(ResourceConstants.AvgLoadAdjPct, new ResourceClass(ResourceConstants.AvgLoadAdjPct, AccessType.ReadWrite, ResourceType.Integer, new IntegerRangeValidator(0, 100)));
        classMap.put(ResourceConstants.CompassDirection, new ResourceClass(ResourceConstants.CompassDirection, AccessType.ReadOnly, ResourceType.Float, new FloatRangeValidator(0, 360)));
        classMap.put(ResourceConstants.CriticalityLevel, new ResourceClass(ResourceConstants.CriticalityLevel, AccessType.ReadWrite, ResourceType.Integer, new IntegerRangeValidator(0, 3)));
        classMap.put(ResourceConstants.DigitalInputCounter, new ResourceClass(ResourceConstants.DigitalInputCounter, AccessType.ReadOnly, ResourceType.Integer));
        classMap.put(ResourceConstants.DigitalInputCounterReset, new ResourceClass(ResourceConstants.DigitalInputCounterReset, AccessType.ReadWrite, ResourceType.Opaque));
        classMap.put(ResourceConstants.DigitalInputDebouncePeriodInMs, new ResourceClass(ResourceConstants.DigitalInputDebouncePeriodInMs, AccessType.ReadWrite, ResourceType.Integer));
        classMap.put(ResourceConstants.DigitalInputEdgeSelection, new ResourceClass(ResourceConstants.DigitalInputEdgeSelection, AccessType.ReadWrite, ResourceType.Integer, new IntegerRangeValidator(1, 3)));
        classMap.put(ResourceConstants.DigitalInputPolarity, new ResourceClass(ResourceConstants.DigitalInputPolarity, AccessType.ReadWrite, ResourceType.Boolean));
        classMap.put(ResourceConstants.DigitalInputState, new ResourceClass(ResourceConstants.DigitalInputState, AccessType.ReadOnly, ResourceType.Boolean));
        classMap.put(ResourceConstants.DigitalOutputPolarity, new ResourceClass(ResourceConstants.DigitalOutputPolarity, AccessType.ReadWrite, ResourceType.Boolean));
        classMap.put(ResourceConstants.DigitalOutputState, new ResourceClass(ResourceConstants.DigitalOutputState, AccessType.ReadWrite, ResourceType.Boolean));
        classMap.put(ResourceConstants.DutyCycle, new ResourceClass(ResourceConstants.DutyCycle, AccessType.ReadWrite, ResourceType.Integer, new IntegerRangeValidator(0, 100)));
        classMap.put(ResourceConstants.Dimmer, new ResourceClass(ResourceConstants.Dimmer, AccessType.ReadWrite, ResourceType.Integer, new IntegerRangeValidator(0, 100)));
        classMap.put(ResourceConstants.SensorValue, new ResourceClass(ResourceConstants.SensorValue, AccessType.ReadOnly, ResourceType.Float));
        classMap.put(ResourceConstants.Units, new ResourceClass(ResourceConstants.Units, AccessType.ReadOnly, ResourceType.UCUMCode));
    }

    static public ResourceClass getResourceClass(int resourceId) {
        ResourceClass rc = classMap.get(resourceId);
        if (rc != null) {
            return rc;
        } else {
            throw new RuntimeException("Unknown resource class ID: " + resourceId);
        }
    }
}
