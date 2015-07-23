/*******************************************************************************
 * Copyright (c) 2015 Whizzo Software, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.whizzosoftware.smartobjects.object;

import com.whizzosoftware.smartobjects.object.impl.*;

public class SmartObjectFactory {
    public static SmartObject newObjectInstance(int id, int instanceId) {
        switch (id) {
            case AnalogInput.ID:
                return new AnalogInput(instanceId);
            case AnalogOutput.ID:
                return new AnalogOutput(instanceId);
            case DigitalInput.ID:
                return new DigitalInput(instanceId);
            case DigitalOutput.ID:
                return new DigitalOutput(instanceId);
            case GenericSensor.ID:
                return new GenericSensor(instanceId);
            case Humidity.ID:
                return new Humidity(instanceId);
            case Illuminance.ID:
                return new Illuminance(instanceId);
            case SetPoint.ID:
                return new SetPoint(instanceId);
            case Temperature.ID:
                return new Temperature(instanceId);
            default:
                return null;
        }
    }
}
